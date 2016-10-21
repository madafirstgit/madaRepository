package com.pzj.regulation.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseApiService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.common.DateQueryVo;
import com.pzj.regulation.entity.RebatePlus;
import com.pzj.regulation.entity.StrategyVo;

/**
 * 渠道政策接口
 * 
 * @author apple
 * 
 */
public interface StrategyService extends BaseApiService<StrategyVo> {

    /**
     * 批量修改政策
     * 
     * @param records
     *            政策实体列表
     * 
     * @throws Exception
     */
    public Integer updateBatch(List<StrategyVo> records) throws Exception;

    /**
     * 批量改变政策状态
     * 
     * @param ids
     *            政策id集合
     * @param status
     *            状态
     */
    @Deprecated
    public Integer updateBatchStrategyPrimaryKey(List<Long> ids, Integer status);

    /**
     * 给政策封装对应返利列表
     * 
     * @param records
     *            政策实体列表
     * 
     */
    @Deprecated
    public List<StrategyVo> getStrategyRebateList(List<StrategyVo> records) throws Exception;

    /**
     * 给政策封装对应渠道列表
     * 
     * @param records
     *            政策实体列表
     * 
     */
    @Deprecated
    public List<StrategyVo> getStrategyChannelList(List<StrategyVo> records) throws Exception;

    /**
     * 给政策封装对应的产品主键Id列表
     * 
     * @param records
     *            政策实体列表
     */
    @Deprecated
    public List<StrategyVo> getStrategyProductList(List<StrategyVo> records) throws Exception;

    /**
     * 给政策封装对应渠道，返利，产品主键Id列表
     * 
     * @param records
     * @return
     * @throws Exception
     */
    @Deprecated
    public List<StrategyVo> getStrategyAuthlList(List<StrategyVo> records) throws Exception;

    /**
     * 获取政策及对应渠道，返利，产品列表
     * 
     * @param pager
     * @return
     * @throws Exception
     */
    @Deprecated
    public PageList<StrategyVo> queryPageAuthByParamMap(PageModel pager, StrategyVo vo) throws Exception;

    /**
     * 分页查询+时间段查询政策信息
     * 
     * @param pager
     * @return
     * @throws Exception
     */
    @Deprecated
    public PageList<StrategyVo> queryPageAuthByParamMap(PageModel pager, StrategyVo vo, List<DateQueryVo> queryDateList,
                                                        List<Long> productIds) throws Exception;

    /**
     * 根据渠道Id和政策参数分页查询政策集合列表
     */
    @Deprecated
    public PageList<StrategyVo> queryPageByChannelId(PageModel pager, StrategyVo vo, Long channelId) throws Exception;

    /**
     * 根据渠道Id和政策参数分页查询政策集合及政策的所有关系实体列表
     */
    @Deprecated
    public PageList<StrategyVo> queryPageAuthByChannelId(PageModel pager, StrategyVo vo, Long channelId) throws Exception;

    /**
     * 根据渠道Id和产品Id查询政策集合列表
     */
    @Deprecated
    public List<StrategyVo> queryByProductIdAndChannelId(Long productId, Long channelId) throws Exception;

    /**
     * 根据渠道Id和产品Id查询政策集合列表及政策的所有关系实体列表
     */
    @Deprecated
    public List<StrategyVo> queryAuthByProductIdAndChannelId(Long productId, Long channelId) throws Exception;

    /**
     * 根据Id集合获取政策集合
     * 
     * @param ids
     *            政策ID集合
     */
    @Deprecated
    public List<StrategyVo> getByIdList(List<Long> ids) throws Exception;

    /**
     * 根据Id集合获取政策集合
     * 
     * @param ids
     *            政策ID集合
     */
    @Deprecated
    public List<StrategyVo> getAuthByIdList(List<Long> ids) throws Exception;

    /**
     * 根据渠道Id获取加点返产品政策
     * 
     * @param channels
     * @return
     * @throws Exception
     */
    @Deprecated
    public List<StrategyVo> getSpcreStrategyByChannel(List<ChannelVo> channels) throws Exception;

