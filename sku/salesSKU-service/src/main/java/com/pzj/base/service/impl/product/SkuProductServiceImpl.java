package com.pzj.base.service.impl.product;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pzj.product.vo.voParam.queryParam.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductCombineRelation;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.entity.product.ProductSiteRelation;
import com.pzj.base.service.exception.SkuAddException;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.exception.SkuSaveException;
import com.pzj.base.service.exception.SkuSearchException;
import com.pzj.base.service.exception.SkuServiceException;
import com.pzj.base.service.exception.SkuStockException;
import com.pzj.base.service.impl.strategy.SysSpcreRelationService;
import com.pzj.base.service.model.modificationParam.ProductInfoModification;
import com.pzj.base.service.product.IProductCloseTimeslotService;
import com.pzj.base.service.product.IProductCombineRelationService;
import com.pzj.base.service.product.IProductInfoSearchService;
import com.pzj.base.service.product.IProductInfoService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductReleaseService;
import com.pzj.base.service.product.IProductRondaRelationService;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.base.service.product.IProductSearchService;
import com.pzj.base.service.product.IProductSiteDataService;
import com.pzj.base.service.product.IProductSiteRelationService;
import com.pzj.base.service.product.ISettlementSearchService;
import com.pzj.base.service.product.IStrategySearchService;
import com.pzj.channel.Channel;
import com.pzj.channel.SettlementRule;
import com.pzj.channel.Strategy;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.exception.ServiceException;
import com.pzj.product.service.ISkuProductService;
import com.pzj.product.vo.JsonSkuDto;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SkuProductScenic;
import com.pzj.product.vo.product.SkuRondaRelation;
import com.pzj.product.vo.product.SkuSiteData;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.modificationParam.SkuPriceModificationVO;
import com.pzj.product.vo.voParam.modificationParam.SpuProductModificationVO;
import com.pzj.product.vo.voParam.resultParam.PCAddressResult;
import com.pzj.product.vo.voParam.resultParam.SkuCanSaledResult;
import com.pzj.product.vo.voParam.resultParam.SkuImportResult;
import com.pzj.product.vo.voParam.resultParam.SkuProductForScenic;
import com.pzj.product.vo.voParam.resultParam.SkuProductResultVO;
import com.pzj.product.vo.voParam.resultParam.SpuProductBasicInfoResult;
import com.pzj.product.vo.voParam.resultParam.SpuProductResultVO;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.ProductCheckUtil;
import com.pzj.util.productConvertUtil.ProductConvert;
import com.pzj.util.productConvertUtil.ProductSetValueUtil;

@Service
@Lazy
public class SkuProductServiceImpl implements ISkuProductService {

	protected Logger logger = LoggerFactory
			.getLogger(ProductReleaseServiceImpl.class);

	@Autowired
	IProductInfoService productInfoService;

	@Autowired
	IProductReleaseService productReleaseService;

	@Autowired
	IProductInfoSearchService productInfoSearchService;

	@Autowired
	IProductRelationService productRelationService;

	@Autowired
	IProductCloseTimeslotService productCloseTimeslotService;

	@Autowired
	IProductSiteRelationService productSiteReletionService;

	@Autowired
	IProductRondaRelationService productRondaRelationService;

	@Autowired
	IProductCombineRelationService productCombineRelationService;
	@Autowired
	IProductSearchService productSearchService;

	@Autowired
	IStrategySearchService strategySearchService;

	@Autowired
	ISettlementSearchService settlementSearchService;

	@Autowired
	ProductSearchServiceUtil productSearchServiceUtil;

	@Autowired
	IProductScenicService productScenicService;

	@Autowired
	IProductSiteDataService productSiteDataService;

	@Autowired
	RebateStrategySearchUtil rebateStrategySearchUtil;

	@Autowired
	StrategySearchServiceUtil strategySearchServiceUtil;

	@Autowired
	SysSpcreRelationService sysSpcreRelationService;

	private Long importSku(JsonSkuDto dto) {

		Long result = 0l;
		int hashCode = dto.hashCode();
		List<Integer> haveCode = productInfoSearchService
				.queryHashCodeForUpdate(hashCode);
		if (CollectionUtils.isEmpty(haveCode)) {
			// 原来sku产品先下架
			exportSku(new BigDecimal(dto.getBaseInfo().getId()).longValue());

			// 新产品上架
			result = addProduct(ProductConvert.convertTProduct(dto));
		} else {
			throw new SkuAddException("产品数据:{" + dto.toString() + "}已存在，上架失败");
		}
		return result;

	}

	@Override
	public Result<SkuImportResult> importSku(List<JsonSkuDto> list) {
		Result<SkuImportResult> result = new Result<SkuImportResult>();
		try {
			if (list == null || list.isEmpty()) {
				throw new SkuParamNullException("产品上架参数为空，上架失败");
			}
			List<Long> productIdList = new ArrayList<Long>();
			for (JsonSkuDto dto : list) {
				Long productId = importSku(dto);
				productIdList.add(productId);
			}
		} catch (SkuServiceException e) {
			logger.error(e.getMessage(), e);
			CommonConvert.combinationTResult(result, e);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			SkuServiceException ex = new SkuServiceException("产品上架失败", e);
			CommonConvert.combinationTResult(result, ex);
		} finally {
		}

		return result;
	}

	public Integer exportSku(Long skuId) {
		Integer result = 0;
		List<Long> infoIds = productInfoSearchService
				.queryIdBySkuIdForUpdate(skuId);
		if (CollectionUtils.isEmpty(infoIds)) {
			return result;
		}
		// 更新产品组状态为禁用
		result += productInfoService.modifyProductInfoState(GlobalParam.FLAG
				.off().toString(), infoIds);

		// 更新产品状态为禁用
		result += productReleaseService.modifyProductReleaseState(
				GlobalParam.FLAG.off().toString(), infoIds);

		return result;

	}

