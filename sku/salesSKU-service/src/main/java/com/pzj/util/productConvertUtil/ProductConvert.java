package com.pzj.util.productConvertUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pzj.product.vo.voParam.queryParam.SpuProductQuery;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.ProductSiteRelation;
import com.pzj.base.entity.product.query.DateQuery;
import com.pzj.base.service.exception.SkuParamConvertException;
import com.pzj.base.service.model.modificationParam.ProductInfoModification;
import com.pzj.base.service.model.queryResult.Product;
import com.pzj.base.service.model.util.ModelOperateUtil;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.product.vo.AttrInfo;
import com.pzj.product.vo.BaseInfo;
import com.pzj.product.vo.JsonSkuDto;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SkuRondaRelation;
import com.pzj.product.vo.product.SkuScenic;
import com.pzj.product.vo.product.SkuSiteRelation;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.modificationParam.SkuProductModificationVO;
import com.pzj.product.vo.voParam.modificationParam.SpuProductModificationVO;
import com.pzj.product.vo.voParam.queryParam.DateQueryParam;
import com.pzj.product.vo.voParam.queryParam.SkuProductQuery;
import com.pzj.product.vo.voParam.queryParam.SkuScenicQuery;
import com.pzj.product.vo.voParam.resultParam.PCAddressResult;
import com.pzj.product.vo.voParam.resultParam.SkuProductBasicInfo;
import com.pzj.product.vo.voParam.resultParam.SkuProductBasicInfoResult;
import com.pzj.product.vo.voParam.resultParam.SkuProductForScenic;
import com.pzj.product.vo.voParam.resultParam.SpuProductResultVO;

public class ProductConvert {
	private static Logger logger = LoggerFactory
			.getLogger(ProductConvert.class);

	public static ProductInfo convertTProductInfo(SpuProduct vo) {
		if (vo == null)
			return null;
		ProductInfo result = new ProductInfo();
		convertTProductInfo(vo, result);
		return result;
	}

	public static ProductInfo convertTProductInfo(SpuProductQuery vo) {
		if (vo == null)
			return null;
		ProductInfo result = new ProductInfo();
		convertTProductInfo(vo, result);

		if (result != null){
			DateQueryParam saleDateQuery = vo.getSaleDateQuery();
			if (saleDateQuery != null) {
				com.pzj.base.entity.query.DateQueryParam saleDateQuery1 = new com.pzj.base.entity.query.DateQueryParam();
				saleDateQuery1.setStartDate(saleDateQuery.getStartDate());
				saleDateQuery1.setEndDate(saleDateQuery.getEndDate());
				result.setSaleDateQuery(saleDateQuery1);
			}
		}
		if (result != null){
			DateQueryParam availableDateQuery = vo.getAvailableDateQuery();
			if (availableDateQuery != null) {
				com.pzj.base.entity.query.DateQueryParam saleDateQuery1 = new com.pzj.base.entity.query.DateQueryParam();
				saleDateQuery1.setStartDate(availableDateQuery.getStartDate());
				saleDateQuery1.setEndDate(availableDateQuery.getEndDate());
				result.setAvailableDateQuery(saleDateQuery1);
			}
		}
		return result;
	}

	public static void convertTProductInfo(SpuProduct vo, ProductInfo result) {
		if (vo == null || result == null)
			return;
		CommonConvert.copyProperties(result, vo);
	}

	public static SpuProduct convertTSpuProduct(ProductInfo vo) {
		if (vo == null)
			return null;
		SpuProduct result = new SpuProduct();
		CommonConvert.copyProperties(result, vo);
		return result;
	}

	public static ProductRelease convertTProduct(SkuProduct vo) {
		if (vo == null)
			return null;
		ProductRelease result = new ProductRelease();
		convertTProduct(vo, result);
		return result;
	}

	public static void convertTProduct(SkuProduct vo, ProductRelease result) {
		if (vo == null || result == null)
			return;
		CommonConvert.copyProperties(result, vo);
	}

	public static ProductCloseTimeslot convertTProductCloseTimeslot(
			SkuCloseTimeSlot param) {
		if (param == null)
			return null;
		ProductCloseTimeslot result = new ProductCloseTimeslot();
		CommonConvert.copyProperties(result, param);
		return result;
	}

