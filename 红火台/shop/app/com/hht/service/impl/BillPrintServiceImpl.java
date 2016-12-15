package com.hht.service.impl;

import com.google.inject.Inject;
import com.hht.mapper.YTableBillMapper;
import com.hht.models.YTableBill;
import com.hht.service.BillPrintService;
import com.hht.utils.print.Connection;
import com.hht.utils.print.PrintTemplete;

import java.io.PrintWriter;

/**
 * Created by Zhu Tao on 2016-11-29.
 */
public class BillPrintServiceImpl implements BillPrintService {
    private YTableBillMapper yTableBillService;

    @Inject
    public BillPrintServiceImpl(YTableBillMapper yTableBillMapper){
         this.yTableBillService = yTableBillMapper;
    }

    @Override
    public YTableBill getBillPrintDetail(String billNo) {
        YTableBill tableBill = yTableBillService.selectByBillNo(billNo);
        return tableBill;
    }

    public String printBillDetail(YTableBill yTableBill){
        try{
            System.out.println("临时输出");
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "ok";
    }
}