	@Override
	public Integer exportSku(List<Long> skuIdList) {
		if (CollectionUtils.isEmpty(skuIdList)) {
			throw new SkuParamNullException("产品下架参数为空，下架失败");
		}
		Integer result = 0;
		for (Long skuId : skuIdList) {
			result += exportSku(skuId);
		}

		return result;
	}

	public Long addSpuProductAndAuth(SpuProductModificationVO vo)
			throws Exception {
		try {

			if (vo == null) {
				throw new SkuParamNullException(
						"新建产品接口[addSpuProductAndAuth]：传入参数为空");
			}

			if (!vo.isSpuExist()) {
				throw new SkuParamNullException(
						"新建产品接口[createSkuProductAndAuth]：传入参数没有产品组信息");
			}
			ProductInfoModification model = ProductConvert
					.dissectSpuProductModificationVO(vo);
			return addProduct(model);

		} catch (ServiceException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new SkuAddException("产品新建[addSpuProductAndAuth]报错", ex);
		}
	}

	public Integer saveSpuProductAndAuth(SpuProductModificationVO vo) {
		Integer result = 0;
		try {
			if (vo == null) {
				throw new SkuParamNullException(
						"更新产品接口[saveSpuProductAndAuth]：传入参数为空");
			}

			if (!vo.isSpuExist()) {
				throw new SkuParamNullException(
						"更新产品接口[saveSpuProductAndAuth]：传入参数没有产品组信息");
			}

			ProductInfoModification model = ProductConvert
					.dissectSpuProductModificationVO(vo);
			return saveProduct(model);
		} catch (ServiceException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new SkuSaveException("产品更新[saveSpuProductAndAuth]报错", ex);
		}
	}

	@Override
	public Result<Long> adjustPriceForSku(SkuPriceModificationVO vo) {
		try {
			if (vo == null) {
				throw new SkuParamNullException(
						"产品改价接口[adjustPriceForSku]：没有传参");
			}

			if (vo.getSkuId() == null) {
				throw new SkuParamNullException(
						"产品改价接口[adjustPriceForSku]：没有传产品id");
			}

			if (vo.getNewPrice() == null) {
				throw new SkuParamNullException(
						"产品改价接口[adjustPriceForSku]：没有传新价格");
			}

			// 查询产品
			ProductRelease pr = productReleaseService.getById(vo.getSkuId());

			// 获取景区id集合
			List<Long> scenicIds = productRelationService
					.queryScenicIdByProductId(vo.getSkuId());

			// 获取景点id集合
			List<Long> siteList = productRelationService
					.querySiteIdByProductId(vo.getSkuId());

			// 获取场次区域id集合
			List<ProductRondaRelation> rondaList = productRondaRelationService
					.queryPRondaRelationByProductId(vo.getSkuId());

			// 禁用原产品
			productReleaseService.modifyPReleaseStateById(GlobalParam.FLAG
					.off().toString(), vo.getSkuId());

			// 新建新产品
			pr.setId(null);
			pr.setProductPrice(vo.getNewPrice());
			Long result = productReleaseService.addProduct(pr, rondaList,
					scenicIds, siteList);

			return new Result<Long>(result);

		} catch (ServiceException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new SkuSaveException("产品更新价格报错", ex);
		}
	}

	@Override
	public List<SkuCanSaledResult> isCanSaled(List<ProductSaledParam> paramList)
			throws Exception {
		if (CollectionUtils.isEmpty(paramList)) {
			this.logger.error("方法[isCanSaled],传入的params为空");
			return Collections.EMPTY_LIST;
		}

		List<SkuCanSaledResult> result = new ArrayList<>(paramList.size());

		for (ProductSaledParam params : paramList) {
			SkuCanSaledResult skuCanSaledResult = isCanSaled(params);
			result.add(skuCanSaledResult);
		}

		return result;
	}

