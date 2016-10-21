package com.pzj.util.productConvertUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.product.vo.JsonSkuDto;
import com.pzj.product.vo.product.SkuProduct;

public class ProductCheckUtil {

    public static void checkAddData(List<ProductRelease> list) {
        for (ProductRelease vo : list) {
            checkAddData(vo);
        }

    }

    public static void checkAddData(ProductRelease vo) {
        if (StringUtils.isBlank(vo.getFlag())) {
            vo.setFlag(GlobalParam.FLAG.start().toString());
        }
        if(vo.getCreateDate() == null){
        	vo.setCreateDate(new Date());
        }
        
        
        if(StringUtils.isBlank(vo.getProCategory())){
        	throw new SkuParamNullException("产品："+vo.getName()+"的类别为空");
        }
        
        if(StringUtils.isBlank(vo.getSupplierId())){
        	throw new SkuParamNullException("产品："+vo.getName()+"的供应商id{supplierId}为空");
        }
        
        if(vo.getUnlimitedInventory()!= null && !vo.getUnlimitedInventory()){
        	if(vo.getStockRuleId()== null || vo.getStockRuleId()== 0){
        		throw new SkuParamNullException("产品："+vo.getName()+"的库存id为空");
        	}
        }
        
        if(vo.getTheaterId() != null && vo.getTheaterId() == 0){
        	throw new SkuParamNullException("产品："+vo.getName()+"的剧场id为0");
        }
        
     
    }

    public static void checkAddData(ProductInfo vo) {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (StringUtils.isBlank(vo.getFlag())) {
            vo.setFlag(GlobalParam.FLAG.start().toString());
        }
        try{
        	if(vo.getStartDate() == null){
        		
        	}
        	
        	if(vo.getStartDate() != null){
            	String ymd = format.format(vo.getStartDate());
            	vo.setStartDate(format1.parse(ymd+" 00:00:00"));
            }
        	
        	if(vo.getEndDate() != null){
            	String ymd = format.format(vo.getEndDate());
            	vo.setEndDate(format1.parse(ymd+" 23:59:59"));
            }
        	
        	
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
        
    }
  

    public static Boolean isCanImportSku(JsonSkuDto dto) {
        if (dto == null) {
        	throw new SkuParamNullException("上架产品信息为空");
        }
        if (dto.getBaseInfo() == null) {
        	throw new SkuParamNullException("上架产品baseInfo信息为空");
        }
        if (dto.getBaseInfo().getId() == null) {
        	throw new SkuParamNullException("上架产品baseInfo.id信息为空");
        }
        if(StringUtils.isBlank(dto.getBaseInfo().getCategoryId() )){
        	throw new SkuParamNullException("上架产品baseInfo.categoryId信息为空");
        }
        
        return true;
    }

    public static Boolean isCanImportSku(List<JsonSkuDto> dtos) {
        if (dtos == null)
            return false;
        for (JsonSkuDto dto : dtos) {
            if (!isCanImportSku(dto)) {
                return false;
            }
        }

        return true;
    }

    public static Boolean isHaveParentId(List<SkuProduct> skuList) {
        if (CollectionUtils.isEmpty(skuList))
            return false;
        for (SkuProduct sku : skuList) {
            if (!isHaveParentId(sku)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isHaveParentId(SkuProduct sku) {
        if (sku == null)
            return false;
        if (sku.getId() == null)
            return false;

        return true;
    }
    
    
}
