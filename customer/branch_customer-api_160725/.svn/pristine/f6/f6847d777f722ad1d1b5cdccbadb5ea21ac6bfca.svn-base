package com.pzj.regulation.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.regulation.entity.RebatePlus;

/**
 * 平台加点返
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-11-16 下午6:50:55
 */
public interface RebatePlusService {

	/**
	 * 平台 查询未审核加点返
	 * 
	 * @param pager
	 * @param entity
	 * @return
	 */
	public PageList<RebatePlus> findPageSpcreRelation(PageModel pager,
			RebatePlus entity) throws Exception;

	/**
	 * 平台加点返修改状态
	 * 
	 * @param list
	 * @return
	 */
	Integer updateStatus(List<RebatePlus> list);

	/**
	 * 平台 查询加点返产品管理列表
	 * 
	 * @param pager
	 * @param entity
	 * @return
	 */
	public PageList<RebatePlus> queryPageByParamMap(PageModel pager,
			RebatePlus entity) throws Exception;

}
