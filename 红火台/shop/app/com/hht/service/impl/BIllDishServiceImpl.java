package com.hht.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hht.annotation.Transaction;
import com.hht.mapper.*;
import com.hht.models.*;
import com.hht.service.BillDishService;
import com.hht.utils.DateUtil;
import com.hht.utils.UUidUtil;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by qi_grui on 2016/11/22.
 */
public class BIllDishServiceImpl implements BillDishService {

    private YDishListDetailMapper yDishListDetailMapper;
    private YTableBillMapper yTableBillMapper;
    private BDishMapper bDishMapper;
    private BDishClassMapper bDishClassMapper;
    private BDishCookingMapper bDishCookingMapper;
    private BTableInfoMapper bTableInfoMapper;
    private BTableDynamicMapper bTableDynamicMapper;
    private YBillAccountMapper yBillAccountMapper;
    private YTableOprrecordMapper yTableOprrecordMapper;


    @Inject
    public BIllDishServiceImpl(YDishListDetailMapper yDishListDetailMapper,YTableBillMapper yTableBillMapper,
                               BDishMapper bDishMapper,BDishClassMapper bDishClassMapper,
                               BDishCookingMapper bDishCookingMapper,BTableInfoMapper bTableInfoMapper,
                               BTableDynamicMapper bTableDynamicMapper,YBillAccountMapper yBillAccountMapper,
                               YTableOprrecordMapper yTableOprrecordMapper) {
        this.yDishListDetailMapper = yDishListDetailMapper;
        this.yTableBillMapper = yTableBillMapper;
        this.bDishMapper = bDishMapper;
        this.bDishMapper = bDishMapper;
        this.bDishCookingMapper = bDishCookingMapper;
        this.bTableInfoMapper = bTableInfoMapper;
        this.bTableDynamicMapper = bTableDynamicMapper;
        this.yBillAccountMapper = yBillAccountMapper;
        this.yTableOprrecordMapper = yTableOprrecordMapper;

    }