    /**
     * 根据产品Id获取加点返产品政策
     * 
     * @param productIds
     *            产品id集合
     * @return
     * @throws Exception
     */
    @Deprecated
    public List<StrategyVo> getSpcreStrategyByProductId(List<Long> productIds) throws Exception;

    /**
     * 根据加点返关系信息查询政策组合的加点返产品信息
     * 
     * @param voList
     * @return
     * @throws Exception
     */
    @Deprecated
    public List<StrategyVo> getSpcreStrategyByRebatePlus(List<RebatePlus> voList) throws Exception;

    /**
     * 获取用户在某个景区下的分销直连政策
     * 
     * @param scenicId
     *            景区Id
     * @param customerId
     *            用户Id
     * @param supplierId
     *            原始景区的供应商Id
     * @param salesType
     *            销售端口
     * @param ticketVarie
     *            团散标识
     * 
     * @return
     */
    @Deprecated
    public List<StrategyVo> findCustomerDirectStrategyVoByScenic(Long scenicId, Long customerId, Long supplierId, String salesType,
                                                                 String ticketVarie) throws Exception;

    /**
     * 获取用户在某个景区下的分销政策
     * 
     * @param scenicId
     *            景区Id
     * @param customerId
     *            用户Id
     * @param supplierId
     *            原始景区的供应商Id
     * @param salesType
     *            销售端口
     * @param ticketVarie
     *            团散标识
     * @return
     */
    @Deprecated
    public List<StrategyVo> findCustomerDistributionStrategyVoByScenic(Long scenicId, Long customerId, Long supplierId, String salesType,
                                                                       String ticketVarie) throws Exception;

    /**
     * 获取用户在不同产品下的分销直连政策
     * 
     * @param customerId
     * @param pidAndSids
     *            其中供应商Id:产品的供应商Id
     * @param salesType
     *            销售端口
     * @param ticketVarie
     *            团散标识
     * @return key:分销商Id+","+产品Id
     */
    @Deprecated
    public Map<String, List<StrategyVo>> findCustomerDirectStrategyVoByProductIds(Long customerId, Map<Long, Long> pidAndSids, String salesType,
                                                                                  String ticketVarie) throws Exception;

    /**
     * 获取用户在不同产品下的分销政策
     * 
     * @param customerId
     * @param pidAndSids
     *            其中供应商Id:产品的供应商Id
     * @param salesType
     *            销售端口
     * @param ticketVarie
     *            团散标识
     * @return key:分销商Id+","+产品Id
     */
    @Deprecated
    public Map<String, List<StrategyVo>> findCustomerDistributionStrategyVoByProductIds(Long customerId, Map<Long, Long> pidAndSids, String salesType,
                                                                                        String ticketVarie) throws Exception;

    /**
     * 判断分销商是否在某个供应商下有分销直联的产品
     * 
     * @param customerId
     *            分销商Id
     * @param supplierId
     *            供应商Id
     * @return
     * @throws Exception
     */
    @Deprecated
    public Integer isHaveDirectProductBySupplier(Long customerId, Long supplierId, String salesType, String ticketVarie) throws Exception;

    /**
     * 批量创建政策，创建政策关联的返利，加点返及维护政策与渠道和产品的关系,创建政策关联的结算规则
     * 
     * @param beans
     *            政策实体集合
     * @return 新建条数
     * @throws Exception
     */
    public Integer createBatchAndAuth(List<StrategyVo> beans) throws Exception;

    /**
     * 批量创建政策，创建政策关联的返利，加点返及维护政策与渠道和产品的关系,创建政策关联的结算规则
     * 同时创建微点政策
     * 
     * @param beans
     *            政策实体集合
     * @return 新建条数
     * @throws Exception
     */
    public Integer createBatchAndAuthWithMicroshop(List<StrategyVo> beans) throws Exception;

