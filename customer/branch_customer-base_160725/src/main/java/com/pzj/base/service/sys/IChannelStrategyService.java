package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.base.entity.query.SysDateQuery;

public interface IChannelStrategyService extends IBaseUserService<SysChannelStrategy> {

    /**
     * 添加政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param bean
     *            政策实体
     * 
     * @param productIds
     *            产品主键列表
     * 
     * @param csList
     *            渠道实体列表
     * 
     * @param rslist
     *            返利实体列表
     * 
     * @return 政策主键Id
     * @throws Exception
     */
    @Deprecated
    Long addStrategyAndAuth(SysChannelStrategy bean, List<Long> productIds, List<SysChannel> csList, List<SysRebateStrategy> rslist) throws Exception;

    /**
     * 更新政策 更新政策与渠道关系信息，更新政策返利信息,更新政策与产品关系信息
     * 
     * @param bean
     *            政策实体
     * 
     * @param productIds
     *            产品主键列表
     * 
     * @param csList
     *            渠道实体列表
     * 
     * @param rslist
     *            返利实体列表
     * 
     * @return 政策主键Id
     * @throws Exception
     */
    @Deprecated
    Long updateStrategyAndAuth(SysChannelStrategy bean, List<Long> productIds, List<SysChannel> csList, List<SysRebateStrategy> rslist) throws Exception;

    /**
     * 更新政策产品关系列表
     * 
     * @param bean
     *            政策实体
     * 
     * @param records
     *            产品主键列表
     * 
     * @param isNeedUpdate
     *            是否更新实体信息
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    Long saveStrategyProduct(SysChannelStrategy bean, List<Long> records, boolean isNeedUpdate) throws Exception;

    /**
     * 更新政策渠道关系列表
     * 
     * @param bean
     *            政策实体
     * 
     * @param records
     *            渠道实体列表
     * 
     * @param isNeedUpdate
     *            是否更新实体信息
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    Long saveStrategyChannel(SysChannelStrategy bean, List<SysChannel> records, boolean isNeedUpdate) throws Exception;

    /**
     * 更新政策返利关系列表
     * 
     * @param bean
     *            政策实体
     * 
     * @param records
     *            返利实体列表
     * 
     * @param isNeedUpdate
     *            是否更新实体信息
     * 
     * @return 更新条数
     * @throws Exception
     * 
     */
    Long saveStrategyRebate(SysChannelStrategy bean, List<SysRebateStrategy> records, boolean isNeedUpdate) throws Exception;

    /**
     * 通过关系表中的objId获取政策分页集合
     * 
     */
    PageList<SysChannelStrategy> queryPageByObjId(PageModel pager, SysChannelStrategy vo, Long objId, String refType);

    /**
     * 通过关系表中的refId获取政策分页集合
     * 
     */
    PageList<SysChannelStrategy> queryPageByRefId(PageModel pager, SysChannelStrategy vo, Long refId, String refType);

    /**
     * 通过政策参数和产品Id查询政策分页集合
     */
    PageList<SysChannelStrategy> queryPageByAuthParamMap(PageModel pager, SysChannelStrategy vo, List<SysDateQuery> dateList, List<Long> productIds);

    /**
     * 通过产品Id和渠道Id和政策参数查询政策分页集合
     * 
     */
    List<SysChannelStrategy> queryPageByPIDAndCID(Long productId, Long channelId);

    /**
     * 获取某个景区下的政策
     * 
     * @param pager
     *            分页对象
     * @param scenicId
     *            景区Id
     * @param salesType
     *            销售端口
     * @param ticketVarie
     *            团散标识
     * @return
     */
    PageList<SysChannelStrategy> queryDirectStrategyVoByScenic(PageModel pager, Long scenicId, String salesType, String ticketVarie);

    /**
     * 获取多个产品的直销政策
     * 
     * @param productId
     *            产品id
     * @param salesType
     *            销售端口
     * @param ticketVarie
     *            团散标识
     * @return
     */
    List<SysChannelStrategy> queryDirectStrategyVoByProductIds(Long productId, String salesType, String ticketVarie);

    /**
     * 获取用户在某个景区下的分销直连政策
     * 
     * @param scenicId
     *            景区Id
     * @param customerId
     *            用户Id
     * @param supplierId
     *            供应商Id
     * @return
     */
    PageList<SysChannelStrategy> queryCustomerDirectStrategyVoByScenic(PageModel pager, Long scenicId, Long customerId, Long supplierId, String salesType,
                                                                       String ticketVarie);

