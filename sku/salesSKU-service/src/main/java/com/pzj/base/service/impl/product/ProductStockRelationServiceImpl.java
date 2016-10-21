
package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductStockRelation;
import com.pzj.base.entity.product.query.ProductStockRelationQuery;
import com.pzj.base.product.IProductStockRelationMapper;
import com.pzj.base.service.model.util.ModelOperateUtil;
import com.pzj.base.service.model.util.SkuStockConvert;
import com.pzj.base.service.product.IProductStockRelationService;
import com.pzj.core.stock.model.result.SkuStockRelationResult;

/**
 * service接口实现.区域
 * @author 票之家
 */
@Service
public class ProductStockRelationServiceImpl  extends BaseServiceImpl<ProductStockRelation,IProductStockRelationMapper> implements IProductStockRelationService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
	private ModelOperateUtil modelOperateUtil = ModelOperateUtil.getInstance();
	
	private SkuStockConvert skuStockConvert = SkuStockConvert.getInstance();
	
	@Override
	public List<Long> getValidProductIdsByStockId(Long stockId) {
		ProductStockRelation rel = new ProductStockRelation();
		rel.setStockRuleId(stockId);
		rel.setFlag(GlobalParam.FLAG.start());
		List<ProductStockRelation> list = findListByParams(rel);
		return modelOperateUtil.getProductIdForPSR(list);
	}
	
	public ArrayList<SkuStockRelationResult> getValidRelationByStockIds(List<Long> stockRuleIds) {
		ProductStockRelationQuery rel = new ProductStockRelationQuery();
		rel.setStockRuleIds(stockRuleIds);
		rel.setFlag(GlobalParam.FLAG.start());
		List<ProductStockRelation> list = findListByParams(rel);
		return skuStockConvert.convertTSSRelation(list);
	}

	@Override
	public List<Long> getValidStockIdsByProductId(Long productId) {
		ProductStockRelation rel = new ProductStockRelation();
		rel.setProductId(productId);
		rel.setFlag(GlobalParam.FLAG.start());
		List<ProductStockRelation> list = findListByParams(rel);
		return modelOperateUtil.getProductIdForPSR(list);
	}
	
	public List<SkuStockRelationResult> getValidRelationByProductIds(List<Long> productIds) {
		ProductStockRelationQuery rel = new ProductStockRelationQuery();
		rel.setProductIds(productIds);
		rel.setFlag(GlobalParam.FLAG.start());
		List<ProductStockRelation> list = findListByParams(rel);
		return skuStockConvert.convertTSSRelation(list);
	}
	
	
	/**
     * 新建产品与库存关系
     * @param list 产品集合
     */
    public void addSkuAndStockRelation(List<ProductRelease> list){
        if (list == null || list.isEmpty()) {
            logger.info("更新产品与景区关系接口[addSkuAndStockRelation]：传入参数没有产品信息");
            return;
        }
    
        List<ProductStockRelation> addRelation = new ArrayList<ProductStockRelation>();
        for (ProductRelease vo : list) {
        	if(vo.getUnlimitedInventory() != null && vo.getUnlimitedInventory()){
        		continue;
        	}
        	if(vo.getStockRuleId() == null){
        		continue;
        	}
        	ProductStockRelation add = new ProductStockRelation();
            add.setProductId(vo.getId());
            add.setProductInfoId(vo.getProductId());
            add.setStockRuleId(vo.getStockRuleId());
            add.setFlag(GlobalParam.FLAG.start());
            addRelation.add(add);
        }

        //添加
        insertBatch(addRelation);

    }
	
	 /**
     * 新建产品与库存关系
     * @param list 产品集合
     */
    public void addSkuAndStockRelation(ProductRelease pr){
        if (pr == null) {
            logger.info("更新产品与景区关系接口[addSkuAndStockRelation]：传入参数没有产品信息");
            return;
        }
        List<ProductRelease> list = new ArrayList<ProductRelease>();
        list.add(pr);
        addSkuAndStockRelation(list);
      

    }
 
}