	public static SkuProduct convertTSkuProduct(ProductRelease vo) {
		if (vo == null)
			return null;
		SkuProduct result = new SkuProduct();
		CommonConvert.copyProperties(result, vo);
		return result;
	}

	public static SkuProductBasicInfo convertTSkuProductBasicInfo(ProductRelease vo) {
		if (vo == null)
			return null;
		SkuProductBasicInfo result = new SkuProductBasicInfo();
		CommonConvert.copyProperties(result, vo);
		return result;
	}

	public static List<SkuProductBasicInfo> convertTSkuProductBasicInfo(List<ProductRelease> productReleaseList) {
		if (CollectionUtils.isEmpty(productReleaseList))
			return null;

		List<SkuProductBasicInfo> skuProductBasicInfoResultList = new ArrayList<>(productReleaseList.size());
		for (ProductRelease release : productReleaseList){

			SkuProductBasicInfo skuProduct = convertTSkuProductBasicInfo(release);
			skuProductBasicInfoResultList.add(skuProduct);
		}
		return skuProductBasicInfoResultList;
	}

	public static List<SkuProductBasicInfoResult> convertTSkuProductBasicInfoResult(List<ProductRelease> productReleaseList) {
		if (CollectionUtils.isEmpty(productReleaseList))
			return null;

		List<SkuProductBasicInfoResult> skuProductBasicInfoResultList = new ArrayList<>(productReleaseList.size());
		for (ProductRelease release : productReleaseList){
			SkuProductBasicInfo skuProduct = convertTSkuProductBasicInfo(release);
			if (skuProduct != null){
				SkuProductBasicInfoResult skuProductBasicInfoResult = new SkuProductBasicInfoResult();
				skuProductBasicInfoResult.setSkuProduct(skuProduct);

				skuProductBasicInfoResultList.add(skuProductBasicInfoResult);
			}
		}
		return skuProductBasicInfoResultList;
	}

	public static ProductCloseTimeslot convertTPCloseTime(SkuCloseTimeSlot vo) {

		ProductCloseTimeslot result = new ProductCloseTimeslot();
		CommonConvert.copyProperties(result, vo);
		return result;
	}
	
	public static List<ProductCloseTimeslot> convertTPCloseTimeList(List<SkuCloseTimeSlot> volist)
			 {
		List<ProductCloseTimeslot> result = new ArrayList<ProductCloseTimeslot>();
		convertTPCloseTimeList(volist,result);
		return result;
	}
	
	public static void convertTPCloseTimeList(List<SkuCloseTimeSlot> volist,List<ProductCloseTimeslot> result) {
		if(volist == null || result == null){
			throw new SkuParamConvertException("产品关闭时间事件实体转换方法[convertTPCloseTimeList]参数为空");
		}
		
        for(SkuCloseTimeSlot slot : volist){
        	result.add(convertTPCloseTime(slot));
        }
	}

	public static SkuCloseTimeSlot convertTSCloserTime(ProductCloseTimeslot vo) {
		SkuCloseTimeSlot result = new SkuCloseTimeSlot();
		CommonConvert.copyProperties(result, vo);
		return result;
	}

	public static List<ProductRelease> convertTProductList(
			List<SkuProduct> voList) throws Exception {
		List<ProductRelease> resultList = new ArrayList<ProductRelease>();
		convertTProductList(voList, resultList);
		return resultList;
	}

	public static void convertTProductList(List<SkuProduct> voList,
			List<ProductRelease> resultList) throws Exception {
		if (voList == null) {
			return;
		}
		for (SkuProduct vo : voList) {
			ProductRelease result = new ProductRelease();
			CommonConvert.copyProperties(result, vo);
			resultList.add(result);
		}
	}

	public static List<SkuProduct> convertTSkuProductList(
			List<ProductRelease> voList) throws RuntimeException {
		Long start = System.currentTimeMillis();
		List<SkuProduct> resultList = new ArrayList<SkuProduct>();
		convertTSkuProductList(voList, resultList);
		return resultList;
	}

