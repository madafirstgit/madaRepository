/*
 * ProductSiteRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductSiteRelation;
import com.pzj.base.product.IProductSiteRelationMapper;
import com.pzj.base.service.product.IProductSiteRelationService;

/**
 * service接口实现.区域
 * @author 票之家
 */
@Service
public class ProductSiteRelationServiceImpl extends
                                            BaseServiceImpl<ProductSiteRelation, IProductSiteRelationMapper>
                                            implements IProductSiteRelationService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void saveSkuAndSiteRelation(ProductInfo info, Long supplierId,
                                       List<ProductSiteRelation> siteList){
        if (info == null) {
            logger.error("更新产品与景点关系接口[saveSkuAndSiteRelation]：传入参数没有产品组信息");
            return;
        }
        if (siteList == null) {
            logger.error("更新产品与景点关系接口[saveSkuAndSiteRelation]：传入参数没有景点信息");
            return;
        }
        List<ProductSiteRelation> addRelation = new ArrayList<ProductSiteRelation>();
        List<ProductSiteRelation> deleteRelation = new ArrayList<ProductSiteRelation>();
        ProductSiteRelation delete = new ProductSiteRelation();
        delete.setProductInfoId(info.getId());
        delete.setSupplierId(
            info.getSupplierId() == null ? 0l : Long.parseLong(info.getSupplierId()));
        if (supplierId != null) {
            delete.setSupplierId(supplierId);
        }
        deleteRelation.add(delete);

        for (ProductSiteRelation relation : siteList) {
            if (relation.getSiteId() == null)
                continue;
            relation.setFlag(GlobalParam.FLAG.start());
            relation.setProductInfoId(info.getId());
            relation.setCreateBy(info.getCreateBy());
            relation.setCreateDate(new Date());
            relation.setUpdateDate(new Date());
            relation.setSupplierId(
                info.getSupplierId() == null ? 0l : Long.parseLong(info.getSupplierId()));
            if (supplierId != null) {
                relation.setSupplierId(supplierId);
            }
            addRelation.add(relation);
        }

        //1.先删除
        deleteBatchByParam(deleteRelation);

        //2.添加
        insertBatch(addRelation);

    }

    @Override
    public Integer deleteBatchByParam(List<ProductSiteRelation> deleteRelationList) {
        if (deleteRelationList == null)
            return 0;

        return mapper.deleteBatchByParam(deleteRelationList);
    }

}
