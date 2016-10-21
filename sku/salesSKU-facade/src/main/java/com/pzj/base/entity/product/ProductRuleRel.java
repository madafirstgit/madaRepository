/**
 * 
 */
package com.pzj.base.entity.product;

import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 * @Describe:
 */
public class ProductRuleRel extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/** 供应商ID */
	private Long s_id;
	/** 产品ID */
	private Long p_id;
	/** 规则ID */
	private Long r_id;
	/** 辅助查询条件 BEGIN */
	// 关系ids
	private List<Long> relIds;
	// 规则ids
	private List<Long> rIds;
	// 产品ids
	private List<Long> pIds;

	/** 辅助查询条件 END */
	public ProductRuleRel() {
		super();
	}

	public Long getS_id() {
		return s_id;
	}

	public void setS_id(Long s_id) {
		this.s_id = s_id;
	}

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public Long getR_id() {
		return r_id;
	}

	public void setR_id(Long r_id) {
		this.r_id = r_id;
	}

	public List<Long> getRelIds() {
		return relIds;
	}

	public void setRelIds(List<Long> relIds) {
		this.relIds = relIds;
	}

	public List<Long> getrIds() {
		return rIds;
	}

	public void setrIds(List<Long> rIds) {
		this.rIds = rIds;
	}

	public List<Long> getpIds() {
		return pIds;
	}

	public void setpIds(List<Long> pIds) {
		this.pIds = pIds;
	}
}