	public static void convertTSkuProductList(List<ProductRelease> voList,
			List<SkuProduct> resultList) throws RuntimeException {
		if (voList == null) {
			return;
		}		
		for (ProductRelease vo : voList) {
			SkuProduct result = new SkuProduct();
			Long start = System.currentTimeMillis();
			CommonConvert.copyProperties(result, vo);
			resultList.add(result);
		}
	}
	public static void convertTSkuProduct(SkuProduct result,ProductRelease pr){
		
	}
	
	
	

	public static List<SpuProduct> convertTSpuList(List<ProductInfo> voList)
			throws Exception {
		List<SpuProduct> resultList = new ArrayList<SpuProduct>();
		convertTSpuList(voList, resultList);
		return resultList;
	}

	public static void convertTSpuList(List<ProductInfo> voList,
			List<SpuProduct> resultList) throws Exception {
		if (voList == null) {
			return;
		}
		for (ProductInfo vo : voList) {
			resultList.add(convertTSpuProduct(vo));
		}
	}

	public static SkuSiteRelation convertTSkuSiteR(ProductSiteRelation vo)
			throws Exception {
		if (vo == null)
			return null;
		SkuSiteRelation result = new SkuSiteRelation();
		CommonConvert.copyProperties(result, vo);
		return result;
	}

	public static ProductSiteRelation convertTProductSiteR(SkuSiteRelation vo)
			throws Exception {
		if (vo == null)
			return null;
		ProductSiteRelation result = new ProductSiteRelation();
		CommonConvert.copyProperties(result, vo);
		return result;
	}

	public static List<SkuSiteRelation> convertTSkuSiteRList(
			List<ProductSiteRelation> voList) throws Exception {
		List<SkuSiteRelation> resultList = new ArrayList<SkuSiteRelation>();
		convertTSkuSiteRList(voList, resultList);
		return resultList;
	}

	public static List<ProductSiteRelation> convertTProductSiteRList(
			List<SkuSiteRelation> voList) {
		List<ProductSiteRelation> resultList = new ArrayList<ProductSiteRelation>();
		convertTProductSiteRList(voList, resultList);
		return resultList;
	}

	public static void convertTSkuSiteRList(List<ProductSiteRelation> voList,
			List<SkuSiteRelation> resultList) {
		if (voList == null) {
			return;
		}
		for (ProductSiteRelation vo : voList) {
			SkuSiteRelation result = new SkuSiteRelation();
			CommonConvert.copyProperties(result, vo);
			resultList.add(result);
		}
	}

	public static void convertTProductSiteRList(List<SkuSiteRelation> voList,
			List<ProductSiteRelation> resultList){
		if (voList == null) {
			return;
		}
		for (SkuSiteRelation vo : voList) {
			ProductSiteRelation result = new ProductSiteRelation();
			CommonConvert.copyProperties(result, vo);
			resultList.add(result);
		}
	}

