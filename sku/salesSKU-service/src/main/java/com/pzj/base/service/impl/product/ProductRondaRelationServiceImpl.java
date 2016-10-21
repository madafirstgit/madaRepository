/*
 * ProductRondaRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;
import com.pzj.base.product.IProductRondaRelationMapper;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.product.IProductRondaRelationService;

/**
 * service接口实现.区域
 * @author 票之家
 */
@Service
public class ProductRondaRelationServiceImpl extends
                                             BaseServiceImpl<ProductRondaRelation, IProductRondaRelationMapper>
                                             implements IProductRondaRelationService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void saveSkuAndRondaRelation(Map<ProductRelease, List<ProductRondaRelation>> rondaMap) {
        if (rondaMap == null || rondaMap.isEmpty()) {
            throw new SkuParamNullException("更新产品与场次区域关系接口[saveSkuAndRondaRelation]：传入参数没有产品信息");
        }
        List<ProductRondaRelation> addRelation = new ArrayList<ProductRondaRelation>();
        List<ProductRondaRelation> deleteRelation = new ArrayList<ProductRondaRelation>();

        for (Map.Entry<ProductRelease, List<ProductRondaRelation>> entry : rondaMap.entrySet()) {
            ProductRelease key = entry.getKey();
            List<ProductRondaRelation> ronList = entry.getValue();
            if (ronList == null)
                continue;
            ProductRondaRelation delete = new ProductRondaRelation();
            delete.setProductInfoId(key.getProductId());
            delete.setProductId(key.getId());
            delete.setSupplierId(
                key.getSupplierId() == null ? 0l : Long.parseLong(key.getSupplierId()));
            deleteRelation.add(delete);

            for (ProductRondaRelation add : ronList) {     
                add.setCreateBy(key.getCreateBy());
                add.setCreateDate(new Date());
                add.setFlag(GlobalParam.FLAG.start());
                add.setProductId(key.getId());
                add.setProductInfoId(key.getProductId());
                add.setSupplierId(StringUtils.isBlank(key.getSupplierId()) ? 0l
                    : Long.valueOf(key.getSupplierId()));
                addRelation.add(add);
            }
        }

        //1.先删除
        deleteBatchByParam(deleteRelation);

        //2.添加
        insertBatch(addRelation);

    }

    public Integer deleteBatchByParam(List<ProductRondaRelation> deleteRelationList) {
        if (deleteRelationList == null)
            return 0;

        return mapper.deleteBatchByParam(deleteRelationList);
    }
    
    public List<ProductRondaRelation> queryPRondaRelationByProductId(Long productId){
    	 if (productId == null) {
	            return null;
	        }
    	 ProductRondaRelation key = new ProductRondaRelation();
	     key.setProductId(productId);
	     return this.findListByParams(key);
    }

}
