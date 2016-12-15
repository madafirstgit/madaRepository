package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.hht.mapper.YDishListDetailMapper;
import com.hht.models.YDishListDetail;
import com.hht.service.ConfirmDishService;
import com.hht.utils.JsonUtil;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.Database;
import play.mvc.*;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by Zhu Tao on 2016-11-17.
 */
public class DishController  extends Controller {
    private YDishListDetailMapper yDishListDetailDao;
    private Database db;
    private YDishListDetail yDishListDetail;
    private ConfirmDishService confirmDishService;

    private  FormFactory formFactory;
    @Inject
    public DishController(YDishListDetailMapper yDishListDetailMapper,
                          Database db,YDishListDetail yDishListDetail,
                          ConfirmDishService confirmDishService,
                          FormFactory formFactory) {
        this.db = db;
        this.yDishListDetail = yDishListDetail;
        this.confirmDishService = confirmDishService;
        this.formFactory = formFactory;
    }

    /**
     * 确认上菜方法
     * @return
     */
    public Result confirmdish(){
        JsonNode json = request().body().asJson();
        String jsonForm = json.toString();
        List<Map> jsonFormMap = JsonUtil.jsonToList(jsonForm,Map.class);
        String flag = null;
        for(Map p : jsonFormMap) {
            yDishListDetail.setDishListCode(p.get("dish_list_code").toString());
            yDishListDetail.setDishCode(p.get("dish_code").toString());
            yDishListDetail.setServedQuantity(Float.parseFloat(p.get("optNum").toString()));
            yDishListDetail.setOperator(p.get("loginAccount").toString());
            try {
                 flag = confirmDishService.updateYDishListDetail(yDishListDetail);
            } catch (Exception e) {
                e.printStackTrace();
                return ok(e.getMessage());
            }
        }

       return ok(flag);
    }
}