	public static List<Long> getObjIdList(List<ProductRelation> keyList) {
		if (keyList == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (ProductRelation key : keyList) {
			if (key.getObjId() == null) {
				continue;
			}
			set.add(Long.valueOf(key.getObjId()));
		}
		return new ArrayList<Long>(set);
	}

	public static List<Long> getRelIdList(List<ProductRelation> keyList) {
		if (keyList == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (ProductRelation key : keyList) {
			if (key.getRelId() == null) {
				continue;
			}
			set.add(Long.valueOf(key.getRelId()));
		}
		return new ArrayList<Long>(set);
	}

	public static List<Long> getSpuIdList(List<SkuProduct> keyList) {
		if (keyList == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (SkuProduct key : keyList) {
			if (key.getProductId() == null) {
				continue;
			}
			set.add(Long.valueOf(key.getProductId()));
		}
		return new ArrayList<Long>(set);
	}
	
	public static List<Long> getSkuIdList(List<SkuProduct> keyList) {
		if (keyList == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (SkuProduct key : keyList) {
			if (key.getId() == null) {
				continue;
			}
			set.add(Long.valueOf(key.getId()));
		}
		return new ArrayList<Long>(set);
	}
	

	public static ProductRelease convertTProductRelease(SkuProductQuery query) {
		if (query == null)
			return null;
		ProductRelease result = new ProductRelease();
		CommonConvert.copyProperties(result, query);
		DateQueryParam checkDateQuery = query.getCheckDateQuery();
		if (checkDateQuery != null) {
			DateQuery dateQuery = new DateQuery();
			CommonConvert.copyProperties(dateQuery, checkDateQuery);
			result.setCheckDateParam(dateQuery);
		}
		DateQueryParam publishDateQuery = query.getPublishDateQuery();
		if (publishDateQuery != null) {
			DateQuery dateQuery = new DateQuery();
			CommonConvert.copyProperties(dateQuery, publishDateQuery);
			result.setPublishDateParam(dateQuery);
		}

		return result;
	}

	public static List<SpuProductResultVO> combinationSpuProductResult(
			List<SpuProduct> spuList, List<SkuProduct> skuList,
			Map<Long, List<PCStrategyResult>> pcsMap) throws Exception {
		if (spuList == null)
			return null;
		Map<String, SpuProductResultVO> resultMap = convertListTMap(spuList);
		if (CollectionUtils.isNotEmpty(skuList)) {
			for (SkuProduct sku : skuList) {
				if (sku.getProductId() == null)
					continue;
				String productId_ = sku.getProductId().toString();

				if (!resultMap.containsKey(productId_))
					continue;

				SpuProductResultVO vo = resultMap.get(productId_);
				List<SkuProduct> skus = vo.getSkuProductList();
				Map<Long, List<PCStrategyResult>> pcs = vo.getStrategyList();
				if (skus == null) {
					skus = new ArrayList<SkuProduct>();
					vo.setSkuProductList(skus);
				}
				skus.add(sku);
				if (pcs == null) {
					pcs = new HashMap<Long, List<PCStrategyResult>>();
					vo.setStrategyList(pcs);
				}
				pcs.put(sku.getId(), pcsMap.get(sku.getId()));
			}
		}
		return new ArrayList<SpuProductResultVO>(resultMap.values());
	}

	public static Map<String, SpuProductResultVO> convertListTMap(
			List<SpuProduct> list) {
		Map<String, SpuProductResultVO> result = null;
		try {
			if (CollectionUtils.isNotEmpty(list)) {
				result = new HashMap<String, SpuProductResultVO>(list.size());
				for (SpuProduct t : list) {
					if (t.getId() == null)
						continue;
					SpuProductResultVO vo = new SpuProductResultVO();
					vo.setSpuProduct(t);
					result.put(t.getId().toString(), vo);
				}

			}
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		return result;
	}

	public static ProductInfo convertTProductInfo(BaseInfo info) {
		if (info == null)
			return null;
		ProductInfo pro = new ProductInfo();
		pro.setName(info.getSkuTitle());
		if(info.getCategoryId() != null){
			pro.setProductType(Integer.valueOf(info.getCategoryId()));
		}
		
		pro.setReleaseThurl(info.getCoverImage());
		pro.setStartTime(info.getStartTime());
		pro.setEndTime(info.getEndTime());
		pro.setStartDate(info.getStartDate());
		pro.setEndDate(info.getEndDate());
		pro.setSaleStartDate(info.getSaleStartDate());
		pro.setSaleEndDate(info.getSaleEndDate());
		pro.setProductNo(info.getSkuExtCode());
		if (info.getBossid() != null) {
			String bossId_ = String.valueOf(info.getBossid());
			pro.setCreateBy(bossId_);
			pro.setSupplierId(bossId_);
		}
		pro.setCreateDate(new Date());
		pro.setFlag(String.valueOf(GlobalParam.FLAG.start()));
		pro.setReeaseInfo(info.getSummary());
		pro.setIsNeedScenic(info.getIsNeedScenic());
		if (info.getCheckInType() != null) {
			pro.setCheckInType(String.valueOf(info.getCheckInType()));
		}
		pro.setCheckinAddress(info.getCheckinAddress());
		pro.setIsNeedPlaytime(info.getIsNeedPlaytime());
		pro.setNoPlaytimeOrdertimeType(info.getNoPlaytimeOrdertimeType());
		pro.setOrdertimeValue(info.getOrdertimeValue());
		pro.setOrdertimeUnit(info.getOrdertimeUnit());
		pro.setOneWordFeature(info.getOneWordFeature());
		pro.setProductInfoDetail(info.getDetails());
		pro.setOrderInfo(info.getOrderInfo());
		pro.setExpenseInfo(info.getExpenseInfo());
		pro.setSalesmanship(info.getSalesmanship());
		pro.setImportantClause(info.getImportantClause());
		pro.setAttentions(info.getAttentions());
		pro.setUseMethod(info.getUserMethod());
		pro.setPhotoinfoId(info.getImageList());
		pro.setMoreInfoUrl(info.getMoreInfoUrl());
		pro.setProvince(info.getProvince());
		pro.setCity(info.getCity());
		pro.setCounty(info.getCounty());
		pro.setSkuGrouping(info.getSkuGrouping());
		if (info.getId() != null) {
			pro.setSkuId(info.getId().toString());
		}

		return pro;

	}

	public static List<ProductRelease> convertTPRelease(List<AttrInfo> params,
			BaseInfo info) {
		if (params == null || params.isEmpty() || info == null) {
			return null;
		}

		List<ProductRelease> result = new ArrayList<ProductRelease>();
		for (AttrInfo attr : params) {
			ProductRelease sku = convertTPRelease(attr, info);
			if (sku != null) {
				result.add(sku);
			}
		}
		return result;
	}

	public static ProductRelease convertTPRelease(AttrInfo param, BaseInfo info) {
		if (info == null) {
			return null;
		}
		ProductRelease result = new ProductRelease();

		result.setName(info.getSkuTitle());
		if (StringUtils.isNotBlank(param.getParams())) {
			result.setSkuParamsName(param.getParams());
			result.setProductType("1:"+param.getParams());
		}
		result.setProductCode(info.getSkuExtCode());
		if (param.getPrice() != null) {
			result.setProductPrice(param.getPrice().doubleValue());
			result.setMfPrice(param.getPrice().doubleValue());
		}
		if (info.getBossid() != null) {
			String bossId_ = String.valueOf(info.getBossid());
			result.setCreateBy(bossId_);
			result.setSupplierId(bossId_);
		}
		if (info.getId() != null) {
			result.setSkuId(info.getId().toString());
		}
		result.setCreateDate(new Date());
		result.setCheckDate(new Date());
		result.setFlag(GlobalParam.FLAG.start().toString());
		result.setProCategory(info.getCategoryId());
		result.setAuditStatus(GlobalParam.FLAG.pending().toString());
		
		if(param.getUnlimitedInventory() == null ){
			if(param.getStockRuleId() == null){
				result.setUnlimitedInventory(true);
			}else{
				result.setUnlimitedInventory(false);
			}
			
		}else{
			result.setUnlimitedInventory(param.getUnlimitedInventory());
		}
		
		result.setStockRuleId(param.getStockRuleId());
		result.setIsSimple(info.getIsSimple());
		result.setEmailNotification(info.getEmailNotification());
		if (param.getAttrId() != null)
			result.setAttrInfoId(String.valueOf(param.getAttrId()));
		result.setDefaultValue(param.getDefaultValue());
		result.setHasPrice(param.getHasPrice());
		result.setIsDisplayRange(param.getIsDisplayRange());
		result.setIsRequired(param.getIsRequired());
		if (param.getIsGroup() != null)
			result.setParamIsGroup(param.getIsGroup().intValue());
		result.setMinNumber(param.getMinNumber());
		result.setMaxNumber(param.getMaxNumber());
		if (info.getCheckInType() != null)
			result.setCheckInType(String.valueOf(info.getCheckInType()));
		
		result.setConsumerCardType(info.getConsumerCardType());
		
		// 为了api上的接口
		result.setStartDate(info.getStartDate());
		result.setEndDate(info.getEndDate());

		return result;
	}

	public static void convertPSTPCAddress(List<ProductScenic> scenicList,
			Set<PCAddressResult> set) {
		if (CollectionUtils.isEmpty(scenicList)) {
			return;
		}

		for (ProductScenic ps : scenicList) {
			if(StringUtils.isBlank(ps.getProvince()) || StringUtils.isBlank(ps.getCity())){
				continue;
			}
			PCAddressResult result = new PCAddressResult(ps.getProvince(),
					ps.getCity());
			set.add(result);
		}
	}

	public static void convertPITPCAddress(List<ProductInfo> infoList,
			Set<PCAddressResult> set) {
		if (CollectionUtils.isEmpty(infoList)) {
			return;
		}

		for (ProductInfo ps : infoList) {
			if(StringUtils.isBlank(ps.getProvince()) || StringUtils.isBlank(ps.getCity())){
				continue;
			}
			PCAddressResult result = new PCAddressResult(ps.getProvince(),
					ps.getCity());
			set.add(result);
		}
	}

	public static void convertTProduct(SkuProductModificationVO vo,
			ProductRelease result) {
		CommonConvert.copyProperties(result, vo.getSkuProduct());

	}

	public static ProductRelease convertTProduct(SkuProductModificationVO vo) {
		ProductRelease result = new ProductRelease();
		CommonConvert.copyProperties(result, vo.getSkuProduct());
		return result;
	}
    public static ProductRondaRelation convertTProductRondaRelation(SkuRondaRelation vo){
    	ProductRondaRelation result = new ProductRondaRelation();
    	CommonConvert.copyProperties(result, vo);
    	return result;
    }
	
	public static void convertTPRondaRelationList(List<SkuRondaRelation> voList,
			List<ProductRondaRelation> result) {
		for(SkuRondaRelation rel : voList){			
			result.add(convertTProductRondaRelation(rel));
		}

	}
	
	public static List<ProductRondaRelation> convertTPRondaRelationList(List<SkuRondaRelation> voList) {
		List<ProductRondaRelation> result = new ArrayList<ProductRondaRelation>();
		convertTPRondaRelationList(voList,result);
		return result;
		

	}

	public static ProductRelease convertTProductRondaRelation(SkuProductModificationVO vo) {
		ProductRelease result = new ProductRelease();
		CommonConvert.copyProperties(result, vo.getSkuProduct());
		return result;
	}
	
	
	public static void dissectSkuProductModificationVO(
			List<SkuProductModificationVO> voList, ProductInfoModification result) {
		if(voList == null || result == null){
			return ;
		}
		List<ProductRelease> prList = result.getPrList();
		Map<ProductRelease, List<ProductRondaRelation>> relationMap = result.getRondaRelation();
		for (SkuProductModificationVO vo : voList) {
			if (vo.isExistSku()){
				ProductRelease pr = convertTProduct(vo);
				if(prList == null){
					prList = new ArrayList<ProductRelease>();
					result.setPrList(prList);
				}
				prList.add(pr);
				if(vo.isExistSkuRondaRelation()){
					if(relationMap == null){
						relationMap = new HashMap<ProductRelease, List<ProductRondaRelation>>();
						result.setRondaRelation(relationMap);
					}
					relationMap.put(pr, convertTPRondaRelationList(vo.getRondaRelations()));
				}					
			}
		}

	}

	public static ProductInfoModification convertTProduct(
			JsonSkuDto vo) {
		if (vo == null || vo.getBaseInfo() == null) {
			return null;
		}
		ProductInfoModification result = new ProductInfoModification();
		result.setInfo(convertTProductInfo(vo.getBaseInfo()));
		
		if(!CollectionUtils.isEmpty(vo.getAttrInfos())){
			result.setPrList(convertTPRelease(vo.getAttrInfos(), vo.getBaseInfo()));
		}
		if(!CollectionUtils.isEmpty(vo.getTimeSlots())){
			result.setSlotList(convertTPCloseTimeList(vo.getTimeSlots()));
		}
		return result;

	}
	public static ProductInfoModification dissectSpuProductModificationVO(
			SpuProductModificationVO vo) {
		if (vo == null) {
			return null;
		}
		ProductInfoModification result = new ProductInfoModification();
		if (vo.getProductInfo() != null) {
		   result.setInfo(convertTProductInfo(vo.getProductInfo()));	
		}
		if (vo.getSkuProducts() != null) {
			dissectSkuProductModificationVO(vo.getSkuProducts(),result);
		}
		if( vo.getCloseTimeSlotIds() != null){
			result.setSlotList(convertTPCloseTimeList(vo.getCloseTimeSlotIds()));				
		}
		if( vo.getScenicIds() != null){
			result.setScenicList(vo.getScenicIds());
		}		
		if(vo.getSiteDataRelations() != null){
			result.setSiteRelationList(convertTProductSiteRList(vo.getSiteDataRelations()));
		}
		
		return result;

	}
	public static List<Long> getSiteIdList(List<ProductSiteRelation> list){
		if (list == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (ProductSiteRelation key : list) {
			if (key.getSiteId() == null) {
				continue;
			}
			set.add(key.getSiteId());
		}
		return new ArrayList<Long>(set);
	}
	public static List<Product> combinationTProduct(List<ProductRelease> prList,List<ProductInfo> infoList,List<ProductCloseTimeslot> slotList){
    	if(CollectionUtils.isEmpty(prList)){
    		return null;
    	}
    	if(CollectionUtils.isEmpty(infoList)){
    		return null;
    	}
    	List<Product> result = new ArrayList<Product>();
    	Map<String,ProductInfo> infoMap = CommonConvert.convertListTMapS(infoList);
    	Map<String,List<ProductCloseTimeslot>> slotMap = null;
    	if(CollectionUtils.isEmpty(slotList)){
    		slotMap = new HashMap<String,List<ProductCloseTimeslot>>();
    	}else{
    		slotMap = ModelOperateUtil.getInstance().getInfoCloseSlotMap(slotList);
    	}
    	for(ProductRelease pr : prList){
    		Product product = new Product();
    		Long infoId = pr.getProductId();
    		if(infoId == null)
    			continue;
    		product.setInfo(infoMap.get(infoId.toString()));
    		product.setRelease(pr);
    		product.setSlotList(slotMap.get(infoId.toString()));   		
    		result.add(product);
    	}
    	
    	return result;

    }
	
	public static void combinationTProductRelease(ProductInfo info,List<ProductRelease> prList){
		if(info == null){
			return ;
		}		
    	if(CollectionUtils.isEmpty(prList)){
    		return ;
    	}   	
    	for(ProductRelease pr : prList){
    		pr.setProductId(info.getId());
    	}
    }

	public static List<SkuProductForScenic> convertProductReleaseTSkuProductForScenic(Map<Long, List<PCStrategyResult>> pcsMap, List<ProductRelease> skuList) {
		List<SkuProductForScenic> skuProductForScenicList = new ArrayList<>();
		for (ProductRelease release : skuList){
			SkuProductForScenic skuProductForScenic = new SkuProductForScenic();
			SkuProduct skuProduct = ProductConvert.convertTSkuProduct(release);
			skuProductForScenic.setSkuProduct(skuProduct);

			ProductInfo productInfo = release.getProductInfo();
			SpuProduct spuProduct = ProductConvert.convertTSpuProduct(productInfo);
			skuProductForScenic.setSpuProduct(spuProduct);

			List<PCStrategyResult> strategyResultList = pcsMap.get(release.getId());
			skuProductForScenic.setStrategyList(strategyResultList);
			skuProductForScenicList.add(skuProductForScenic);
		}
		return skuProductForScenicList;
	}
	
	public static ProductScenic convertTProductScenic(SkuScenicQuery scenic){
		if(scenic == null){
			return null;
		}
		ProductScenic result = new ProductScenic();
		result.setName(scenic.getName());
		return result;
	}
	
	public static SkuScenic convertTSkuScenic(ProductScenic scenic){
		if(scenic == null){
			return null;
		}
		SkuScenic result = new SkuScenic();
		CommonConvert.copyProperties(result, scenic);
		return result;
	}
	
	public static ArrayList<SkuScenic> convertTSkuScenic(List<ProductScenic> scenics){
		if(CollectionUtils.isEmpty(scenics)){
			return null;
		}
		
		ArrayList<SkuScenic> result = new ArrayList<SkuScenic>();
		for(ProductScenic scenic : scenics){
			result.add(convertTSkuScenic(scenic));
		}	
		return result;
	}
	
}
