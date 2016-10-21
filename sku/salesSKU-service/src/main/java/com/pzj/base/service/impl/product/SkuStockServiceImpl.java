package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.exception.SkuServiceException;
import com.pzj.base.service.exception.SkuStockException;
import com.pzj.base.service.model.util.SkuStockConvert;
import com.pzj.base.service.product.IProductReleaseSearchService;
import com.pzj.base.service.product.IProductStockRelationService;
import com.pzj.core.stock.model.query.SkuParam;
import com.pzj.core.stock.model.query.StockListParam;
import com.pzj.core.stock.model.query.StockParam;
import com.pzj.core.stock.model.result.JudgeRelationResult;
import com.pzj.core.stock.model.result.SkuRondaRelationResult;
import com.pzj.core.stock.model.result.SkuStockListResult;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;
import com.pzj.core.stock.service.ISkuStockService;
import com.pzj.framework.context.Result;
import com.pzj.util.productConvertUtil.CommonConvert;

@Service
public class SkuStockServiceImpl implements ISkuStockService {
	protected  Logger logger = LoggerFactory.getLogger(SkuStockServiceImpl.class);
	
	@Autowired
	IProductReleaseSearchService productReleaseSearchService;
	
	@Autowired
	IProductStockRelationService productStockRelationService;
	

	SkuStockConvert skuStockConvert = SkuStockConvert.getInstance();


	@Override
	public Result<JudgeRelationResult> judgeValidSkuByStockRuleId(
			StockParam vo) {
		Result<JudgeRelationResult> result = new Result<JudgeRelationResult>();
		try {
	           
            if (vo == null) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuRelationByStockId]：传入参数为空");
            }