	/**
	 * 判断是否可买商品
	 *
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public SkuCanSaledResult isCanSaled(ProductSaledParam params)
			throws Exception {
		// 创建默认的结果
		SkuCanSaledResult skuCanSaledResult = createSkuCanSaledResultFrom(params);

		// 检查产品是否可以购买
		List<Long> vaildProductIds = checkProductInfoCanSaled(params);

		if (vaildProductIds.size() > 0) {
			// 检查政策是否可以被购买
			checkStrategyCanSaled(params, skuCanSaledResult, vaildProductIds);
		}

		return skuCanSaledResult;
	}

	@Override
	public List<SkuProduct> findSkuProductByParam(SkuProduct queryParam) {
		List<SkuProduct> returnList = new ArrayList<SkuProduct>();
		ProductRelease release = new ProductRelease();
		try {
			PropertyUtils.copyProperties(release, queryParam);
			List<ProductRelease> list = productReleaseService
					.findListByParams(release);

			if (list != null) {
				for (ProductRelease vo : list) {
					SkuProduct sku = new SkuProduct();
					PropertyUtils.copyProperties(sku, vo);
					returnList.add(sku);
				}
			}
		} catch (Exception e) {
			this.logger.error("ProductRelease,SkuProduct 转换出错");
			e.printStackTrace();
		}

		return returnList;
	}

	@Override
	public List<SkuProduct> findSubProByUnionId(Long unionId) {
		if (unionId == null) {
			logger.info("查询参数：{}为空", unionId);
			return null;
		}
		// 获得子产品
		Map<String, Object> ids = new HashMap<>();
		List<Long> value = new ArrayList<>();
		value.add(unionId);
		ids.put("productId", value);
		List<ProductCombineRelation> combine = productCombineRelationService
				.findByIdsMap(ids);
		// 查询相关子产品信息
		if (null == combine || combine.size() == 0)
			return null;
		List<Long> subIds = new ArrayList<>();
		for (ProductCombineRelation rel : combine) {
			Long subId = rel.getSubProductId();
			if (subId != null)
				subIds.add(subId);
		}
		// 注：必须判断子产品ids 是否为空，否则查询结果说所有数据
		if (subIds.size() == 0)
			return null;
		ProductRelease product = new ProductRelease();
		product.setIds(subIds);
		List<ProductRelease> subProducts = productReleaseService
				.findListByParams(product);
		// 实体转换
		if (subProducts == null || subProducts.size() == 0)
			return null;
		List<SkuProduct> result = new ArrayList<>();
		for (ProductRelease productRelease : subProducts) {
			SkuProduct sku = new SkuProduct();
			try {
				PropertyUtils.copyProperties(sku, productRelease);
			} catch (Exception e) {
				this.logger.error("{} 转换 {} 出错", productRelease, sku);
				e.printStackTrace();
			}
			result.add(sku);
		}
		return result;
	}

	@Override
	public Integer saveSpuProduct(SpuProduct vo) {
		try {
			if (vo == null) {
				throw new SkuParamNullException(
						"更新产品组信息接口[saveSpuProduct]入参为空，更新失败");
			}
			if (vo.getId() == null) {
				throw new SkuParamNullException(
						"更新产品组接口[saveSpuProduct]入参的实体id为空，更新失败");
			}
			logger.debug("更新产品信息接口[saveSpuProduct]入参:{}", vo);
			ProductInfo pr = ProductConvert.convertTProductInfo(vo);
			return productInfoService.updateByPrimaryKey(pr);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SkuSaveException("产品组更新[saveSpuProduct]报错", e);
		}
	}

	@Override
	public Integer saveSkuProduct(SkuProduct vo) throws Exception {
		try {
			if (vo == null) {
				throw new SkuParamNullException(
						"更新产品组信息接口[saveSkuProduct]入参为空，更新失败");
			}
			if (vo.getId() == null) {
				throw new SkuParamNullException(
						"更新产品组接口[saveSkuProduct]入参的实体id为空，更新失败");
			}
			logger.debug("更新产品信息接口[saveSkuProduct]入参:{}", vo);
			ProductRelease pr = ProductConvert.convertTProduct(vo);
			return productReleaseService.updateByPrimaryKey(pr);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SkuSaveException("产品更新[saveSkuProduct]报错", e);
		}
	}

	@Override
	public Integer saveSkuProductByParentId(List<SkuProduct> voList)
			throws Exception {
		try {
			if (voList == null) {
				throw new SkuParamNullException(
						"更新产品信息接口[saveSkuProductByParentId]入参为空");
			}
			if (!ProductCheckUtil.isHaveParentId(voList)) {
				throw new SkuParamNullException(
						"更新产品信息接口[saveSkuProductByParentId]入参没有产品组id");
			}
			logger.debug("更新产品信息接口[saveSkuProductByParentId]入参:{}", voList);
			List<ProductRelease> entityList = ProductConvert
					.convertTProductList(voList);
			return productReleaseService.updateBatchByInfoId(entityList);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new SkuSaveException("产品更新[saveSkuProductByParentId]报错", e);
		}
	}

	@Override
	public List<SpuProductResultVO> findSkuProductForApp(
			SpuProductQueryParamVO vo) throws Exception {
		if (vo == null) {
			logger.error("查询产品组列表接口[findSkuProductForApp]：入参对象为空");
			throw new SkuParamNullException(
					"查询产品组列表接口[findSkuProductForApp]：传入参数为空");
		}
		if (!vo.isHaveDistributorId()) {
			logger.error("查询产品组列表接口[findSkuProductForApp]：入参:分销商id为空");
			throw new SkuParamNullException(
					"查询产品组列表接口[findSkuProductForApp]：传入参数为空");
		}
		if (!vo.isHaveSaleType()) {
			logger.error("查询产品组列表接口[findSkuProductForApp]：入参:销售端口为空");
			throw new SkuParamNullException(
					"查询产品组列表接口[findSkuProductForApp]：传入参数为空");
		}
		try {
            long start = System.currentTimeMillis();
			List<SpuProductResultVO> result = productSearchService.querySpuProductForApp(vo);
			logger.info("findSkuProductForApp执行效率：{}",System.currentTimeMillis()-start);
			return result;
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return null;
	}

	@Override
	public QueryPageList<SpuProductResultVO> findSkuProductForApp(
			SpuProductQueryParamVO vo, QueryPageModel queryPageModel)
			throws Exception {
		if (vo == null) {
			logger.error("查询产品组列表接口[findSkuProductForApp]：传入参数为空");
			throw new SkuParamNullException(
					"查询产品组列表接口[findSkuProductForApp]：传入参数为空");
		}

		logger.info("查询产品组列表接口[findSkuProductForApp]参数：{}", JSON.toJSONString(vo));

		try {
			long start = System.currentTimeMillis();
			QueryPageList<SpuProductResultVO> result = productSearchService.querySpuProductForApp(vo,
					queryPageModel);
			logger.info("findSkuProductForApp执行效率：{}",System.currentTimeMillis()-start);
			return result;
			
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public SkuProductResultVO findSkuProductById(Long skuId) {
		SkuProductResultVO skuProductResultVO = new SkuProductResultVO();
		try {
			// 查询产品
			SkuProduct skuProduct = getSkuProductById(skuId);
			if (skuProduct == null)
				return skuProductResultVO;
			skuProductResultVO.setSkuProduct(skuProduct);

			// 查询产品组
			if (skuProduct.getProductId() != null) {
				SpuProduct spuProduct = getSpuProductById(skuProduct.getProductId());
				skuProductResultVO.setSpuProduct(spuProduct);
			}

			// 查询景区
			List<SkuProductScenic> skuProductScenicList = getSkuProductScenicsByProductId(skuId);
			skuProductResultVO.setScenic(skuProductScenicList);

			// 查询景点
			List<SkuSiteData> skuSiteDataList = getSkuSiteDatasByProductInfoId(skuProduct);
			skuProductResultVO.setSiteDateList(skuSiteDataList);

			// 查询场次区域
			List<SkuRondaRelation> skuRondaRelationList = getSkuRondaRelationsByProductId(skuId);
			skuProductResultVO.setRondaRelationList(skuRondaRelationList);

			// 查询关闭事件
			List<SkuCloseTimeSlot> skuCloseTimeSlotList = getSkuCloseTimeSlotsByProductInfoId(
					skuProduct.getProductId());
			skuProductResultVO.setCloseTimeSlotList(skuCloseTimeSlotList);

			// 查询渠道政策
			List<PCStrategyResult> strategyResultList = getPCStrategyResultByProductId(
					Arrays.asList(skuId));
			skuProductResultVO.setStrategyList(strategyResultList);

			return skuProductResultVO;
		} catch (Throwable throwable) {
			logger.error("通过id获取sku实例出错！");
			logger.error(throwable.getMessage(),throwable);
		}
		return null;
	}

	@Override
	public QueryPageList<SkuProductResultVO> findSkuproductForSupplier(
			SkuProductQueryParam vo, QueryPageModel queryPageModel) {
		if (vo == null)
			return null;
		try {
			if (queryPageModel == null)
				queryPageModel = new QueryPageModel(1, 20);

			ProductInfo productInfoParam = ProductConvert
					.convertTProductInfo(vo.getSpuProductParam());
			ProductRelease releaseParam = ProductConvert
					.convertTProductRelease(vo.getSkuProductParam());

			QueryPageList<ProductRelease> productReleaseQueryPageList = productReleaseService.findReleaseAndInfoByInfoParams(releaseParam, productInfoParam, queryPageModel);

			List<SkuProductResultVO> skuProductResultVOList = null;
			if (productReleaseQueryPageList.getResultList() != null){
				skuProductResultVOList = turnTypeSkuProductResultVOs(productReleaseQueryPageList.getResultList());
			}

			QueryPageList<SkuProductResultVO> result = new QueryPageList<>(skuProductResultVOList, productReleaseQueryPageList.getPageBean());
			return result;

		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
			throw new SkuSearchException(
					"查询产品组列表接口[findSkuproductForSupplier]报错", throwable);
		}
	}

	@Override
	public QueryPageList<SpuProductResultVO> findSpuproductForSupplier(
			SkuProductQueryParam vo, QueryPageModel queryPageModel) {
		ProductInfo productInfoParam = null;
		ProductRelease productReleaseParam = null;
		if (vo != null) {
			productInfoParam = ProductConvert.convertTProductInfo(vo
					.getSpuProductParam());
		}
		if (vo != null) {
			productReleaseParam = ProductConvert.convertTProductRelease(vo
					.getSkuProductParam());
		}

		QueryPageList<ProductInfo> productInfoPageList = productInfoSearchService
				.findSpuproductForSupplier(productInfoParam,
						productReleaseParam, queryPageModel);
		List<ProductInfo> productInfResultList = productInfoPageList
				.getResultList();
		List<SpuProductResultVO> resultList = null;

		if (CollectionUtils.isNotEmpty(productInfResultList)) {

			resultList = new ArrayList<>(productInfResultList.size());
			for (ProductInfo productInfo : productInfResultList) {
				SpuProduct spuProduct = ProductConvert
						.convertTSpuProduct(productInfo);
				SpuProductResultVO resultVO = new SpuProductResultVO();
				resultVO.setSpuProduct(spuProduct);
				resultList.add(resultVO);
			}

			productReleaseParam = new ProductRelease();

			productReleaseParam.setProductIds(CommonConvert
					.getIdList(productInfResultList));

			List<ProductRelease> productReleaseList = productReleaseService
					.findListByParams(productReleaseParam);

			Map<Long, SpuProductResultVO> spuProductMap = new HashMap<>(
					productInfResultList.size());
			for (SpuProductResultVO resultVO : resultList) {
				SpuProduct spuProduct = resultVO.getSpuProduct();
				spuProductMap.put(spuProduct.getId(), resultVO);
			}

			for (ProductRelease release : productReleaseList) {
				Long productId = release.getProductId();
				SpuProductResultVO spuProductResultVO = spuProductMap
						.get(productId);
				List<SkuProduct> skuProductList = spuProductResultVO
						.getSkuProductList();
				if (CollectionUtils.isEmpty(skuProductList)) {
					skuProductList = new ArrayList<>();
					spuProductResultVO.setSkuProductList(skuProductList);
				}

				SkuProduct skuProduct = ProductConvert
						.convertTSkuProduct(release);
				skuProductList.add(skuProduct);
			}
		}

		QueryPageList<SpuProductResultVO> sprProductResult = new QueryPageList<>(
				resultList, productInfoPageList.getPageBean());
		return sprProductResult;
	}

	@Override
	public List<SkuProductResultVO> findSkuproductForSupplier(
			SkuProductQueryParam vo) {
		if (vo == null)
			return null;
		try {
			ProductInfo productInfoParam = ProductConvert
					.convertTProductInfo(vo.getSpuProductParam());
			ProductRelease releaseParam = ProductConvert
					.convertTProductRelease(vo.getSkuProductParam());

			List<ProductRelease> productReleaseList = productReleaseService
					.findReleaseAndInfoByInfoParams(releaseParam,
							productInfoParam);

			List<SkuProductResultVO> skuProductResultVOList = turnTypeSkuProductResultVOs(productReleaseList);
			return skuProductResultVOList;

		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
			throw new SkuStockException("方法[findSkuproductForSupplier]报错",
					throwable);
		}
	}

	@Override
	public List<PCAddressResult> findSpuAddressByDistributorId(
			SpuProductQueryParamVO vo) {
		Long distributorId = null;
		String saleType = null;
		if (vo == null) {
			logger.info("查询产品的省市集合方法[findSpuAddressByDistributorId]，没有传入参数");
		} else {
			distributorId = vo.getDistributorId();
			saleType = vo.getSalesType();
			logger.info(
					"查询产品的省市集合方法[findSpuAddressByDistributorId]，传入参数分销商id:{},销售端口:{}",
					distributorId, saleType);
		}
		return productSearchService.queryAddressByDistributorId(distributorId,
				saleType);
	}

	@Override
	public Result<SpuProductResultVO> findSpuProductById(Long spuId) {
		if (spuId == null){
			return null;
		}

		Result<SpuProductResultVO> result = new Result<>();
		SpuProduct spuProduct = getSpuProductById(spuId);
		if (spuProduct == null){

			return result;
		}

		List<SkuProduct> skuProducts = null;
		Long id = spuProduct.getId();
		ProductRelease productReleaseParam = new ProductRelease();
		productReleaseParam.setProductId(id);
		List<ProductRelease> listByParams = productReleaseService.findListByParams(productReleaseParam);
		if (CollectionUtils.isNotEmpty(listByParams)){
			try {
				skuProducts = ProductConvert.convertTSkuProductList(listByParams);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}


		SpuProductResultVO spuProductResultVO = new SpuProductResultVO();
		spuProductResultVO.setSpuProduct(spuProduct);
		spuProductResultVO.setSkuProductList(skuProducts);
		result.setData(spuProductResultVO);

		return result;
	}

	public Result<SpuProductBasicInfoResult> findSpuProductBasicInfoByParams(SpuProductBasicInfoParam param) {

		Result<SpuProductBasicInfoResult> result = new Result<>();
		Long spuId= null;
		Long channelId = null;
		if (param == null || (spuId = param.getSpuId()) == null || (channelId = param.getChannelId()) == null){
			return result;
		}

		List<SysSpcreRelationKey> spcreList = sysSpcreRelationService.queryByChannelAndInfoId(spuId, param.getChannelId());
		if (CollectionUtils.isEmpty(spcreList)){
			return result;
		}

		// 查询SPU
		ProductInfo productInfo = productInfoService.getById(spuId);
		if (productInfo == null){
			return result;
		}

		// 创建结果集
		SpuProductBasicInfoResult spuProductBasicInfoResult = ProductSetValueUtil.set(result,new SpuProductBasicInfoResult());

		List<Long> productRelesaseIds = new ArrayList<>();
		List<Long> strategyIds = new ArrayList<>();
		for (SysSpcreRelationKey spcre : spcreList){
			Long aLong;
			aLong = Long.valueOf(spcre.getProductId());
			if (!productRelesaseIds.contains(aLong))
				productRelesaseIds.add(aLong);
			aLong = Long.valueOf(spcre.getStrategyId());
			if (!strategyIds.contains(aLong))
				strategyIds.add(aLong);
		}

		ProductRelease productReleaseParam = new ProductRelease();
		productReleaseParam.setIds(productRelesaseIds);

		List<ProductRelease> productReleaseList = productReleaseService.findListByParams(productReleaseParam);
		productInfo.setProductReleaseList(productReleaseList);

		// 设置SPU结果，SKU结果
		ProductSetValueUtil.set(spuProductBasicInfoResult, productInfo);

		if (CollectionUtils.isEmpty(productReleaseList))
			return result;

		// 查询关闭事件
		List<SkuCloseTimeSlot> skuCloseTimeSlotList = getSkuCloseTimeSlotsByProductInfoId(spuId);

		// 设置关闭事件
		spuProductBasicInfoResult.setCloseTimeSlotList(skuCloseTimeSlotList);

		// 查询政策
		List<SysChannelStrategy> channelStrategyList = strategySearchServiceUtil.queryChannelStrategyByIds(strategyIds);

		if (CollectionUtils.isNotEmpty(channelStrategyList)){
			String ticketVarie = param.getTicketVarie();
			if(ticketVarie != null){
				Iterator<SysChannelStrategy> iterator = channelStrategyList.iterator();
				while (iterator.hasNext()){
					SysChannelStrategy strategy = iterator.next();
					if(!ticketVarie.equals(strategy.getTicketVarie())){
						iterator.remove();
					}
				}
			}

			// 设置政策
			ProductSetValueUtil.setSysChannelStrategyToSkuProductBasicInfoResult(spuProductBasicInfoResult.getSkuProductResultList(), channelStrategyList);
		}

		return result;
	}

	@Override
	public Result<QueryPageList<SkuProductForScenic>> findSkuProductForScenic(SkuProductForScenicQuery param, QueryPageModel queryPageModel) {
		Result<QueryPageList<SkuProductForScenic>> result = new Result<>();
		if (logger.isDebugEnabled()) {
			String jsonString = JSON.toJSONString(param);
			logger.debug("方法 findSkuProductForScenic 参数 param ： {} ", jsonString);
			jsonString = JSON.toJSONString(queryPageModel);
			logger.debug("方法 findSkuProductForScenic 参数 queryPageModel ： {} ", jsonString);
		}
		try {
			QueryPageList<SkuProductForScenic> queryPageList = productSearchService.querySpuProductForScenic(param, queryPageModel);
			result.setData(queryPageList);
		} catch (Throwable throwable){
			result.setErrorMsg(throwable.getMessage());
			logger.error(throwable.getMessage(), throwable);
		}


		if (logger.isDebugEnabled()) {
			String jsonString = JSON.toJSONString(result);
			logger.debug("方法 findSkuProductForScenic 结果： {} ", jsonString);
		}

		return result;
	}

	@Override
	public Result<QueryPageList<SpuProductResultVO>> findSpuProductForCommons(SpuProductForCommonsQueryParam param, QueryPageModel queryPageModel) {
		long starteTime = System.currentTimeMillis();
		if (logger.isDebugEnabled()) {
			String jsonString = JSON.toJSONString(param);
			logger.debug("方法 findSpuProductForCommons 参数 param ： {} ", jsonString);
			jsonString = JSON.toJSONString(queryPageModel);
			logger.debug("方法 findSpuProductForCommons 参数 queryPageModel ： {} ", jsonString);
		}
		Result<QueryPageList<SpuProductResultVO>> result = new Result<>();
		try {
			if (param != null){
				SpuProductQuery spuProductQuery = param.getSpuProductQuery();
				if (spuProductQuery != null){
					String name = spuProductQuery.getName();
					if (StringUtils.isNotBlank(name))
						spuProductQuery.setName(name + "%");
				}
			}

			QueryPageList<SpuProductResultVO> spuProductResultVOQueryPageList = productSearchService.querySpuProductForCommons(param, queryPageModel);
			result.setData(spuProductResultVOQueryPageList);
		} catch (Throwable throwable){
			result.setErrorMsg(throwable.getMessage());
			logger.error(throwable.getMessage(), throwable);
		}


		if (logger.isDebugEnabled()) {
			String jsonString = JSON.toJSONString(result);
			logger.debug("方法 findSpuProductForCommons 结果： {} ", jsonString);
		}

		long endTime = System.currentTimeMillis();

		logger.info("findSpuProductForCommons 执行时间：{}" , String.valueOf(endTime - starteTime));

		return result;
	}

	/**
	 * 检查产品是否可以购买
	 *
	 * @param params
	 *            购买条件的参数
	 * @return
	 */
	private List<Long> checkProductInfoCanSaled(ProductSaledParam params) {

		// 获取所有有效的产品
		List<ProductRelease> productReleaseList = getValidProductReleaseListByProductIds(params
				.getProductIds());

		Date date = params.getDate();
		List<Long> vaildProductIds = new ArrayList<>(productReleaseList.size());
		for (ProductRelease release : productReleaseList) {
			ProductInfo productInfo = release.getProductInfo();
			if (productInfo == null)
				continue;

			long dateLong = 0L;
			long saleStartDateLong = 0L;
			long saleEndDateLong = 0L;

			if (date != null)
				dateLong = date.getTime();
			Date saleStartDate = productInfo.getSaleStartDate();
			if (saleStartDate != null)
				saleStartDateLong = saleStartDate.getTime();
			Date saleEndDate = productInfo.getSaleEndDate();
			if (saleEndDate != null)
				saleEndDateLong = saleEndDate.getTime();
			if (saleStartDateLong <= dateLong && dateLong <= saleEndDateLong)
				vaildProductIds.add(release.getId());
		}
		return vaildProductIds;
	}

