package com.pzj.base.service.impl.product;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductRuleRel;
import com.pzj.base.product.IProductRuleRelMapper;
import com.pzj.base.service.product.IProductRuleRelService;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 * @Describe:
 */
@Service(value = "productRuleRelService")
public class ProductRuleRelServiceImpl extends
                                       BaseServiceImpl<ProductRuleRel, IProductRuleRelMapper>
                                       implements IProductRuleRelService {
    @Autowired
    IProductRuleRelMapper mapper;

    public List<Long> getRuleIdList(List<ProductRuleRel> voList) {
        if (voList == null || voList.isEmpty()) {
            return null;
        }
        Set<Long> ruleIds = new HashSet<Long>();
        for (ProductRuleRel rel : voList) {
            Long ruleId = rel.getR_id();
            ruleIds.add(ruleId);
        }
        List<Long> ruleIdList = new ArrayList<Long>(ruleIds);
        return ruleIdList;
    }

    @Override
    @Deprecated
    public Long insert(ProductRuleRel entity) {
        // TODO Auto-generated method stub
        return super.insert(entity);
    }

    @Override
    @Deprecated
    public Integer updateByPrimaryKey(ProductRuleRel entity) {
        // TODO Auto-generated method stub
        return super.updateByPrimaryKey(entity);
    }

    @Override
    @Deprecated
    public Long insertOrUpdate(ProductRuleRel entity) {
        // TODO Auto-generated method stub
        return super.insertOrUpdate(entity);
    }

    @Override
    @Deprecated
    public Integer delete(Long id) {
        // TODO Auto-generated method stub
        return super.delete(id);
    }

    @Override
    @Deprecated
    public List<ProductRuleRel> findListByParams(ProductRuleRel entity) {
        // TODO Auto-generated method stub
        return super.findListByParams(entity);
    }

    @Override
    @Deprecated
    public Long insertBatch(List<ProductRuleRel> entityList) {
        // TODO Auto-generated method stub
        return super.insertBatch(entityList);
    }

    @Override
    @Deprecated
    public Integer updateBatchByPrimaryKey(List<ProductRuleRel> entityList) {
        // TODO Auto-generated method stub
        return super.updateBatchByPrimaryKey(entityList);
    }

    @Override
    @Deprecated
    public Long insertOrUpdateBatch(List<ProductRuleRel> entityList) {
        // TODO Auto-generated method stub
        return super.insertOrUpdateBatch(entityList);
    }

    @Override
    @Deprecated
    public Map<String, ProductRuleRel> listTMap(List<ProductRuleRel> entityList, String regx) {
        // TODO Auto-generated method stub
        return super.listTMap(entityList, regx);
    }

}
