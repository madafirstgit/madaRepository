package com.hht.service;

import com.google.inject.ImplementedBy;
import com.hht.models.BOrderDishList;
import com.hht.models.BPaymenList;
import com.hht.models.UdAccountOrder;
import com.hht.models.UnitOrderAccount;
import com.hht.service.impl.AccountsSeriveImpl;

import java.util.List;

/**
 * @说明：
 * @作者：Tony Hu
 * @Email：hujn@yonyou.com
 * @时间：2016/11/25.
 */
@ImplementedBy(AccountsSeriveImpl.class)
public interface AccountsSerive {
    /*插入统一订餐结账通知*/
    public String insertUnitOrderAccount(UnitOrderAccount unitOrderAccount);

    /* 插入U鼎点菜结账指令*/
    public String insertUdAccountOrder(UdAccountOrder udAccountOrder, List<BOrderDishList> bOrderDishList, List<BPaymenList> bPaymenList);
}
