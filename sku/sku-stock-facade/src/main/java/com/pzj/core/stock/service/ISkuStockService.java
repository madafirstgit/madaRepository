package com.pzj.core.stock.service;

import java.util.ArrayList;

import com.pzj.core.stock.model.query.SkuParam;
import com.pzj.core.stock.model.query.StockListParam;
import com.pzj.core.stock.model.query.StockParam;
import com.pzj.core.stock.model.result.JudgeRelationResult;
import com.pzj.core.stock.model.result.SkuRondaRelationResult;
import com.pzj.core.stock.model.result.SkuStockListResult;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;
import com.pzj.framework.context.Result;




public interface ISkuStockService {
	
	 
    /**
     * 根据库存规则id判断是否有有效的产品与其绑定
     * @param vo 查询参数
     * @return
     */
    Result<JudgeRelationResult> judgeValidSkuByStockRuleId(StockParam vo);
    
    
    /**
     * 根据库存规则id集合判断是否有有效的产品与其绑定
     * @param vo 查询参数
     * @return
     */
    Result<ArrayList<JudgeRelationResult>> judgeValidSkuByStockRuleIds(StockListParam vo);
    
    
    
    /**
     * 根据库存规则id获取有效的产品集合
     * @param vo 查询参数
     * @return
     */
    Result<ArrayList<SkuStockResult>> findStockSkuByStockRuleId(StockParam vo);
    
    
    /**
     * 根据库存规则id集合获取有效的产品集合
     * @param vo 查询参数
     * @return
     */
    Result<ArrayList<SkuStockListResult>> findStockSkuByStockRuleIds(StockListParam vo);
    
    
    
    /**
     * 根据产品id获取产品对应的场次区域信息
     * @param vo
     * @return
     */
    Result<SkuRondaRelationResult> findSkuRondaRelationBySkuId(SkuParam vo);
    
    
    
    /**
     * 获取所有的产品库存有效关系
     * @return 
     */
    Result<ArrayList<SkuStockRelationResult>> getAllValidSkuRondaRelation();
    
    
    
    
    
    

}
