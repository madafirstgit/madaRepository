package com.pzj.regulation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.service.sys.ISpcreRelationService;
import com.pzj.regulation.entity.RebatePlus;

/**
 * 平台加点返
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-11-16 下午6:53:33
 */
@Service
public class RebatePlusServiceImpl implements RebatePlusService {

	@Autowired
	private ISpcreRelationService ispcreRelationService;

	public PageList<RebatePlus> findPageSpcreRelation(PageModel pager,
			RebatePlus entity) {
		if (entity.getChannelId() == null) {
			throw new NullPointerException("渠道id不能为空，channelId is missing");
		}
		SysSpcreRelationKey sr = RebatePlus.toConver(entity);
		PageList<SysSpcreRelationKey> list = ispcreRelationService
				.findPageSpcreRelation(pager, sr);
		PageList<RebatePlus> rePage = new PageList<RebatePlus>();
		List<RebatePlus> reList = new ArrayList<RebatePlus>();
		for (SysSpcreRelationKey ssr : list.getResultList()) {
			reList.add(RebatePlus.fromConver(ssr));
		}
		rePage.setResultList(reList);
		rePage.setPageBean(list.getPageBean());
		return rePage;
	}

	public Integer updateStatus(List<RebatePlus> list) {
		List<SysSpcreRelationKey> toList = new ArrayList<SysSpcreRelationKey>();
		for (RebatePlus rp : list) {
			if (rp.getChannelId() == null) {
				throw new NullPointerException("channelId is missing");
			}
			if (rp.getStrategyId() == null) {
				throw new NullPointerException("strategyId is missing");
			}
			if (rp.getStatus() == null) {
				throw new NullPointerException("status is missing");
			}
			toList.add(RebatePlus.toConver(rp));
		}
		return ispcreRelationService.updateByChannelStrategy(toList);
	}

	public PageList<RebatePlus> queryPageByParamMap(PageModel pager,
			RebatePlus entity) throws Exception {
		PageList<SysSpcreRelationKey> list = ispcreRelationService
				.queryPageByParamMap(pager, RebatePlus.toConver(entity));
		PageList<RebatePlus> rePage = new PageList<RebatePlus>();
		List<RebatePlus> reList = new ArrayList<RebatePlus>();
		for (SysSpcreRelationKey ssr : list.getResultList()) {
			reList.add(RebatePlus.fromConver(ssr));
		}
		rePage.setResultList(reList);
		rePage.setPageBean(list.getPageBean());
		return rePage;
	}
}
