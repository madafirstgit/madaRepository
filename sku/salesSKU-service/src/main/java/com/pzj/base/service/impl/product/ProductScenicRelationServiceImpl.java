package com.pzj.base.service.impl.product;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductScenicRelation;
import com.pzj.base.product.IProductScenicRelationMapper;
import com.pzj.base.service.product.IProductScenicRelationService;

@Service
@Lazy
public class ProductScenicRelationServiceImpl extends
                                              BaseServiceImpl<ProductScenicRelation, IProductScenicRelationMapper>
                                              implements IProductScenicRelationService {

    @Override
    public List<ProductScenicRelation> findByIdsMap(Map<String, Object> ids) {
        return mapper.findByIdsMap(ids);
    }

    @Override
    public int deleteByParam(ProductScenicRelation param) {
        return mapper.deleteByParam(param);
    }

    @Override
    public Long insertBatch(List<ProductScenicRelation> relList) {
        if (relList == null || relList.isEmpty()) {
            return null;
        }
        ProductScenicRelation param = new ProductScenicRelation();

        for (ProductScenicRelation rel : relList) {
            if (!rel.getScenicId().equals(param.getScenicId())) {
                param.setScenicId(rel.getScenicId());
                mapper.deleteByParam(param);
            }
        }

        return mapper.insertBatch(relList);
    }

    @Override
    public void setRelationBatch(List<Long> scenicIdList, Long supplierId) {
        if (supplierId == null || scenicIdList == null || scenicIdList.size() == 0) {
            return;
        }

        ProductScenicRelation param = new ProductScenicRelation();
        param.setRelId(supplierId);
        param.setRelType(GlobalParam.SUPPILER_TBL);
        mapper.deleteByParam(param);

        List<ProductScenicRelation> relList = new ArrayList<ProductScenicRelation>();
        for (Long scenicId : scenicIdList) {

            ProductScenicRelation rel = new ProductScenicRelation();
            rel.setScenicId(scenicId);
            rel.setRelId(supplierId);
            rel.setRelType(GlobalParam.SUPPILER_TBL);
            relList.add(rel);
        }
        super.insertBatch(relList);
    }

    @Override
    public void setRelationBatch(Long scenicId, List<Long> supplierIdList) {
        if (supplierIdList == null || supplierIdList == null || supplierIdList.size() == 0) {
            return;
        }

        ProductScenicRelation param = new ProductScenicRelation();
        param.setScenicId(scenicId);

        mapper.deleteByParam(param);

        List<ProductScenicRelation> relList = new ArrayList<ProductScenicRelation>();
        for (Long supplierId : supplierIdList) {

            ProductScenicRelation rel = new ProductScenicRelation();
            rel.setScenicId(scenicId);
            rel.setRelId(supplierId);
            rel.setRelType(GlobalParam.SUPPILER_TBL);
            relList.add(rel);
        }

        super.insertBatch(relList);
    }

    public PageList<ProductScenicRelation> queryScenicRelationByParam(PageModel pager,
                                                                      ProductScenicRelation entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", entity);
        List<ProductScenicRelation> listBean = mapper.queryScenicRelationByParam(params);
        Integer count = mapper.countScenicRelationByParam(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<ProductScenicRelation> pagelist = null;
        pagelist = new PageList<ProductScenicRelation>(listBean, pageObj);
        return pagelist;
    }
}
