package com.pzj.base.service.impl.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.product.IProductScenicMapper;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.base.service.product.IProductSiteDataService;
import com.pzj.product.vo.voParam.queryParam.AppSearchQuery;

@Lazy
@Service
public class ProductScenicServiceImpl extends BaseServiceImpl<ProductScenic, IProductScenicMapper>
                                      implements IProductScenicService {

    @Autowired
    private IProductSiteDataService productSiteDataService;

    @Override
    public Long insert(ProductScenic entity, List<ProductSiteData> siteList) {
        super.insert(entity);
        Long id = entity.getId();
        if (siteList != null && !siteList.isEmpty()) {
            for (ProductSiteData site : siteList) {
                site.setParentId(id);
            }
            productSiteDataService.updateBatchByPrimaryKey(siteList);
        }
        return id;
    }

    @Override
    public int update(ProductScenic entity, List<ProductSiteData> siteList) {
        int r = super.updateByPrimaryKey(entity);
        productSiteDataService.resetParentId(entity.getId());
        if (siteList != null && !siteList.isEmpty()) {
            for (ProductSiteData site : siteList) {
                site.setParentId(entity.getId());
            }
            productSiteDataService.updateBatchByPrimaryKey(siteList);
        }
        return r;
    }

    @Override
    public List<ProductScenic> findByIdsMap(Map<String, List<Long>> idsMap) {
        return mapper.findByIdsMap(idsMap);
    }

    public List<ProductScenic> queryScenicWithOutParentId(Long parentId) {

        return mapper.queryScenicWithOutParentId(parentId);
    }

    public List<ProductScenic> queryScenicWithParentId(Long parentId) {

        return mapper.queryScenicWithParentId(parentId);
    }

    @Override
    public PageList<ProductScenic> queryByParamMapWithRelation(PageModel pager,
                                                               ProductScenic entity) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", entity);

        List<ProductScenic> listBean = mapper.queryByParamMapWithRelation(params);
        Integer count = mapper.countByParamMapWithRelation(params);
        PageBean pageObj = new PageBean(count, pager);
        //		pageObj.setTotalCount(Long.valueOf(count.toString()));
        PageList<ProductScenic> pagelist = null;
        pagelist = new PageList<ProductScenic>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<ProductScenic> queryListWithRelation(ProductScenic entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bParam", entity);
        return mapper.queryByParamMapWithRelation(params);
    }

    @Override
    public List<String> queryAllProvices() {

        return mapper.findAllProvinces();
    }

    /**
     * 按照供应商id精确查询,再根据景区名称,供应商名称模糊查询景区列表
     * @param localSupplierId 供应商ID
     * @param scenicName 景区名称（支持模糊查询）
     * @param supplierName 供应商名称（支持模糊查询）
     * @return List<ProductScenic> 景区集合
     */
    @Override
    public List<ProductScenic> queryLikeScenics(Long localSupplierId, String scenicName,
                                                String supplierName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("localSupplierId", localSupplierId);
        params.put("scenicName", scenicName);
        params.put("supplierName", supplierName);
        return mapper.findLikeScenics(params);
    }

    @Override
    public List<ProductScenic> queryScenicByProductId(ProductScenic scenic, Long productId) {
        List<ProductScenic> productScenicList = mapper.selectScenicByProductRelation(scenic,
            productId, "proRelease");
        return productScenicList;
    }

    /**
     * 根据景区名称，景区省市县查询景区
     * @param query
     * @return
     */
    @Override
    public List<ProductScenic> queryScenicsByAppSearchKey(AppSearchQuery query) {
        ProductScenic scenicQuery = new ProductScenic();
        scenicQuery.setSearchKey(query.getSearchKey());
        scenicQuery.setId(query.getId());
        scenicQuery.setProvince(query.getProvince());
        scenicQuery.setCity(query.getCity());
        scenicQuery.setCounty(query.getCounty());
        scenicQuery.setStatus(GlobalParam.FLAG.start());
        return mapper.selectScenicsByAppSearchKey(scenicQuery);
    }

	@Override
	public List<ProductScenic> findAddressByProductId(List<Long> productIds) {
		// TODO Auto-generated method stub
		return mapper.selectAddressByProductId(productIds);
	}

	@Override
	public List<ProductScenic> queryScenicsByName(String name) {

		return mapper.selectScenicByName(name);
	}

}
