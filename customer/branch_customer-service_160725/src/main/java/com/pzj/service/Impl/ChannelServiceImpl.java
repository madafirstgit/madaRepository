package com.pzj.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IChannelService;
import com.pzj.base.service.sys.ILabelRelationService;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.dao.SysChannelMapper;

@Service("channelService")
public class ChannelServiceImpl extends
        BaseUserServiceImpl<SysChannel, SysChannelMapper> implements
        IChannelService {

    @Autowired
    private ILabelService channelLabelService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ILabelRelationService labelRelationService;

    @Override
	public Long addChannelAndAuth(SysChannel channel, 
            List<SysLabel> channelLabelList) {
        Long channelId = 0l;

        try {
            if (channel == null) {
                logger.error("方法[ChannelService.addChannelAndAuth],参数channel不可以为空");
                return channelId;
            }
            // 新建或更新渠道
            insertOrUpdate(channel);

            channelId = channel.getId();

            if (channelId > 0) {
                // 添加渠道及渠道标签关系
                saveChannelAndChannelLabel(channel, channelLabelList, false);
            }

        } catch (NumberFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return channelId;
    }

    @Override
	public Long saveChannelAndChannelLabel(SysChannel bean,
            List<SysLabel> records, boolean isNeedUpdate) {

        Long num = 0l;
        try {
            if (bean == null) {
                logger.error("方法[ChannelService.saveChannelAndAuth],参数channel不可以为空");
                return num;
            }
            if (bean.getId() == null || bean.getId() < 1) {
                logger.error("方法[ChannelService.saveChannelAndAuth],参数channel的id属性不可以为空");
                return num;
            }
            if (records == null || records.isEmpty()) {
                logger.error("方法[ChannelService.saveChannelAndAuth],参数records不可以为空");
                return num;
            }
            // 更新用户
            if (isNeedUpdate) {
                num += updateByPrimaryKey(bean);
            }

            // 新建或更新角色
            num += channelLabelService.insertOrUpdateBatch(records);

            String objId = String.valueOf(bean.getId());
            // 更新渠道及渠道标签关系
            List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
            for (SysLabel ref : records) {
                Long refId = ref.getId();
                if (ref == null || ref.getId() == null || ref.getId() < 1) {
                    continue;
                }
                SysLabelRelationKey key = new SysLabelRelationKey();
                key.setObjId(objId);
                key.setRelId(String.valueOf(refId));
                key.setRelType(ChannelMapKeyParam.CHANNEL_LABEL_RELATION_TYPE);
                relationList.add(key);

            }

            List<SysChannel> list = new ArrayList<SysChannel>();
            list.add(bean);

            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, getIdList(list));
            searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY,
                    ChannelMapKeyParam.CHANNEL_LABEL_RELATION_TYPE);
            num += labelRelationService.updateAuthBatchByList(searchMap,
                    relationList);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public Integer saveChannelAndUser(SysChannel bean, List<SysUser> records,
            boolean isNeedUpdate) {
        int num = 0;
        try {
            if (bean == null) {
                logger.error("方法[ChannelService.saveChannelAndUser],参数channel不可以为空");
                return num;
            }
            if (bean.getId() == null || bean.getId() < 1) {
                logger.error("方法[ChannelService.saveChannelAndUser],参数channel的id属性不可以为空");
                return num;
            }
            if (records == null || records.isEmpty()) {
                logger.error("方法[ChannelService.saveChannelAndUser],参数records不可以为空");
                return num;
            }
            // 更新用户
            if (isNeedUpdate) {
                num += updateByPrimaryKey(bean);

                // 新建或更新用户
                num += userService.insertOrUpdateBatch(records);
            }

            String objId = String.valueOf(bean.getId());
            // 更新渠道及渠道分销商关系
            List<SysLabelRelationKey> relationList = new ArrayList<SysLabelRelationKey>();
            for (SysUser ref : records) {
                Long refId = ref.getId();
                if (ref == null || ref.getId() == null || ref.getId() < 1) {
                    continue;
                }
                SysLabelRelationKey key = new SysLabelRelationKey();
                key.setObjId(objId);
                key.setRelId(String.valueOf(refId));
                key.setRelType(ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
                relationList.add(key);

            }

            List<SysChannel> list = new ArrayList<SysChannel>();
            list.add(bean);

            Map<String, Object> searchMap = new HashMap<String, Object>();
            searchMap.put(ChannelMapKeyParam.OBJ_MAP_KEY, getIdList(list));
            searchMap.put(ChannelMapKeyParam.RELATION_TYPE_KEY,
                    ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
            num += labelRelationService.updateAuthBatchByList(searchMap,
                    relationList);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public PageList<SysChannel> queryPageByObjId(PageModel pager,
            SysChannel record, Long objId, String refType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", record);
        params.put("idParam", objId);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
        List<SysChannel> listBean = mapper.findListByObjID(params);
        Integer count = mapper.countByParamMap(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannel> pagelist = null;
        pagelist = new PageList<SysChannel>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<SysChannel> queryPageByRefId(PageModel pager,
            SysChannel record, Long refId, String refType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", record);
        params.put("idParam", refId);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
        List<SysChannel> listBean = mapper.findListByRefID(params);
        Integer count = mapper.countByRefID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannel> pagelist = null;
        pagelist = new PageList<SysChannel>(listBean, pageObj);
        return pagelist;
    }

    @Override
	public PageList<SysChannel> queryPageNotByProductId(PageModel pager,
            SysChannel record, Long productId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", record);
        params.put("idParam", productId);
        params.put("strategyChannel",
                ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
        params.put("strategyProduct",
                ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
        List<SysChannel> listBean = mapper.findNotByProductID(params);
        Integer count = mapper.countNotByProductID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannel> pagelist = null;
        pagelist = new PageList<SysChannel>(listBean, pageObj);
        return pagelist;
    }
	public PageList<SysChannel> queryPageBySupplierId(PageModel pager, Long supplierId) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", supplierId);
        //简单的根据供应商ID查询渠道信息
        Integer count = mapper.countPageSingleTable(params);
        List<SysChannel> listBean = mapper.queryPageSingleTable(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysChannel> pagelist = null;
        pagelist = new PageList<SysChannel>(listBean, pageObj);
        return pagelist;
	}

	@Override
	public List<SysChannel> queryPageByUserId(PageModel pager,
			SysChannel param, Long userId) {
		    Map<String, Object> params = new HashMap<String, Object>();
	        params.put("pParam", pager);
	        params.put("bParam", param);
	        params.put("idParam", userId);
	        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
	        List<SysChannel> listBean = mapper.findListByRefID(params);
	        return listBean;
	}

	@Override
	public List<SysChannel> findValidChannelsByIds(
			List<Long> channelIds) {
		List<SysChannel> result = new ArrayList<SysChannel>();
		if(CollectionUtils.isEmpty(channelIds)){
			return result;
		}
		SysChannel queryParam = new SysChannel();
		queryParam.setDelFlag(GlobalParam.FLAG.start().toString());		
		queryParam.setQueryIds(channelIds);
		List<SysChannel> list = findListByParams(queryParam);
		if(CollectionUtils.isNotEmpty(list)){
			return list;
		}
		return result;
	}
}