    /**
     * 批量更新政策，更新政策关联的返利，加点返及更新政策与渠道和产品的关系，创建政策关联的结算规则
     * 
     * @param beans
     * @return
     * @throws Exception
     */
    public Integer updateBatchAndAuth(List<StrategyVo> beans) throws Exception;

    /**
     * 查询政策列表
     * 
     * @param vo
     * @return
     */
    public List<StrategyVo> queryListByAllParamMap(StrategyVo vo) throws Exception;

    /**
     * 分页查询政策
     * 
     * @param vo
     * @return
     */
    public PageList<StrategyVo> queryPageByAllParamMap(PageModel page, StrategyVo vo) throws Exception;

    /**
     * 查询政策及政策关联的实体
     * 
     * @param vo
     * @return
     */
    public List<StrategyVo> queryListAuthByAllParamMap(StrategyVo vo) throws Exception;

    /**
     * 分页查询政策及政策关联的实体
     * 
     * @param vo
     * @return
     */
    public PageList<StrategyVo> queryPageAuthByAllParamMap(PageModel page, StrategyVo vo) throws Exception;

    /**
     * 判断政策是否与库里存在的数据有效期冲突
     * 
     * @param vo
     * @param startDate
     * @param endDate
     * @return 没有冲突返回true，有冲突返回false
     */
    public List<StrategyVo> isHaveStrategyByDate(StrategyVo vo, Date startDate, Date endDate) throws Exception;

    /**
     * 判断政策是否与库里存在的数据有效期冲突
     *
     * @param scenicId
     * @param ticketVarie
     * @return
     * @throws Exception
     */
    public List<StrategyVo> findStrategyByScenic(Long scenicId, String ticketVarie) throws Exception;

    /**
     * 根据景区和分销商获取政策及政策关联的产品
     * 
     * @param customerId
     *            分销商Id
     * @param scenicId
     *            景区Id
     * @param supplierId
     *            供应商Id
     * @param ticketVarie
     *            团散标识
     * @return
     */
    public List<StrategyVo> findStrategyByScenic(Long customerId, Long scenicId, Long supplierId, String ticketVarie) throws Exception;

    /**
     * 根据产品和渠道获取政策及政策关联的渠道，产品，返利，加点返利
     * 
     * @param pidAndCid
     *            key:产品Id，value:产品供应商Id+","+渠道Id
     * @param customerId
     *            分销商Id
     * @param ticketVarie
     *            团散标识
     * @return key:分销商Id+","+产品，value:产品和分销商对应的政策
     */
    public Map<String, List<StrategyVo>> findStrategyByProductIds(Map<Long, String> pidAndCid, Long customerId, String ticketVarie) throws Exception;

    /**
     * 根据联票主产品id集合和分销商id获取政策及政策关联的渠道，产品，返利，加点返利
     * 
     * @param productIds
     *            产品主键集合
     * @param customerId
     *            分销商Id
     * @param ticketVarie
     *            团散标识
     * @return key:主产品Id，value:产品对应的所有政策
     */
    public Map<String, List<StrategyVo>> findComposeStrategyByProductIds(List<Long> productIds, Long customerId, String ticketVarie) throws Exception;

    /**
     * 根据景区和分销商获取政策及政策关联的产品
     * 
     * @param customerId
     *            分销商Id
     * @param scenicId
     *            景区Id
     * @param ticketVarie
     *            团散标识
     * @return
     */
    public List<StrategyVo> findComposeStrategyByScenic(Long customerId, Long scenicId, String ticketVarie) throws Exception;

    /**
     * 编辑渠道政策
     */
    public Integer updateForPlatform(StrategyVo vo) throws Exception;

    /**
     * 批量更新政策，更新政策关联的返利，加点返及更新政策与渠道和产品的关系，创建政策关联的结算规则
     * 
     * @param beans
     * @return
     * @throws Exception
     */
    public Integer updateBatchAndAuthForPlatform(List<StrategyVo> beans) throws Exception;
}
