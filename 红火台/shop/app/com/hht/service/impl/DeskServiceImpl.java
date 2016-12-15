package com.hht.service.impl;

import com.google.inject.Inject;
import com.hht.constants.Constant;
import com.hht.mapper.*;
import com.hht.models.*;
import com.hht.service.DeskService;
import com.hht.utils.DateUtil;
import com.hht.utils.JsonUtil;
import com.hht.utils.UUidUtil;
import org.mybatis.guice.transactional.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作开台实现类
 *
 * @author panghui
 * @version 1.0
 * @since 2016/11/18
 */
public class DeskServiceImpl implements DeskService {

    @Inject
    private YDishListMapper yDishListMapper;

    @Inject
    private YTableBillMapper yTableBillMapper;

    @Inject
    private BTableDynamicMapper bTableDynamicMapper;

    @Inject
    private YTableOprrecordMapper yTableOprrecordMapper;

    @Inject
    private YBillAccountMapper yBillAccountMapper;

    /**
     * 根据传入参数开台
     *
     * @param params
     * @return
     */
    @Transactional
    public String openDesk(String params) {

        Map<String, Object> map = JsonUtil.jsonToMap(params);

        String tableNo = map.get("tableNo").toString();
        String waiterNo = map.get("waiterNo").toString();
        String customerNum = map.get("customerNum").toString();

        String menuCode = addMenu(tableNo);
        if (menuCode != null) {
            String billCode = addTableBill(tableNo, waiterNo, Integer.parseInt(customerNum), menuCode);

            if (billCode != null) {

                int operate = addBillAccount(billCode);

                if(operate == 1){

                    operate = saveOrUpdate(tableNo,menuCode,billCode,customerNum);
                    if(operate == 1){
                        if(addOpreateLog(tableNo,waiterNo)>0){

                            Map<String,Object> mapResult = new HashMap<String,Object>();
                            mapResult.put("dishListId",menuCode);
                            mapResult.put("tableservicefee","");
                            mapResult.put("operatetime", DateUtil.dateFormat(new Date()));
                            mapResult.put("billno",billCode);
                            return JsonUtil.objectToJson(mapResult);
                        }else{
                            return "0";
                        }
                    }else{
                        return "-1";
                    }

                }else{
                    return "-1";
                }
            } else {
                return "-1";
            }
        } else {
            return "-1";
        }

    }

    /**
     * 确认账单
     *
     * @param params
     * @param operate 1=确认账单，2=账单解锁
     * @return
     */
    public String operateBill(String params,int operate){

        Map<String, Object> map = JsonUtil.jsonToMap(params);

        Map<String,Object> mapResult = new HashMap<String,Object>();

        BTableDynamic bTableDynamic = bTableDynamicMapper.selectByTableCode(map);

        // 当前桌位已经开台，并且占用
        if(bTableDynamic != null && 1==bTableDynamic.getTableStatus()){
            bTableDynamic.setBillClose(operate==1?1:0);
            int result = bTableDynamicMapper.updateByPrimaryKeySelective(bTableDynamic);
            if(result >0){
                mapResult.put("resultcode",1);
                mapResult.put("resultdesc",operate==1?"账单确认成功":"账单解锁成功");
            }else{
                mapResult.put("resultcode",0);
                mapResult.put("resultdesc",operate==1?"账单确认失败":"账单解锁失败");
            }
        }else{
            mapResult.put("resultcode",0);
            mapResult.put("resultdesc",operate==1?"账单确认失败,不存在可确认账单":"账单解锁失败,不存在可解锁账单");
        }


        return JsonUtil.objectToJson(mapResult);
    }


    /**
     * 根据桌台编号，生成菜单数据
     *
     * @param tableNo 返回菜单编号
     * @return
     */
    protected String addMenu(String tableNo) {

        String menuCode = Constant.MENU_CODE + System.currentTimeMillis() + tableNo;

        YDishList yDishList = new YDishList();
        yDishList.setId(UUidUtil.generateId());
        yDishList.setCreateTime(new Date());
        yDishList.setDishListCode(menuCode);

        if (yDishListMapper.insert(yDishList) > 0) {
            return menuCode;
        } else {
            return null;
        }
    }