    /**
     * 下单操作
     * @param
     * @return
     */
    @Override
    @Transaction
    public Map<String, Object> billDishOrder(String tableNo, String billNo, String dishListNo, String waiterNo, String chooseData) {
        Map<String,Object> result = new HashMap<String,Object>();
        //菜单明细表
        YDishListDetail yDishListDetail = null;

        try {
            //解析菜单
            JSONArray chooseDataList = JSONArray.parseArray(chooseData);
            //结算账单表
            YBillAccount yBillAccount = new YBillAccount();
            //查询桌位信息
            BTableInfo bTableInfo = bTableInfoMapper.selectByTableCode(tableNo);
            //桌位动态
            Map<String,Object> p = new HashMap<>();
            p.put("tableCode",tableNo);
            BTableDynamic dynamic = bTableDynamicMapper.selectByTableCode(p);
            BigDecimal amount = new BigDecimal(0);

            for(int i=0;i<chooseDataList.size();i++){
                JSONObject obj = chooseDataList.getJSONObject(i);
                //查询菜品信息
                BDish bDish = bDishMapper.selectByDishCode(obj.getString("itemNo"));
                //保存菜单明细表
                yDishListDetail = new YDishListDetail();
                yDishListDetail.setDishListCode(dishListNo);
                yDishListDetail.setDishCode(obj.getString("itemNo"));
                yDishListDetail.setName(bDish.getName());
                yDishListDetail.setPrice(bDish.getPrice());
                yDishListDetail.setUnit(bDish.getUnit());
                yDishListDetail.setQuantity(obj.getFloat("itemNum"));
                yDishListDetail.setDishStatus(0);
                yDishListDetail.setCooking(obj.getString("itemMethod"));
                yDishListDetail.setRemark(obj.getString("reamrk"));
                yDishListDetail.setOrderTime(new Date());
                yDishListDetail.setOperType("下单");
                yDishListDetail.setOperator(waiterNo);
                yDishListDetail.setServedQuantity(0f);
                //判断是否是下单的菜品0-没下单，1-下单，2-延时
                Integer devSource = obj.getInteger("devSource");
                yDishListDetail.setId(UUidUtil.generateId());
                int key = yDishListDetailMapper.insertSelective(yDishListDetail);
                amount = amount.add(bDish.getPrice());
            }
            //桌台账单表
            YTableBill yTableBill = yTableBillMapper.selectByBillNo(billNo);
            yTableBill.setBillAmount(yTableBill.getBillAmount()==null?amount:yTableBill.getBillAmount().add(amount));
            yTableBill.setDishAmount(yTableBill.getDishAmount()==null?amount:yTableBill.getDishAmount().add(amount));
            yTableBillMapper.updateByPrimaryKey(yTableBill);
            //结算账单表
            YBillAccount account = yBillAccountMapper.selectByBillNo(billNo);
            account.setTotal(yTableBill.getBillAmount());
            yBillAccountMapper.updateByPrimaryKey(account);
            //保存桌台操作记录
            YTableOprrecord tableOpr = new YTableOprrecord();
            tableOpr.setOperator(waiterNo);
            tableOpr.setOperDetailed("菜品下单");
            tableOpr.setOperTime(new Date());
            tableOpr.setTableCode(tableNo);
            tableOpr.setOperType("11");
            tableOpr.setId(UUidUtil.generateId());

            yTableOprrecordMapper.insertSelective(tableOpr);

            //下面设置返回值
            result.put("billNo",billNo);//账单编号
            result.put("allowanceAmount",yTableBill.getAllowanceAmount());//折让金额
            result.put("billAmount",yTableBill.getBillAmount());//账单金额
            result.put("foodAmount",yTableBill.getDishAmount());//菜品金额
            result.put("discountAmount",yTableBill.getDishAmount());//折扣金额
            result.put("checkoutTime","");//结账时间
            result.put("discountId","");//折扣方案的id
            result.put("discountName","");//折扣方案名称
            result.put("discountRate","");//折扣率
            //付款类型，暂时没有
            result.put("paymentType","{}");
            result.put("prepaymentsAmount",0);//预付款金额
            result.put("serviceFee",yTableBill.getServerAmount());//包间服务费
            result.put("reason","");//折让原因
            result.put("tableNo",tableNo);//桌台号
            result.put("tableName",bTableInfo.getTableName());//桌台名称
            result.put("twoDimensionCode","");//二维码地址
            //查询出已下单的菜品返回
            List<YDishListDetail> dishList = yDishListDetailMapper.selectByDishListCode(dishListNo);
            List<Map<String,Object>> dishRealBillList = new ArrayList<>();
            for(YDishListDetail detail:dishList){
                Map<String,Object> map = new HashMap<>();
                //查询菜品信息
                BDish bDish = bDishMapper.selectByDishCode(detail.getDishCode());
                map.put("dishNo",detail.getDishCode());//菜品编号
                map.put("dishName",detail.getName());//菜品名称
                map.put("dishNumber","");//批次号
                map.put("dishNumber",detail.getBatchNo());//菜品批次
                map.put("price",bDish.getPrice());//菜品价格
                map.put("actualPrice",detail.getPrice());//菜品真实价格
                map.put("itemStatus",detail.getDishStatus());//菜品状态
                map.put("quantity",detail.getQuantity());//菜品份数
                map.put("unit",detail.getUnit());//菜品单位
                map.put("dishMethod",detail.getCooking()==null?"":detail.getCooking());//做法
                map.put("reasonText",detail.getRemark() == null?"":detail.getRemark());//原因
                map.put("dishType",detail.getDishStatus());//上菜标识
                map.put("haveNo",detail.getServedQuantity());//已上菜数
                map.put("packageNo","");//套餐编号
                map.put("dishAttribute",bDish.getType() == null?"":bDish.getType());//菜品属性
                map.put("foodAmount",bDish.getPrice());//菜品价格
                map.put("orderDateTime", DateUtil.dateFormat(detail.getOrderTime()));//下单时间
                map.put("devSource","已下单");//下单唯一标示
                dishRealBillList.add(map);
            }
            result.put("dishRealBillList",dishRealBillList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