	/**
	 * 查询有效的产品，及其产品组信息
	 *
	 * @param productIds
	 *            产品id集合
	 * @return
	 */
	private List<ProductRelease> getValidProductReleaseListByProductIds(
			List<Long> productIds) {
		ProductRelease productParams = new ProductRelease();
		productParams.setIds(productIds);
		productParams.setFlag(String.valueOf(GlobalParam.FLAG.start()));
		return productReleaseService.findReleaseAndInfoByParams(productParams);
	}

	private SkuCanSaledResult createSkuCanSaledResultFrom(
			ProductSaledParam params) {
		List<Long> productIds = params.getProductIds();
		SkuCanSaledResult skuCanSaledResult = new SkuCanSaledResult();
		skuCanSaledResult.setChannelId(params.getChannelId());
		skuCanSaledResult.setDate(params.getDate());
		skuCanSaledResult.setSaleType(params.getSaleType());
		skuCanSaledResult.setDistributorId(params.getDistributorId());

		List<SkuCanSaledResult.ProductResult> productResults = new ArrayList<>(
				productIds.size());
		Map<Long, SkuCanSaledResult.ProductResult> productResultMap = new HashMap<>(
				productIds.size());
		for (Long id : productIds) {
			SkuCanSaledResult.ProductResult productResult = new SkuCanSaledResult.ProductResult();
			productResult.setProductId(id);
			productResult.setCanSaleResult(false);
			productResultMap.put(id, productResult);
			productResults.add(productResult);
		}

		skuCanSaledResult.setProductResults(productResults);
		return skuCanSaledResult;
	}

