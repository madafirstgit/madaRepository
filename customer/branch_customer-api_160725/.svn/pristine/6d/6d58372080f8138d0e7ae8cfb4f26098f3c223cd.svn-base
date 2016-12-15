package com.pzj.channel.service;

import java.util.List;

import com.pzj.base.common.BaseApiService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.channel.entity.ChannelVo;

public interface ChannelService extends BaseApiService<ChannelVo> {
    /**
     * 批量创建渠道
     */
    public Long createBatch(List<ChannelVo> voList) throws Exception;

    /**
     * 获取渠道下的标签
     */
    public ChannelVo getChannelLabelList(Long id) throws Exception;

    /**
     * 获取渠道下的分销商
     * 
     */
    public ChannelVo getChannelCustomerList(Long id) throws Exception;

    /**
     * 获取渠道下的政策
     */
    public ChannelVo getChannelStrategyList(Long id) throws Exception;

    /**
     * 获取渠道下的产品主键集合
     */
    public ChannelVo getChannelProductIdList(Long id) throws Exception;

    /**
     * 根据产品Id获取没有跟这个产品关联的渠道集合
     */
    public PageList<ChannelVo> queryPageNotByProductId(PageModel pager,
            ChannelVo vo, Long productId) throws Exception;

    /**
     * 根据政策Id和渠道参数分页查询渠道集合列表
     */
    public PageList<ChannelVo> queryPageByStrategyId(PageModel pager,
            ChannelVo vo, Long strategyId) throws Exception;

    /**
     * 根据分销商Id和渠道参数分页查询渠道集合列表
     */
    public PageList<ChannelVo> queryPageByCustomerId(PageModel pager,
            ChannelVo vo, Long customerId) throws Exception;

    /**
     * 批量修改渠道状态
     */
    public Integer updateBatchChannelPrimaryKey(List<Long> ids, String flag);

    /**
     * 更新渠道标签
     * 
     * @param vo
     *            渠道实体
     * @return 更新条数
     * @throws Exception
     * 
     */
    public Integer saveChannelLabel(ChannelVo vo) throws Exception;

    /**
     * 更新渠道分销商
     * 
     * @param vo
     *            渠道实体
     * @return 更新条数
     * @throws Exception
     * 
     */
    public Integer saveChannelCustomer(ChannelVo vo) throws Exception;
    /**
     * 根据供应商ID获取该供应商创建的所有渠道
     */
    public PageList<ChannelVo> queryPageBySupplierId(PageModel pager, Long supplierId) throws Exception;

}
