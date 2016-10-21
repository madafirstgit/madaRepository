package com.pzj.product.vo.voParam.resultParam;

import com.pzj.product.vo.product.SpuProduct;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016-8-25.
 */
public class SkuProductForCommonsResult implements Serializable {
    private List<SpuProduct> spuProductList;

    public List<SpuProduct> getSpuProductList() {
        return spuProductList;
    }

    public void setSpuProductList(List<SpuProduct> spuProductList) {
        this.spuProductList = spuProductList;
    }
}