	private Map<Long, SkuCanSaledResult.ProductResult> createSkuProductResultMap(
			SkuCanSaledResult skuCanSaledResult) {
		List<SkuCanSaledResult.ProductResult> productResultsList = skuCanSaledResult
				.getProductResults();
		Map<Long, SkuCanSaledResult.ProductResult> productResultMap = new HashMap<>(
				productResultsList.size());
		for (SkuCanSaledResult.ProductResult productResult : productResultsList) {
			productResultMap.put(productResult.getProductId(), productResult);
		}
		return productResultMap;
	}

	/**
	 * 检查政策是否可以被购买
	 *
	 * @param params
	 * @param skuCanSaledResult
	 * @param vaildProductIds
	 * @return
	 * @throws Exception
	 */
	private void checkStrategyCanSaled(ProductSaledParam params,
									   SkuCanSaledResult skuCanSaledResult, List<Long> vaildProductIds)
			throws Exception {
		// 查询政策
		List<SysChannelStrategy> strategyList = productSearchServiceUtil
				.queryStrategyByD_C_P(params.getDistributorId(),
						params.getSaleType(),
						Arrays.asList(params.getChannelId()), vaildProductIds);
		if (CollectionUtils.isEmpty(strategyList))
			return;

		Map<Long, SkuCanSaledResult.ProductResult> productResultMap = createSkuProductResultMap(skuCanSaledResult);

		// 购买时间是星期几
		String dayOfWeek = String.valueOf(getDayOfWeek(params));

		for (SysChannelStrategy strategy : strategyList) {
			// 检查购买时间是否有效
			if (checkStrategyScope(strategy, dayOfWeek)) {
				SkuCanSaledResult.ProductResult productResult = productResultMap
						.get(strategy.getProductId());
				productResult.setCanSaleResult(true);
			}
		}
	}