    /**
     * 获取用户在某个景区下的分销政策
     * 
     * @param scenicId
     *            景区Id
     * @param customerId
     *            用户Id
     * @param supplierId
     *            供应商Id
     * @return
     */
    PageList<SysChannelStrategy> queryCustomerDistributionStrategyVoByScenic(PageModel pager, Long scenicId, Long customerId, Long supplierId, String salesType,
                                                                             String ticketVarie);

    /**
     * 获取用户在不同产品下的分销直连政策
     * 
     * @param userId
     *            分销商id
     * @param productId
     *            产品Id
     * @param supplierId
     *            供应商Id
     * 
     * @param salesType
     *            销售端口
     * 
     * @param ticketVarie
     *            团散类型
     * @return
     */
    List<SysChannelStrategy> queryCustomerDirectStrategyVoByProductIds(Long userId, Long productId, Long supplierId, String salesType, String ticketVarie);

    /**
     * 获取用户在不同产品下的分销政策
     * 
     * @param userId
     *            分销商id
     * @param productId
     *            产品Id
     * @param supplierId
     *            供应商Id
     * 
     * @param salesType
     *            销售端口
     * 
     * @param ticketVarie
     *            团散类型
     * @return
     */
    List<SysChannelStrategy> queryCustomerDistributionStrategyVoByProductIds(Long userId, Long productId, Long supplierId, String salesType,
                                                                             String ticketVarie);

    /**
     * 按照所有政策关联的参数查询政策集合
     * 
     * @param pager
     * @param vo
     * @return
     */
    PageList<SysChannelStrategy> queryByAllParam(PageModel pager, SysChannelStrategy vo);

    /**
     * 批量添加政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 如果isNeedMicroshop为true，创建微店政策
     * @param strategyList
     * @param isNeedMicroshop 是否创建微店政策
     * @return
     * @throws Exception
     */
    Integer addBatchAndAuth(List<SysChannelStrategy> strategyList, Boolean isNeedMicroshop) throws Exception;

    /**
     * 批量更新政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param strategyList
     *            政策集合
     * @return 操作成功的数量
     * @throws Exception
     */
    Integer updateBatchAndAuth(List<SysChannelStrategy> strategyList) throws Exception;

    /**
     * 批量更新政策 添加政策与渠道关系信息，添加政策返利信息,添加政策与产品关系信息
     * 
     * @param strategyList
     *            政策集合
     * @return 操作成功的数量
     * @throws Exception
     */
    Integer updateBatchAndAuthForPlatform(List<SysChannelStrategy> strategyList) throws Exception;

    /**
     * 获取某个景区关联的联合政策（直签）
     * 
     * @param pager
     *            分页对象
     * @param scenicId
     *            景区Id
     * @param userId
     *            分销商Id
     * 
     * @param ticketVarie
     *            团散标识
     * @return
     */
    PageList<SysChannelStrategy> queryComposeDirectStrategyVoByScenic(PageModel pager, Long scenicId, String ticketVarie);

    /**
     * 获取某个景区关联的联合政策（分销）
     * 
     * @param pager
     *            分页对象
     * @param scenicId
     *            景区Id
     * @param userId
     *            分销商Id
     * 
     * @param ticketVarie
     *            团散标识
     * @return
     */
    PageList<SysChannelStrategy> queryComposeDistributionStrategyVoByScenic(PageModel pager, Long scenicId, Long userId, String ticketVarie);

    /**
     * 根据DictVlaue更新政策信息
     * @param bean政策实体
     * @return 政策主键Id
     * @throws Exception
     */
    public int updateStrategyByDictVlaue(SysChannelStrategy bean);

    /**
     * 更新政策 更新政策与渠道关系信息，更新政策返利信息,更新政策与产品关系信息
     * 
     * @param bean
     *            政策实体
     * 
     * @param productIds
     *            产品主键列表
     * 
     * @param csList
     *            渠道实体列表
     * 
     * @param rslist
     *            返利实体列表
     * 
     * @return 政策主键Id
     * @throws Exception
     */
    Long updateStrategyAndAuthForPlatform(SysChannelStrategy bean, List<Long> productIds, List<SysChannel> csList,
                                          List<SysRebateStrategy> rslist) throws Exception;

}
