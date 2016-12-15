package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.models.BPayType;
import com.hht.service.impl.PayTypeServiceImpl;

import java.util.List;

/**
 * @author panghui
 * @version 1.0
 * @since 2016-11-29
 */
@ImplementedBy(PayTypeServiceImpl.class)
public interface PayTypeService {

    /**
     * 根据支付方式名称，查询支付方式列表
     *
     * @param params
     * @return
     */
    public List<BPayType> getPayTypeList(String params);

}
