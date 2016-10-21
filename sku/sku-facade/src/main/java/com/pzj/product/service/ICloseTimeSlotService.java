package com.pzj.product.service;

import java.util.List;

import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.voParam.queryParam.CloseTimeSlotQueryParam;

public interface ICloseTimeSlotService {

    /**
     * 新增关闭时间事件
     * @param vo
     * @return
     * @throws Exception
     */
    Long addCloseTimeSlot(SkuCloseTimeSlot vo) throws Exception;

    /**
     * 批量新增关闭时间事件
     * @param voList
     * @return
     * @throws Exception
     */
    Integer addBatchCloseTimeSlot(List<SkuCloseTimeSlot> voList) throws Exception;

    /**
     * 更新关闭时间事件
     * @param vo
     * @return
     * @throws Exception
     */
    Integer saveCloseTimeSlot(SkuCloseTimeSlot vo) throws Exception;

    /**
     * 批量更新关闭时间事件
     * @param voList
     * @return
     * @throws Exception
     */
    Integer saveBatchCloseTimeSlot(List<SkuCloseTimeSlot> voList) throws Exception;

    /**
     * 根据id删除关闭时间事件
     * @param id
     * @return
     * @throws Exception
     */
    Integer delCloseTimeSlot(Long id) throws Exception;

    /**
     * 根据id批量删除关闭时间事件
     * @param id
     * @return
     * @throws Exception
     */
    Integer delBatchCloseTimeSlot(List<Long> id) throws Exception;
       
    

    List<SkuCloseTimeSlot> querySkuCloseTimeSlotByParams(CloseTimeSlotQueryParam param);
}
