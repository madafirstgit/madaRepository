package com.pzj.product.vo.voParam.queryParam;

import java.util.List;

import com.pzj.product.vo.product.SpuProduct;

public class SpuProductQuery extends SpuProduct {

    /**
     * 
     */
    private static final long serialVersionUID = 2677008790779266190L;

    /** 支持in查询，扩展属性，不持久化 */
    private List<Long>        ids;

    /**
     * 多个产品类别:
     * 常量 ：GlobalDict.ProductCategory
     * 只用于查询
     */
    private List<Integer>    productTypes;
    /**
     * 产品销售日期段查询
     */
    private DateQueryParam saleDateQuery;

    /**
     * 产品可用日期查询
     */
    private DateQueryParam availableDateQuery;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

	public DateQueryParam getSaleDateQuery() {
		return saleDateQuery;
	}

	public void setSaleDateQuery(DateQueryParam saleDateQuery) {
		this.saleDateQuery = saleDateQuery;
	}

    public List<Integer> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<Integer> productTypes) {
        this.productTypes = productTypes;
    }

    public DateQueryParam getAvailableDateQuery() {
        return availableDateQuery;
    }

    public void setAvailableDateQuery(DateQueryParam availableDateQuery) {
        this.availableDateQuery = availableDateQuery;
    }
}
