package com.pzj.base.entity.json;

import java.io.Serializable;
/**
 * 标识方法执行状态
 * @author Dongchf
 *
 */
public class CommonResult implements Serializable {
	private static final long serialVersionUID = 1L;
	//成功为true；失败为false;
	private Boolean status;
	
	
	public CommonResult(Boolean status) {
		super();
		this.status = status;
	}

	public CommonResult() {
		super();
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