	/**
	 * 根据产品id查询产品
	 *
	 * @param skuId
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private SkuProduct getSkuProductById(Long skuId) {
		ProductRelease productRelease = productReleaseService.getById(skuId);
		SkuProduct skuProduct = ProductConvert
				.convertTSkuProduct(productRelease);
		return skuProduct;
	}

	/**
	 * 根据产品组id查询产品组
	 *
	 * @param id
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private SpuProduct getSpuProductById(Long id) {
		ProductInfo productInfo = productInfoService.getById(id);
		SpuProduct spuProduct = ProductConvert.convertTSpuProduct(productInfo);
		return spuProduct;
	}

	/**
	 * 根据产品id查询景区
	 *
	 * @param skuId
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private List<SkuProductScenic> getSkuProductScenicsByProductId(Long skuId) {
		List<ProductScenic> productScenicList = productScenicService
				.queryScenicByProductId(null, skuId);
		List<SkuProductScenic> skuProductScenicList = CommonConvert
				.convertList(productScenicList, SkuProductScenic.class);
		return skuProductScenicList;
	}

	/**
	 * 根据产品组id查询景点
	 *
	 * @param skuProduct
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private List<SkuSiteData> getSkuSiteDatasByProductInfoId(
			SkuProduct skuProduct) {
		ProductSiteRelation productSiteRelation = new ProductSiteRelation();
		productSiteRelation.setProductInfoId(skuProduct.getProductId());
		List<ProductSiteData> productSiteDataList = productSiteDataService
				.querySiteDataByProductInfo(null, productSiteRelation);
		List<SkuSiteData> skuSiteDataList = CommonConvert.convertList(
				productSiteDataList, SkuSiteData.class);
		return skuSiteDataList;
	}

	private List<SkuRondaRelation> getSkuRondaRelationsByProductId(Long skuId) {
		ProductRondaRelation productRondaRelation = new ProductRondaRelation();
		productRondaRelation.setProductId(skuId);
		List<ProductRondaRelation> productRondaRelationList = productRondaRelationService
				.findListByParams(productRondaRelation);
		List<SkuRondaRelation> skuRondaRelationList = CommonConvert
				.convertList(productRondaRelationList, SkuRondaRelation.class);
		return skuRondaRelationList;
	}

	/**
	 * 根据产品id集合查询渠道政策
	 *
	 * @param productIds
	 * @return
	 */
	private List<PCStrategyResult> getPCStrategyResultByProductId(
			List<Long> productIds) {
		try {
			// 通过产品id集合查询政策与产品的关系
			List<SysChannelStrategy> strategyList = getSysChannelStrategiesByProductIds(productIds);

			if (CollectionUtils.isEmpty(strategyList)) {
				return null;
			}

			// 查询政策与渠道关系
			List<SysLabelRelationKey> strategyChannelList = getSysLabelRelationKeysByStrategy(strategyList);

			// 查询渠道
			List<SysChannel> channelList = getSysChannelsByStrategyRelation(strategyChannelList);
			if (CollectionUtils.isEmpty(channelList))
				return null;

			// 查询结算信息
			Map<Long, SettlementRule> settlementRuleMap = getLongSettlementRuleMap(productIds);

			// 渠道MapisCanSaled
			Map<Long, Channel> channelMap = new HashMap<>(channelList.size());
			for (SysChannel channel : channelList) {
				Channel cha = new Channel();
				PropertyUtils.copyProperties(cha, channel);
				channelMap.put(channel.getId(), cha);
			}

			// 政策Map
			Map<Long, Strategy> strategyMap = rebateStrategySearchUtil
					.fillReabteFroStrategy(strategyList);

			// 组合计算结果集
			List<PCStrategyResult> strategyResultList = composetrategyResults(
					strategyChannelList, channelList, settlementRuleMap,
					channelMap, strategyMap);

			return strategyResultList;
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return null;
	}

	private List<PCStrategyResult> composetrategyResults(
			List<SysLabelRelationKey> strategyChannelList,
			List<SysChannel> channelList,
			Map<Long, SettlementRule> settlementRuleMap,
			Map<Long, Channel> channelMap, Map<Long, Strategy> strategyMap)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 渠道政策结果集
		List<PCStrategyResult> strategyResultList = new ArrayList<>();
		// 渠道、产品、渠道政策结果，三者关联关系
		Map<Long, Map<Long, PCStrategyResult>> channelProductMap = new HashMap<>(
				channelList.size());
		for (SysLabelRelationKey key : strategyChannelList) {
			Long channelId = Long.valueOf(key.getRelId());
			Channel channel = channelMap.get(channelId);
			if (channel == null)
				continue;

			Long strategyId = Long.valueOf(key.getObjId());
			Strategy channelStrategy = strategyMap.get(strategyId);
			if (channelStrategy == null)
				continue;

			Map<Long, PCStrategyResult> longPCStrategyResultMap = channelProductMap
					.get(channelId);
			if (longPCStrategyResultMap == null) {
				longPCStrategyResultMap = new HashMap<>();
				channelProductMap.put(channelId, longPCStrategyResultMap);
			}

			PCStrategyResult pcStrategyResult = longPCStrategyResultMap
					.get(channelStrategy.getProductId());
			if (pcStrategyResult == null) {
				pcStrategyResult = new PCStrategyResult();
				pcStrategyResult.setChannel(channel);
				pcStrategyResult.setProductId(channelStrategy.getProductId());
				strategyResultList.add(pcStrategyResult);
				longPCStrategyResultMap.put(channelStrategy.getProductId(),
						pcStrategyResult);
			}

			List<Strategy> strList = pcStrategyResult.getStrategyList();
			if (strList == null) {
				strList = new ArrayList<>();
				pcStrategyResult.setStrategyList(strList);
			}
			strList.add(channelStrategy);

			SettlementRule settlementRule = settlementRuleMap.get(strategyId);
			if (settlementRule != null) {
				List<SettlementRule> ruleList = pcStrategyResult.getRuleList();
				if (CollectionUtils.isEmpty(ruleList)) {
					ruleList = new ArrayList<>();
					pcStrategyResult.setRuleList(ruleList);
				}
				ruleList.add(settlementRule);
			}
		}
		return strategyResultList;
	}

