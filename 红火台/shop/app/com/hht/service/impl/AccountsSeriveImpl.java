package com.hht.service.impl;

import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.mapper.BOrderDishListMapper;
import com.hht.mapper.BPaymenListMapper;
import com.hht.mapper.UdAccountOrderMapper;
import com.hht.mapper.UnitOrderAccountMapper;
import com.hht.models.BOrderDishList;
import com.hht.models.BPaymenList;
import com.hht.models.UdAccountOrder;
import com.hht.models.UnitOrderAccount;
import com.hht.service.AccountsSerive;
import com.hht.utils.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @说明：
 * @作者：Tony Hu
 * @Email：hujn@yonyou.com
 * @时间：2016/11/25.
 */
public class AccountsSeriveImpl implements AccountsSerive {
    private UnitOrderAccountMapper unitOrderAccountMapper;
    private UdAccountOrderMapper udAccountOrderMapper;
    private BOrderDishListMapper bOrderDishListMapper;
    private BPaymenListMapper bPaymenListMapper;

    @Inject
    public AccountsSeriveImpl(UnitOrderAccountMapper unitOrderAccountDao, UdAccountOrderMapper udAccountOrderMapper, BOrderDishListMapper bOrderDishListMapper, BPaymenListMapper bPaymenListMapper) {
        this.unitOrderAccountMapper = unitOrderAccountDao;
        this.udAccountOrderMapper = udAccountOrderMapper;
        this.bOrderDishListMapper = bOrderDishListMapper;
        this.bPaymenListMapper = bPaymenListMapper;
    }

    @Override
    public String insertUnitOrderAccount(UnitOrderAccount unitOrderAccount) {
        int resultCode = Constant.RESULT_CODE_SUCCESS;
        String resultDesc = "成功";
        try {
//            unitOrderAccount.setId(UUidUtil.generateId());
            unitOrderAccountMapper.insert(unitOrderAccount);
//            System.out.println(unitOrderAccount.getId());


        } catch (Exception e) {
            resultCode = Constant.RESULT_CODE_FAIL;
            resultDesc = "失败";
        }
        Map<String, Object> result_map = new HashMap();
        result_map.put("resultCode", resultCode);
        result_map.put("resultDesc", resultDesc);

        return JsonUtil.objectToJson(result_map);
    }

    @Override
    public String insertUdAccountOrder(UdAccountOrder udAccountOrder, List<BOrderDishList> bOrderDishList, List<BPaymenList> bPaymenList) {
        String uuid = null;//生成ID 作为主表pid
        int resultCode = Constant.RESULT_CODE_SUCCESS;
        String resultDesc = "成功";
        try {
            if (udAccountOrder != null) {
                udAccountOrderMapper.insert(udAccountOrder);
                uuid = udAccountOrder.getId();
            }
            if (bOrderDishList != null && bOrderDishList.size() > 0) {
                for (int i = 0; i < bOrderDishList.size(); i++) {
                    bOrderDishList.get(i).setParentid(uuid);
                    bOrderDishListMapper.insert(bOrderDishList.get(i));
                }

            }
            if (bPaymenList != null && bPaymenList.size() > 0) {
                for (int i = 0; i < bPaymenList.size(); i++) {
                    bPaymenList.get(i).setParentid(uuid);
                    bPaymenListMapper.insert(bPaymenList.get(i));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            resultCode = Constant.RESULT_CODE_FAIL;
            resultDesc = "失败";
        }
        Map<String, Object> resultMap = new HashMap();
        Map<String, Object> zdbhMap = new HashMap(); //结账天子星账单编号
        zdbhMap.put("zdbh", "未查询到账单编号，请重试");
        UnitOrderAccount unitOrderAccount = null;
        unitOrderAccount = unitOrderAccountMapper.selectByBillNo(bOrderDishList.get(0).getBillno());
        if (unitOrderAccount != null && unitOrderAccount.getZdbh() != null && unitOrderAccount.getZdbh().length() > 0) {
            zdbhMap.put("zdbh", unitOrderAccount.getZdbh());
        }
        resultMap.put("resultCode", resultCode);
        resultMap.put("resultDesc", resultDesc);
        resultMap.put("body", zdbhMap);


        return JsonUtil.objectToJson(resultMap);
    }


}
