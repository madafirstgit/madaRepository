package com.pzj.product.vo.voParam.resultParam;

import java.io.Serializable;
import java.util.List;

public class SkuImportResult implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5395426197976627446L;
    
    private List<Long> productIdList;

	public List<Long> getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(List<Long> productIdList) {
		this.productIdList = productIdList;
	}
    
    
    
}
