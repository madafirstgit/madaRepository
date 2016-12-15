package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.models.YTableBill;
import com.hht.service.impl.BillPrintServiceImpl;


/**
 * Created by Zhu Tao on 2016-11-29.
 */
@ImplementedBy(BillPrintServiceImpl.class)
public interface BillPrintService {

    /**
     * 通过账单编号查询账单
     */
    YTableBill getBillPrintDetail(String billNo);

    /**
     * 打印账单
     * @param yTableBill
     * @return
     */
    String printBillDetail(YTableBill yTableBill);
}
