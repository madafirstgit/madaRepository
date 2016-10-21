package com.pzj.product.vo.voParam.queryParam;

import java.util.List;

import com.pzj.product.vo.product.SkuCloseTimeSlot;

/**
 * Created by Administrator on 2016-8-4.
 */
public class CloseTimeSlotQueryParam extends SkuCloseTimeSlot {
	/**
	 * id集合
	 */
    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