    /**
     * 根据输入信息、菜单编号生成桌台账单信息
     *
     * @param tableNo
     * @param waiterNo
     * @param customerNum
     * @param menuCode
     * @return 返回账单编号
     */
    protected String addTableBill(String tableNo, String waiterNo, Integer customerNum, String menuCode) {

        String billCode = Constant.BILL_CODE + System.currentTimeMillis() + tableNo;

        YTableBill yTableBill = new YTableBill();
        yTableBill.setId(UUidUtil.generateId());
        yTableBill.setTableCode(tableNo);
        yTableBill.setOperatorId(waiterNo);
        yTableBill.setPersonNum(customerNum);
        yTableBill.setDishListCode(menuCode);
        yTableBill.setBillNo(billCode);

        if (yTableBillMapper.insert(yTableBill) > 0) {
            return billCode;
        } else {
            return null;
        }

    }

    /**
     * 添加结算账单表
     *
     * @param billCode
     * @return
     */
    protected int addBillAccount(String billCode){

        YBillAccount yBillAccount = new YBillAccount();
        yBillAccount.setId(UUidUtil.generateId());
        yBillAccount.setBillNo(billCode);
        yBillAccount.setStatus(1);
        yBillAccount.setCreateTime(new Date());

        return yBillAccountMapper.insertSelective(yBillAccount);

    }

    /**
     * 更新或者插入桌位动态表数据
     *
     * @param tableNo
     * @param menuCode
     * @param billCode
     * @param customerNum
     * @return  0|失败，1|成功，-1|不可开台
     */
    protected int saveOrUpdate(String tableNo, String menuCode, String billCode, String customerNum) {

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("tableCode",tableNo);

        BTableDynamic bTableDynamic = bTableDynamicMapper.selectByTableCode(map);

        if (bTableDynamic != null && 0 == bTableDynamic.getTableStatus()) {
            bTableDynamic.setDishListCode(menuCode);
            bTableDynamic.setBillNo(billCode);
            // 桌位状态，改为占用
            bTableDynamic.setTableStatus(1);
            bTableDynamic.setPersonNum(Integer.parseInt(customerNum));
            bTableDynamic.setOpenTime(new Date());
            // 设置桌台状态为非免打扰模式
            bTableDynamic.setNoDisturb(0);
            bTableDynamic.setBillClose(0);

            return bTableDynamicMapper.updateByPrimaryKeySelective(bTableDynamic);

        } else if (bTableDynamic != null && (1 == bTableDynamic.getTableStatus() || 3 == bTableDynamic.getTableStatus())) {
            // 当前桌位正在被占用，不可开台
            return -1;
        }else{
            bTableDynamic = new BTableDynamic();
            bTableDynamic.setId(UUidUtil.generateId());
            bTableDynamic.setTableCode(tableNo);
            bTableDynamic.setDishListCode(menuCode);
            bTableDynamic.setBillNo(billCode);
            // 桌位状态，改为占用
            bTableDynamic.setTableStatus(1);
            bTableDynamic.setPersonNum(Integer.parseInt(customerNum));
            bTableDynamic.setOpenTime(new Date());
            // 设置桌台状态为非免打扰模式
            bTableDynamic.setNoDisturb(0);

            return bTableDynamicMapper.insert(bTableDynamic);
        }

    }

    /**
     * 记录操作日志
     *
     * @param tableNo
     * @param waiterNo
     * @return
     */
    protected int addOpreateLog(String tableNo,String waiterNo){

        YTableOprrecord yTableOprrecord = new YTableOprrecord();
        yTableOprrecord.setId(UUidUtil.generateId());
        yTableOprrecord.setTableCode(tableNo);
        // 设置操作类型为开台
        yTableOprrecord.setOperType("09");
        yTableOprrecord.setOperator(waiterNo);
        yTableOprrecord.setOperTime(new Date());

        return yTableOprrecordMapper.insert(yTableOprrecord);
    }

}
