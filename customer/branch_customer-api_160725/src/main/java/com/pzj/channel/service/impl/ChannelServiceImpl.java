package com.pzj.channel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IChannelService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.channel.service.ChannelService;
import com.pzj.customer.entity.Customer;
import com.pzj.label.entity.LabelVo;

import jline.internal.Log;

/**
 * 渠道api实现
 * 
 * @author apple
 * 
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    // 创建日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IChannelService ichannelService;

    @Autowired
    private ChannelVoUtil channelVoUtil;

    /**
     * 创建渠道，未完成渠道类型定义，全局里配置
     * 
     * @throws Exception
     */
    @Override
	public Long create(ChannelVo vo) throws Exception {
        Long num = 0l;
        try {
            if (vo == null) {
                logger.error("接口方法[ChannelService.create],参数vo不能为空");
                return num;
            }

            // 转换实体
            SysChannel channel = ChannelVo.changeTSysBean(vo);

            num = ichannelService.insert(channel);// 需要实现该服务接口：

            vo.setId(channel.getId());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 批量创建渠道
     * 
     * @throws Exception
     */
    @Override
	public Long createBatch(List<ChannelVo> voList) throws Exception {
        Long num = 0l;
        try {
            if (voList == null || voList.isEmpty()) {
                logger.error("接口方法[ChannelService.createBatch],参数voList不能为空");
                return num;
            }

            // 转换实体
            List<SysChannel> sysList = ChannelVo.cList2SList(voList);

            num = ichannelService.insertBatch(sysList);

            voList = ChannelVo.sList2CList(sysList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 编辑
     * 
     * @throws Exception
     */
    @Override
	public Integer update(ChannelVo vo) throws Exception {
        int num = 0;
        try {
            if (vo == null) {
                logger.error("接口方法[ChannelService.save],参数vo不能为空");
                return num;
            }
            Long id = vo.getId();
            if (id == null || id < 1) {
                logger.error("接口方法[ChannelService.save],参数vo的id不能为空");
                return num;
            }
            SysChannel channel = ChannelVo.changeTSysBean(vo);
            num = ichannelService.updateByPrimaryKey(channel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;

        }
        return num;
    }

    /**
     * 更新渠道分销商
     * 
     * @param vo
     *            渠道实体
     * @return 更新条数
     * @throws Exception
     * 
     */
    @Override
	public Integer saveChannelCustomer(ChannelVo vo) throws Exception {

        try {
            Integer num = 0;
            if (vo == null) {
                logger.error("接口方法[ChannelService.saveChannelCustomer],参数vo不能为空");
                return num;
            }
            if (vo.getId() == null || vo.getId() < 1) {
                logger.error("接口方法[ChannelService.saveChannelCustomer],参数vo的不能为空");
                return num;
            }
            SysChannel channel = ChannelVo.changeTSysBean(vo);

            List<Customer> customerList = vo.getClist();
            List<SysUser> userList = null;
            if (customerList != null && !customerList.isEmpty()) {
                userList = Customer.cList2SList(customerList);
            }
            num = ichannelService.saveChannelAndUser(channel, userList, false);

            return Integer.valueOf(num.toString());
        } catch (Exception e) {
            Log.error(e.toString());
            throw e;
        }
    }

    /**
     * 更新渠道标签
     * 
     * @param vo
     *            渠道实体
     * @return 更新条数
     * @throws Exception
     * 
     */
    @Override
	public Integer saveChannelLabel(ChannelVo vo) throws Exception {

        try {
            Integer num = 0;
            if (vo == null) {
                logger.error("接口方法[ChannelService.saveChannelCustomer],参数vo不能为空");
                return num;
            }
            if (vo.getId() == null || vo.getId() < 1) {
                logger.error("接口方法[ChannelService.saveChannelCustomer],参数vo的不能为空");
                return num;
            }
            SysChannel channel = ChannelVo.changeTSysBean(vo);

            List<LabelVo> voList = vo.getList();
            List<SysLabel> labelList = null;
            if (voList != null && !voList.isEmpty()) {
                labelList = LabelVo.cList2SList(voList);
            }
            Long updateNum = ichannelService.saveChannelAndChannelLabel(
                    channel, labelList, false);

            return Integer.valueOf(updateNum.toString());
        } catch (Exception e) {
            Log.error(e.toString());
            throw e;
        }
    }

    /**
     * 获取渠道下的政策
     */
    @Override
	public ChannelVo getChannelStrategyList(Long id) throws Exception {
        ChannelVo vo = null;
        try {
            if (id == null) {
                logger.error("接口方法[ChannelService.getChannelStrategyList],参数id不能为空");
                return null;
            }

            // 查询用户
            SysChannel sysBean = ichannelService.getById(id);
            if (sysBean != null) {
                vo = ChannelVo.changeTChannelVo(sysBean);
                channelVoUtil.setChannelStrategyList(vo);
            }

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return vo;
    }

    /**
     * 通过id查询单个对象
     * 
     * @throws Exception
     */
    @Override
	public ChannelVo getById(Long id) throws Exception {
        ChannelVo cv = null;
        try {
            if (id == null || id < 1) {
                logger.error("接口方法[ChannelService.getById],参数id不能为空");
            }
            SysChannel channel = ichannelService.getById(id);
            if (channel != null) {
                cv = ChannelVo.changeTChannelVo(channel);
            }
        } catch (Exception e) {

            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
        return cv;
    }

    /**
     * 渠道查询集合
     * 
     * @throws Exception
     */
    @Override
	public PageList<ChannelVo> queryPageByParamMap(PageModel pager, ChannelVo vo)
            throws Exception {
        PageList<ChannelVo> list = new PageList<ChannelVo>();
        try {
            SysChannel channel = ChannelVo.changeTSysBean(vo);

            if (null != channel) {
                if (null != channel.getName())
                    channel.setName(channel.getName() + "%");
                if (null != channel.getChannelPrincipal())
                    channel.setChannelPrincipal(channel.getChannelPrincipal() + "%");
            }

            PageList<SysChannel> pageList = ichannelService
                    .queryPageByParamMap(pager, channel);

            List<ChannelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannel> records = pageList.getResultList();
                voList = ChannelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    /**
     * 获取渠道下的分销商
     */
    @Override
	public ChannelVo getChannelCustomerList(Long id) throws Exception {
        ChannelVo vo = null;
        try {
            if (id == null) {
                logger.error("接口方法[ChannelService.getChannelCustomerList],参数id不能为空");
                return null;
            }

            // 查询用户
            SysChannel sysBean = ichannelService.getById(id);
            if (sysBean != null) {
                vo = ChannelVo.changeTChannelVo(sysBean);
                channelVoUtil.setChannelCustomerList(vo);
            }

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return vo;
    }

    /**
     * 获取渠道下的产品主键集合
     */
    @Override
	public ChannelVo getChannelProductIdList(Long id) throws Exception {
        ChannelVo vo = null;
        try {
            if (id == null) {
                logger.error("接口方法[ChannelService.getChannelProductIdList],参数id不能为空");
                return null;
            }

            // 查询用户
            SysChannel sysBean = ichannelService.getById(id);
            if (sysBean != null) {
                vo = ChannelVo.changeTChannelVo(sysBean);
                channelVoUtil.setChannelStrategyList(vo);

            }

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return vo;
    }

    /**
     * 批量修改渠道状态
     */
    @Override
    public Integer updateBatchChannelPrimaryKey(List<Long> ids, String flag) {
        Integer num = 0;
        try {
            if (ids == null || ids.isEmpty()) {
                logger.error("接口方法[ChannelService.updateBatchChannelPrimaryKey],参数ids不能为空");
                return num;
            }
            if (StringUtils.isBlank(flag)) {
                logger.error("接口方法[ChannelService.updateBatchChannelPrimaryKey],参数flag不能为空");
                return num;
            }
            List<SysChannel> list = new ArrayList<SysChannel>();
            for (Long id : ids) {
                if (id == null || id < 1) {
                    continue;
                }
                SysChannel bean = new SysChannel();
                bean.setId(id);
                bean.setDelFlag(flag);
                list.add(bean);
            }
            num = ichannelService.updateBatchByPrimaryKey(list);

        } catch (Exception e) {
            logger.error(e.toString());
        }

        return num;
    }

    @Override
	public ChannelVo getChannelLabelList(Long id) throws Exception {
        ChannelVo vo = null;
        try {
            if (id == null) {
                logger.error("接口方法[ChannelService.getChannelLabelList],参数id不能为空");
                return null;
            }

            // 查询用户
            SysChannel sysBean = ichannelService.getById(id);
            if (sysBean != null) {
                vo = ChannelVo.changeTChannelVo(sysBean);
                channelVoUtil.setChannelLabelist(vo);
            }

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return vo;
    }

    @Override
	public PageList<ChannelVo> queryPageByStrategyId(PageModel pager,
            ChannelVo vo, Long strategyId) throws Exception {
        PageList<ChannelVo> list = new PageList<ChannelVo>();
        try {
            if (strategyId == null || strategyId < 1) {
                logger.error("接口方法[ChannelService.queryPageByStrategyId],参数strategyId不能为空");
                return list;
            }
            SysChannel sysBean = ChannelVo.changeTSysBean(vo);
            PageList<SysChannel> pageList = ichannelService.queryPageByObjId(
                    pager, sysBean, strategyId,
                    ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);

            List<ChannelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannel> records = pageList.getResultList();
                voList = ChannelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Override
	public PageList<ChannelVo> queryPageNotByProductId(PageModel pager,
            ChannelVo vo, Long productId) throws Exception {
        PageList<ChannelVo> list = new PageList<ChannelVo>();
        try {
            if (productId == null || productId < 1) {
                logger.error("接口方法[ChannelService.queryPageNotByProductId],参数productId不能为空");
                return list;
            }
            SysChannel sysBean = ChannelVo.changeTSysBean(vo);
            PageList<SysChannel> pageList = ichannelService
                    .queryPageNotByProductId(pager, sysBean, productId);

            List<ChannelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannel> records = pageList.getResultList();
                voList = ChannelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Override
	public PageList<ChannelVo> queryPageByCustomerId(PageModel pager,
            ChannelVo vo, Long customerId) throws Exception {
        PageList<ChannelVo> list = new PageList<ChannelVo>();
        try {
            if (customerId == null || customerId < 1) {
                logger.error("接口方法[ChannelService.queryPageByCustomerId],参数customerId不能为空");
                return list;
            }
            SysChannel sysBean = ChannelVo.changeTSysBean(vo);
            PageList<SysChannel> pageList = ichannelService.queryPageByRefId(
                    pager, sysBean, customerId,
                    ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);

            List<ChannelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannel> records = pageList.getResultList();
                voList = ChannelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }
    /**
     * 根据供应商ID获取该供应商创建的所有渠道
     */
	@Override
	public PageList<ChannelVo> queryPageBySupplierId(PageModel pager, Long supplierId) throws Exception {

        PageList<ChannelVo> list = new PageList<ChannelVo>();
        try {
            if (supplierId == null || supplierId < 1) {
                logger.error("接口方法[ChannelService.queryPageBySupplierId],参数supplierId不能为空");
                return list;
            }
            PageList<SysChannel> pageList = 
            		ichannelService.queryPageBySupplierId(pager, supplierId);

            List<ChannelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysChannel> records = pageList.getResultList();
                voList = ChannelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
        return list;
	}

}
