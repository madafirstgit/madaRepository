package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysUser;

;

public interface IChannelService extends IBaseUserService<SysChannel> {

    /**
     * 添加渠道及渠道标签关系信息
     * 
     * @param channel
     *            渠道实体
     * 
     * @param channelLabelList
     *            渠道标签实体列表
     * 
     * @return 渠道主键Id
     */
    public Long addChannelAndAuth(SysChannel channel,
            List<SysLabel> channelLabelList);

    /**
     * 编辑保存渠道及渠道标签关系信息
     * 
     * @param vo
     *            渠道实体
     * 
     * @param records
     *            渠道标签实体列表
     * 
     * @return 更新条数
     * 
     */
    public Long saveChannelAndChannelLabel(SysChannel vo,
            List<SysLabel> records, boolean isNeedUpdate);

    /**
     * 编辑保存渠道及渠道分销商关系信息
     * 
     * @param vo
     *            渠道实体
     * 
     * @param records
     *            分销商实体列表
     * 
     * @return 更新条数
     * 
     */
    public Integer saveChannelAndUser(SysChannel vo, List<SysUser> records,
            boolean isNeedUpdate);

    /**
     * 通过关系表中的objId获取标签分页集合
     * 
     */
    public PageList<SysChannel> queryPageByObjId(PageModel pager,
            SysChannel record, Long objId, String refType);

    /**
     * 通过关系表中的refId获取标签分页集合
     * 
     */
    public PageList<SysChannel> queryPageByRefId(PageModel pager,
            SysChannel record, Long refId, String refType);

    /**
     * 定制查询 根据渠道信息和产品Id分页获取与产品Id未关联的渠道列表
     * 
     */
    public PageList<SysChannel> queryPageNotByProductId(PageModel pager,
            SysChannel record, Long productId);
    
    /**
     * 通过供应商ID查询其所有的渠道信息
     */
    public PageList<SysChannel> queryPageBySupplierId(PageModel pager,Long supplierId);
    
    /**
     * 通用渠道参数和分销商id查询渠道列表
     * 
     */
    public List<SysChannel> queryPageByUserId(PageModel pager, SysChannel param,Long userId);
    
    
    /**
     * 通过政策id集合获取有效渠道集合
     */
    public List<SysChannel>  findValidChannelsByIds(List<Long> channelIds);
    
    
}
