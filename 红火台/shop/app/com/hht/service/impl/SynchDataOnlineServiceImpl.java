package com.hht.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.mapper.*;
import com.hht.models.BAccount;
import com.hht.models.BShopVersion;
import com.hht.service.SynchDataOnlineService;
import com.hht.utils.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称：blog
 * 类名称：
 * 创建人： qi_grui
 * 创建时间：2016/12/8 11:10
 */
public class SynchDataOnlineServiceImpl implements SynchDataOnlineService{

    //查询线上版本的地址
    private static String VERSION_URL = "http://localhost:9000/version/queryVersion";
    //查询模块版本的地址
    private static String MODULE_URL = "http://localhost:9000/schedule/getScheduleInfo";

    @Inject
    private BShopVersionMapper bShopVersionMapper;
    @Inject
    private BPayTypeMapper bPayTypeMapper;
    @Inject
    private BAccountMapper bAccountMapper;
    @Inject
    private BAccountDiscountMapper bAccountDiscountMapper;
    @Inject
    private BDishDiscountMapper bDishDiscountMapper;
    @Inject
    private BTableInfoMapper bTableInfoMapper;
    @Inject
    private BTableTypeMapper bTableTypeMapper;
    @Inject
    private BDishMapper bDishMapper;
    @Inject
    private BDishClassMapper bDishClassMapper;
    @Inject
    private BDishTasteMapper bDishTasteMapper;
    @Inject
    private BDishTasteLinkMapper bDishTasteLinkMapper;
    @Inject
    private BDishCookingMapper bDishCookingMapper;
    @Inject
    private BDishCookingLinkMapper bDishCookingLinkMapper;

    /**
     * 数据同步开始
     */
    @Override
    public void synchDataFromOnline() {
        //查询本地版本
        BShopVersion bShopVersion = bShopVersionMapper.selectAllVersion();
        if(null == bShopVersion){
            System.out.println("=====门店未注册，请先注册=====");
            return;
        }
        //查询线上的版本
        Map<String,String> param = new HashMap<>();
        param.put("tenantId",bShopVersion.getTenantId());
        param.put("shopId",bShopVersion.getShopId());
        String response = HttpUtil.sendGet(VERSION_URL,param);
        if(null == response || response.equals("")){
            System.out.println("=====不合法的门店=====");
            return;
        }
        JSONObject json = JSONObject.parseObject(response);
        if(json.size() == 0){
            System.out.println("=====不合法的门店=====");
            return;
        }
        //比较门店员工版本号跟线上的员工版本号
        if(json.getIntValue("accountVersion") != bShopVersion.getAccountVersion()){
            //版本不同的话升级版本
            //查询线上版本
            param.put("type", Constant.SCHEDULE_TYPE_ACCOUNT);
            String accountStr = HttpUtil.sendPost(MODULE_URL,param);
            JSONObject accountObj = JSONObject.parseObject(accountStr);
            JSONArray array = accountObj.getJSONArray("obj");
            List<BAccount> deleteList = bAccountMapper.selectByParams(param);
            //判断新增，修改，删除的菜品
            List<BAccount> updateList = new ArrayList<>();
            List<BAccount> addList = new ArrayList<>();
            if(array != null && array.size()>0){
                //线上数据遍历
                addList = JSONArray.parseArray(array.toJSONString(),BAccount.class);
                for (int i = addList.size()-1;i>=0;i--){
                    //线上
                    BAccount onlineAccount = addList.get(i);
                    //门店数据遍历
                    if (deleteList != null && deleteList.size()>0){
                        for(int j=deleteList.size()-1;j>=0;j--){
                            //门店
                            BAccount shopAccount = deleteList.get(j);
                            if(onlineAccount.getLoginAccount() == shopAccount.getLoginAccount()){
                                //同一个人员
                                if (onlineAccount.getUpdateTime() != shopAccount.getUpdateTime()){
                                    updateList.add(onlineAccount);
                                }
                                addList.remove(i);
                                deleteList.remove(j);
                                break;
                            }
                        }
                    }
                }
            }
            //修改人员信息
            if (updateList != null && updateList.size()>0){
                for (BAccount account : updateList){
                    bAccountMapper.updateByPrimaryKey(account);
                }
            }
            //删除人员信息
            if(deleteList != null && deleteList.size()>0){
                bAccountMapper.batchDelete(deleteList);
            }
            //新增人员信息
            if(addList != null && addList.size()>0){
                bAccountMapper.batchInsert(addList);
            }
        }
        //菜品信息同步
        if (json.getIntValue("accountVersion") != bShopVersion.getDishVersion()){

        }

    }
}