	/**
	 * 根据产品id查询结算信息
	 *
	 * @param productIds
	 * @return
	 */
	private Map<Long, SettlementRule> getLongSettlementRuleMap(
			List<Long> productIds) {
		List<SettlementRule> settlementRuleList = settlementSearchService
				.findListByProductIds(productIds);
		Map<Long, SettlementRule> settlementRuleMap = Collections.EMPTY_MAP;
		if (CollectionUtils.isNotEmpty(settlementRuleList)) {
			settlementRuleMap = new HashMap<>();
			for (SettlementRule settlementRule : settlementRuleList) {
				settlementRuleMap.put(settlementRule.getStrategyId(),
						settlementRule);
			}
		}
		return settlementRuleMap;
	}

	private List<SysChannelStrategy> getSysChannelStrategiesByProductIds(
			List<Long> productIds) {
		SysChannelStrategy strategyParams = new SysChannelStrategy();
		strategyParams.setProductIds(productIds);
		return strategySearchService.queryStratgyByParam(strategyParams);
	}

	private List<SysLabelRelationKey> getSysLabelRelationKeysByStrategy(
			List<SysChannelStrategy> strategyList) {
		List<Long> strategyIdListParams = CommonConvert.getIdList(strategyList);

		// 查询政策与渠道的关系
		SysLabelRelationKey strategyChannelParams = new SysLabelRelationKey();
		strategyChannelParams.setQueryObjIds(strategyIdListParams);
		strategyChannelParams.setRelType("strategyChannel");
		return strategySearchService
				.queryLabelRelationByParam(strategyChannelParams);
	}

