package com.pzj.base.entity.product;

import java.util.List;

/**
 * 积分规则实体
 *
 * 由于保存在ProductDict中，所以继承了ProductDict。
 * 创建这类，是由于积分规则独有的属性，为了不与ProductDict混淆，业务各自独立。
 * Created by Administrator on 2016-1-26.
 */
public class ProductRulesIntegral extends ProductDict {
    /**
     * 积分规则的产品集合。
     */
    private List<ProductRelease> productReleasesList;

    public List<ProductRelease> getProductReleasesList() {
        return productReleasesList;
    }

    public void setProductReleasesList(List<ProductRelease> productReleasesList) {
        this.productReleasesList = productReleasesList;
    }
}
