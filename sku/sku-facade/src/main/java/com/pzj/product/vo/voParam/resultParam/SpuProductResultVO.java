package com.pzj.product.vo.voParam.resultParam;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.pzj.channel.Strategy;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SpuProduct;

public class SpuProductResultVO implements Serializable {

    /**
     * 
     */
    private static final long                 serialVersionUID = 4615342749262386603L;

    /** 产品组信息*/
    private SpuProduct                        spuProduct;

    /** 产品信息*/
    private List<SkuProduct>                  skuProductList;

    /** key:产品id，value:产品id，渠道id，政策信息*/
    private Map<Long, List<PCStrategyResult>> strategyList;

    /** 产品关闭时间事件*/
    private List<SkuCloseTimeSlot>            closeTimeSlotList;

    public SpuProduct getSpuProduct() {
        return spuProduct;
    }

    public void setSpuProduct(SpuProduct spuProduct) {
        this.spuProduct = spuProduct;
    }

    public List<SkuProduct> getSkuProductList() {
        return skuProductList;
    }

    public void setSkuProductList(List<SkuProduct> skuProductList) {
        this.skuProductList = skuProductList;
    }

    public Map<Long, List<PCStrategyResult>> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(Map<Long, List<PCStrategyResult>> strategyList) {
        this.strategyList = strategyList;
    }

    public String toString() {
    	StringBuffer strbuff = new StringBuffer();
    	strbuff.append("产品组id,产品组名称： "+getSpuProduct().getId()+","+getSpuProduct().getName()).append("\n");
    	
    	List<SkuProduct> skuList1 = getSkuProductList();
    	Map<Long, List<PCStrategyResult>> strategyList = getStrategyList();
    	for(SkuProduct sku: skuList1){
    		strbuff.append("--产品id,产品名称： "+sku.getId()+","+getSpuProduct().getName()).append("\n");
    		Long skuId = sku.getId();
    		List<PCStrategyResult> strResult = strategyList.get(skuId);
    		for(PCStrategyResult result1 : strResult){
    			strbuff.append("----渠道id,渠道名称： "+result1.getChannel().getId()+","+result1.getChannel().getName()).append("\n");
    			List<Strategy> strList = result1.getStrategyList();
    			for(Strategy str : strList){
                    if (str != null)
    				    strbuff.append("------政策id,政策名称： "+str.getId()+","+str.getName()).append("\n");
    			}
    		}
    		System.out.println("--------------------------------------------------");
    	}
    	
        return strbuff.toString();
    }

    public List<SkuCloseTimeSlot> getCloseTimeSlotList() {
        return closeTimeSlotList;
    }

    public void setCloseTimeSlotList(List<SkuCloseTimeSlot> closeTimeSlotList) {
        this.closeTimeSlotList = closeTimeSlotList;
    }
}