            if (vo.isIllegalParam()) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuRelationByStockId]：传入参数有误");
            }
            
            
            //查询可用的产品
            List<Long> stockIds = new ArrayList<Long>();
            stockIds.add(vo.getStockRuleId());           
            ArrayList<SkuStockListResult> list = findValidProductByStockRuleId(stockIds);           
            if(CollectionUtils.isNotEmpty(list)){
            	result.setData(new JudgeRelationResult(vo.getStockRuleId(), true));
            }else{
            	result.setData(new JudgeRelationResult(vo.getStockRuleId(), false));
            }
           
        } catch (SkuServiceException e) {  	
            logger.error(e.getMessage(), e);
            CommonConvert.combinationTResult(result, e);

        }catch(Exception e){
     	   logger.error(e.getMessage(),e);
     	   SkuStockException ex = new SkuStockException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuRelationByStockId]报错",e);
     	   CommonConvert.combinationTResult(result, ex);
        }finally{
        	return result;
        }
	}
	
	public Result<ArrayList<JudgeRelationResult>> judgeValidSkuByStockRuleIds(
			StockListParam vo) {
		Result<ArrayList<JudgeRelationResult>> result = new Result<ArrayList<JudgeRelationResult>>();
		try {
	           
            if (vo == null) {
                throw new SkuParamNullException("根据库存规则id集合判断是否有有效的产品与其绑定[findStockSkuRelationByStockIds]：传入参数为空");
            }

            if (vo.isIllegalParam()) {
                throw new SkuParamNullException("根据库存规则id集合判断是否有有效的产品与其绑定[findStockSkuRelationByStockIds]：传入库存id集合为空");
            }
            
            //查询可用的产品          
            ArrayList<SkuStockListResult> list = findValidProductByStockRuleId(vo.getStockIdList()); 
            ArrayList<JudgeRelationResult> judgeList = skuStockConvert.combinationTJudgeListResult(vo.getStockIdList(), list);
            result.setData(judgeList);
        } catch (SkuServiceException e) {  	
            logger.error(e.getMessage(), e);
            CommonConvert.combinationTResult(result, e);

        }catch(Exception e){
     	   logger.error(e.getMessage(),e);
     	  SkuServiceException ex = new SkuStockException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuRelationByStockId]报错",e);
     	  CommonConvert.combinationTResult(result, ex);
        }finally{
        	return result;
        }
	}

	@Override
	public Result<ArrayList<SkuStockResult>> findStockSkuByStockRuleId(StockParam vo) {
		Result<ArrayList<SkuStockResult>> result = new Result<ArrayList<SkuStockResult>>();
		try {
	           
            if (vo == null) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuRelationByStockId]：传入参数为空");
            }

            if (vo.isIllegalParam()) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuRelationByStockId]：传入参数有误");
            }
            
            //查询可用的产品
            List<Long> stockIds = new ArrayList<Long>();
            stockIds.add(vo.getStockRuleId());           
            ArrayList<SkuStockListResult> list = findValidProductByStockRuleId(stockIds);
            if(!CollectionUtils.isEmpty(list)){
            	SkuStockListResult ssList = list.get(0);
            	result.setData(ssList.getSkuList());
            }
           
        } catch (SkuServiceException ex) {  	
            logger.error(ex.getMessage(), ex);
            CommonConvert.combinationTResult(result, ex);
            throw ex;

        }catch(Exception e){
     	   logger.error(e.getMessage(),e);
     	  SkuServiceException ex = new SkuStockException("根据库存规则获取有效的产品[findStockSkuByStockId]报错",e);
     	  CommonConvert.combinationTResult(result, ex);
     	   throw ex;
        }finally{
        	return result;
        }
	}

	@Override
	public Result<SkuRondaRelationResult> findSkuRondaRelationBySkuId(
			SkuParam vo) {
		Result<SkuRondaRelationResult> result = new Result<SkuRondaRelationResult>();
		try {
	           
            if (vo == null) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findSkuRondaRelationByProductId]：传入参数为空");
            }
            
            //查询可用的产品
            Long productId = vo.getProductId();
            ProductRelease pr = productReleaseSearchService.findById(productId);
            
            if(pr == null){
            	throw new SkuStockException("根据产品id:"+productId+"查不到产品数据");
            }
            
            result.setData(new SkuRondaRelationResult(pr.getTheaterId()));
            
        } catch (SkuServiceException ex) {  	
            logger.error(ex.getMessage(), ex);
            CommonConvert.combinationTResult(result, ex);
            throw ex;

        }catch(Exception e){
     	   logger.error(e.getMessage(),e);
     	    SkuServiceException ex = new SkuStockException("根据库存规则批量获取有效的产品[findStockSkuByStockIds]报错",e);
     	   CommonConvert.combinationTResult(result, ex);
     	   throw ex;
        }finally{
        	return result;
        }
	}

	@Override
	public Result<ArrayList<SkuStockListResult>> findStockSkuByStockRuleIds(
			StockListParam vo) {
		Result<ArrayList<SkuStockListResult>> result = new Result<ArrayList<SkuStockListResult>>();
		try {
	           
            if (vo == null) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuByStockIds]：传入参数为空");
            }

            if (vo.isIllegalParam()) {
                throw new SkuParamNullException("根据库存规则id判断是否有有效的产品与其绑定[findStockSkuByStockIds]：传入参数有误");
            }
            
            //查询可用的产品
            List<Long> stockIds = vo.getStockIdList();         
            ArrayList<SkuStockListResult> list = findValidProductByStockRuleId(stockIds);
            result.setData(list);
            
        } catch (SkuServiceException ex) {  	
            logger.error(ex.getMessage(), ex);
            CommonConvert.combinationTResult(result, ex);
            throw ex;

        }catch(Exception e){
     	   logger.error(e.getMessage(),e);
     	   SkuServiceException ex = new SkuStockException("根据库存规则批量获取有效的产品[findStockSkuByStockIds]报错",e);
     	   CommonConvert.combinationTResult(result, ex);
     	   throw ex;
        }finally{
        	return result;
        }
	}

	@Override
	public Result<ArrayList<SkuStockRelationResult>> getAllValidSkuRondaRelation() {
		Result<ArrayList<SkuStockRelationResult>> result = new Result<ArrayList<SkuStockRelationResult>>();
		try {
            //查询可用的产品
            ArrayList<SkuStockRelationResult> relations = productStockRelationService.getValidRelationByStockIds(null);  
            result.setData(relations);
            
        } catch (SkuServiceException ex) {  	
            logger.error(ex.getMessage(), ex);
            CommonConvert.combinationTResult(result, ex);
            throw ex;

        }catch(Exception e){
     	   logger.error(e.getMessage(),e);
     	  SkuServiceException ex = new SkuStockException("获取有效的产品与库存规则关系[getAllValidSkuRondaRelation]报错",e);
     	   CommonConvert.combinationTResult(result, ex);
     	   throw ex;
        }finally{
        	return result;
        }
	}
	
	/**
	 * 根据库存id获取对应的有效产品
	 * @param stockIds 库存id集合
	 * 
	 * @return key=库存id,value=产品集合
	 */
	private ArrayList<SkuStockListResult> findValidProductByStockRuleId(List<Long> stockIds) {
		  ArrayList<SkuStockListResult> result = new ArrayList<SkuStockListResult>();
              
		 if (CollectionUtils.isEmpty(stockIds)) {
             throw new SkuParamNullException("根据库存id获取对应的有效产品[findValidProductByStockId]：入参为空");
         }

		//1.获取库存和产品关系
    	List<SkuStockRelationResult> relations = productStockRelationService.getValidRelationByStockIds(stockIds);  	
    	if(CollectionUtils.isEmpty(relations)){
    		return result;
    	}

    	//2.查询有效的产品集合
    	List<SkuStockResult> ssList = productReleaseSearchService.findValidSkuByRelations(relations);
     	if(CollectionUtils.isEmpty(relations)){
    		return result;
    	}
    	
    	
			
    	return skuStockConvert.combinationTSSListResult(relations, ssList);
		}

}
