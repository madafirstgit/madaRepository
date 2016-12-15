package controllers;

import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.models.BOrderDishList;
import com.hht.models.BPaymenList;
import com.hht.models.UdAccountOrder;
import com.hht.models.UnitOrderAccount;
import com.hht.service.AccountsSerive;
import com.hht.utils.JsonUtil;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Map;

/**
 * @说明：结账专用
 * @作者：Tony Hu
 * @Email：hujn@yonyou.com
 * @时间：2016/11/25.
 */
public class AccountsController extends Controller {

    private AccountsSerive accountsSerive;

    @Inject
    public AccountsController(AccountsSerive serv) {
        this.accountsSerive = serv;
    }

    /*统一订餐结账通知接口*/
    public Result unitOrderAccount() {


        String jsonNode = request().body().asJson().toString();
        Map<String, Object> map = JsonUtil.jsonToMap(jsonNode);
        UnitOrderAccount unitOrderAccount = new JSONObject(map).toJavaObject(UnitOrderAccount.class);

        return ok(accountsSerive.insertUnitOrderAccount(unitOrderAccount));
    }

    /*U鼎点菜结账指令*/
    public Result udAccountOrder() {
        String jsonNode = request().body().asJson().toString();
        Map<String, Object> map = JsonUtil.jsonToMap(jsonNode);
        UdAccountOrder udAccountOrder = new JSONObject(map).toJavaObject(UdAccountOrder.class);

        List<BOrderDishList> bOrderDishList = JsonUtil.jsonToList(map.get("orderdishlist") == null ? null : map.get("orderdishlist").toString(), BOrderDishList.class);
        List<BPaymenList> bPaymenList = JsonUtil.jsonToList(map.get("dishkey") == null ? null : map.get("dishkey").toString(), BPaymenList.class);

        return ok(accountsSerive.insertUdAccountOrder(udAccountOrder, bOrderDishList, bPaymenList));
    }

}
