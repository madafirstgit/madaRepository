package controllers;

import com.google.inject.Inject;
import com.hht.interceptor.Page;
import com.hht.models.ebeans.BDishEntity;
import com.hht.service.BDishQueryService;
import play.data.FormFactory;
import play.mvc.*;

import java.util.Map;

/**
 * Created by Zhu Tao on 2016-11-23.
 */
public class BDishQueryController extends Controller {
    public BDishQueryService bDishQueryService;
    public FormFactory formFactory;

    @Inject
    public BDishQueryController(BDishQueryService bDishQueryService,FormFactory formFactory){
        this.formFactory = formFactory;
        this.bDishQueryService = bDishQueryService;
    }

    /**
     * 根据dishid查询菜品信息
     * @return
     */
    public Result dishQuery(){
        //String id = request().body().asText();
        Map<String,String> map  = formFactory.form().bindFromRequest().get().getData();
        Page<BDishEntity,Map<String,String>> page = new Page();
        page.setPageNum(Integer.valueOf(map.get("pageNum")));
        page.setPageRecordCount(1);
        page.setParams(map);
        String sid = bDishQueryService.getDishInfoListPage(page);
        return ok(sid);
    }
}