	private List<SysChannel> getSysChannelsByStrategyRelation(
			List<SysLabelRelationKey> strategyChannelList) {
		List<Long> channelIdListParams = null;
		if (CollectionUtils.isNotEmpty(strategyChannelList)) {
			channelIdListParams = new ArrayList<>(strategyChannelList.size());
			for (SysLabelRelationKey key : strategyChannelList) {
				if (!channelIdListParams.contains(Long.valueOf(key.getRelId())))
					channelIdListParams.add(Long.valueOf(key.getRelId()));
			}
		}

		return strategySearchService.getValidChannelByIds(channelIdListParams);
	}

	private List<SkuCloseTimeSlot> getSkuCloseTimeSlotsByProductInfoId(
			Long skuProductId) {
		ProductCloseTimeslot productCloseTimeslot = new ProductCloseTimeslot();
		productCloseTimeslot.setProductInfoId(skuProductId);
		List<ProductCloseTimeslot> listByParams = productCloseTimeslotService
				.findListByParams(productCloseTimeslot);
		return CommonConvert.convertList(listByParams, SkuCloseTimeSlot.class);
	}

	private boolean checkStrategyScope(SysChannelStrategy strategy,
									   String dayOfWeek) {
		String scope = strategy.getScope();
		if (StringUtils.isBlank(scope))
			return false;

		return scope.indexOf(dayOfWeek) > 0;
	}

	private int getDayOfWeek(ProductSaledParam params) {
		Date date = params.getDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 转类型
	 *
	 * @param productReleaseList
	 * @return
	 * @throws Exception
	 */
	private List<SkuProductResultVO> turnTypeSkuProductResultVOs(
			List<ProductRelease> productReleaseList) throws Exception {
		if (CollectionUtils.isNotEmpty(productReleaseList)) {
			List<SkuProductResultVO> skuProductResultVOList = new ArrayList<>(
					productReleaseList.size());
			for (ProductRelease productRelease : productReleaseList) {
				SkuProduct skuProduct = ProductConvert
						.convertTSkuProduct(productRelease);
				SpuProduct spuProduct = ProductConvert
						.convertTSpuProduct(productRelease.getProductInfo());
				SkuProductResultVO skuProductResultVO = new SkuProductResultVO();
				skuProductResultVO.setSkuProduct(skuProduct);
				skuProductResultVO.setSpuProduct(spuProduct);
				skuProductResultVOList.add(skuProductResultVO);
			}
			return skuProductResultVOList;
		}
		return null;
	}

	private Long addProduct(ProductInfoModification model) {
		try {
			Long startTime = System.currentTimeMillis();
			// 1.新增产品组及产品组与景区，产品组与景点
			Long result = productInfoService.addProduct(model.getInfo(),
					model.getSlotList(), model.getScenicList(),
					model.getSiteRelationList());

			// 2.添加产品组与产品关系
			ProductConvert.combinationTProductRelease(model.getInfo(),
					model.getPrList());

			// 3.新增产品及产品与景区，产品与景点，产品与场次区域关系
			productReleaseService.addProduct(model.getPrList(),
					model.getRondaRelation(), model.getScenicList(),
					ProductConvert.getSiteIdList(model.getSiteRelationList()));

			Long endTime = System.currentTimeMillis();

			logger.info("产品新建执行时间：" + (endTime - startTime));

			return result;
		} catch (ServiceException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new SkuAddException("产品创建[addProduct]报错", ex);

		}
	}

	private Integer saveProduct(ProductInfoModification model) {
		try {
			Long startTime = System.currentTimeMillis();

			// 1.更新产品组信息，产品组与关闭时间事件，产品组与景区，产品组与景点的关系
			Integer result = productInfoService.saveProduct(model.getInfo(),
					model.getSlotList(), model.getScenicList(),
					model.getSiteRelationList());

			if(CollectionUtils.isNotEmpty(model.getPrList())){
				productReleaseService.saveProduct(model.getPrList(),
						model.getRondaRelation(), model.getScenicList(),
						ProductConvert.getSiteIdList(model.getSiteRelationList()));
			}


			Long endTime = System.currentTimeMillis();

			logger.info("产品更新执行时间：" + (endTime - startTime));

			return result;
		} catch (ServiceException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new SkuSaveException("产品更新[saveProduct]报错", ex);
		}
	}

	@Override
	public Boolean updateSkuInitInfo(List<Long> ids, Boolean isOneVote,
									 Boolean isSelectSeat) {
		if(CollectionUtils.isEmpty(ids)){
			throw new SkuParamNullException("产品id为空");
		}
		if(isOneVote == null && isSelectSeat == null){
			throw new SkuParamNullException("是否选座和是否一证一票都为空");
		}
		List<ProductRelease> prList = new ArrayList<ProductRelease>();
		for(Long id : ids){
			ProductRelease pr = new ProductRelease();
			pr.setId(id);
			pr.setIsOneVote(isOneVote);
			pr.setIsSelectSeat(isSelectSeat);
			prList.add(pr);

		}
		Integer num = productReleaseService.updateBatchByPrimaryKey(prList);

		return num == null || num == 0 ? false : true;
	}




}
