/*
 * ProductPackageService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductPackage;
import com.pzj.base.entity.product.ProductPackageSub;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.product.IProductPackageMapper;
import com.pzj.base.service.product.IProductPackageService;
import com.pzj.base.service.product.IProductPackageSubService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductReleaseService;

/**
 * service接口实现.联票子票主
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductPackageServiceImpl extends
                                       BaseServiceImpl<ProductPackage, IProductPackageMapper>
                                       implements IProductPackageService {

    private Logger                    logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IProductPackageSubService productPackageSubService;

    @Autowired
    private IProductRelationService   productRelationService;

    @Autowired
    private IProductReleaseService    productReleaseService;

    @Override
    public Long insert(ProductPackage entity, List<ProductPackageSub> subList,
                       List<ProductRelation> packageRelList) {
        mapper.insert(entity); // 新增联票子票主
        Long packageId = entity.getId();

        //		ProductRelease release = new ProductRelease();
        //		release.setId(entity.getProductId());
        //		release.setPackageStatus(PackageStatus.generated());
        //
        //		productReleaseService.updateByPrimaryKey(release);// 更新子票基础信息的状态已生成联票子票

        if (packageRelList != null && packageRelList.size() > 0) {
            for (ProductRelation rel : packageRelList) {
                rel.setObjId(packageId);
            }

            productRelationService.insertBatch(packageRelList);// 保存联票子票主和景区的关系
        }
        if (subList != null) {
            for (ProductPackageSub sub : subList) {
                sub.setPackageId(packageId);
                if (sub.getScenicList() != null) {
                    sub.setScenicCnt(sub.getScenicList().size());
                }
            }
            productPackageSubService.insertBatch(subList);// 批量新增联票字表

            List<ProductRelation> relList = new ArrayList<ProductRelation>();// 联票子表和景区的关联关系
            for (ProductPackageSub sub : subList) {
                if (sub.getScenicList() != null) {
                    for (ProductScenic scenic : sub.getScenicList()) {
                        ProductRelation rel = new ProductRelation();
                        rel.setObjId(sub.getId());
                        rel.setObjType(GlobalParam.PACKAGE_SUB);

                        rel.setRelId(scenic.getId());
                        rel.setRelType(GlobalParam.SCENIC);

                        relList.add(rel);
                    }
                }
            }

            if (relList.size() > 0) {
                productRelationService.insertBatch(relList);
            }
        }
        return packageId;
    }

    @Override
    public void batchInsert(List<ProductPackage> entityList) {
        if (entityList == null) {
            return;
        }

        mapper.insertBatch(entityList); // 新增联票子票主表

        List<ProductRelation> packageRelList = new ArrayList<ProductRelation>();//主产品和景区的关联关系

        List<ProductPackageSub> packageSubList = new ArrayList<ProductPackageSub>();//返利政策集合
        for (ProductPackage entity : entityList) {

            if (entity.getRelList() != null) {
                for (ProductRelation rel : entity.getRelList()) {
                    rel.setObjId(entity.getId());
                    packageRelList.add(rel);
                }
            }

            if (entity.getSubList() != null) {
                for (ProductPackageSub sub : entity.getSubList()) {
                    sub.setPackageId(entity.getId());
                    if (sub.getScenicList() != null) {
                        sub.setScenicCnt(sub.getScenicCnt());
                    }
                    packageSubList.add(sub);
                }

            }
        }
        productRelationService.insertBatch(packageRelList);// 保存联票子票主和景区的关系
        if (packageSubList.size() < 1) {
            return;
        }
        productPackageSubService.insertBatch(packageSubList);// 批量新增联票字表

        List<ProductRelation> relList = new ArrayList<ProductRelation>();// 联票子表和景区的关联关系
        for (ProductPackageSub sub : packageSubList) {
            if (sub.getScenicList() != null) {
                for (ProductScenic scenic : sub.getScenicList()) {
                    ProductRelation rel = new ProductRelation();
                    rel.setObjId(sub.getId());
                    rel.setObjType(GlobalParam.PACKAGE_SUB);

                    rel.setRelId(scenic.getId());
                    rel.setRelType(GlobalParam.SCENIC);

                    relList.add(rel);
                }
            }
        }

        if (relList.size() > 0) {
            productRelationService.insertBatch(relList);
        }

    }
}
