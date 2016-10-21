package com.pzj.channel.service;

import java.util.ArrayList;
import java.util.List;

import com.pzj.channel.Strategy;
import com.pzj.channel.vo.queryParam.PCSstrategyParam;
import com.pzj.channel.vo.queryParam.StrategyJudgeParam;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.channel.vo.resultParam.StrategyJudgeResult;
import com.pzj.framework.context.Result;

public interface IStrategyService {
    /**
     * 根据产品id查询产品对应的有效渠道，有效政策，有效减免规则
     * 
     * @param param
     * @return
     */
    public List<PCStrategyResult> queryValidStrategyByProductIds(List<PCSstrategyParam> param);



    /**
     * 根据政策ID获取政策集合，同时获取每个政策的返利信息。
     *
     * @param ids 政策ID集合
     * @return
     */
    List<Strategy> queryStrategyAndRebateByIds(List<Long> ids);


   /**
    * 判断政策数据绑定的渠道对应的分销商是否已经有了对这个产品的直签/分销政策
    * 
    * @judgeParam 判断参数
    * 
    * 
    */
   public Result<ArrayList<StrategyJudgeResult>> judgeHaveValidStrategyByCPid(List<StrategyJudgeParam> judgeParam);
    
    
    
     
    

}
