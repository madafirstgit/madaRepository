package com.hht.service.impl;

import com.google.inject.Inject;
import com.hht.annotation.Transaction;
import com.hht.mapper.YDishListDetailMapper;
import com.hht.models.YDishListDetail;
import com.hht.service.ConfirmDishService;
import org.mybatis.guice.transactional.Transactional;


/**
 * Created by Zhu Tao on 2016-11-18.
 */
public class ConfirmDishServiceImpl implements ConfirmDishService {
    private YDishListDetailMapper yDishListDetailDao;
    @Inject
    public ConfirmDishServiceImpl(YDishListDetailMapper yDishListDetailMapper){
           this.yDishListDetailDao = yDishListDetailMapper;
    }

    private boolean findOptNum(String dishcode,String dishlistcode) {
        YDishListDetail yDishListDetail = yDishListDetailDao.selectByBillParam(dishcode, dishlistcode);
        return CompareQuantity(yDishListDetail);
    }

    private boolean  CompareQuantity(YDishListDetail yDishListDetail) {
        float quantity = yDishListDetail.getQuantity();
        float serverq = yDishListDetail.getServedQuantity();
        if(quantity==serverq){
            return true;
        }
        return false;
    }

    /**
     * 如果数量和已上菜数量相等，则更新状态
     * @param yDishListDetail
     * @return
     */
    @Override

   @Transactional
    public String updateYDishListDetail(YDishListDetail yDishListDetail){
        String dishCode = yDishListDetail.getDishCode();
        String dishListCode = yDishListDetail.getDishListCode();
        yDishListDetailDao.updateByBatchNo(yDishListDetail);
        if(findOptNum(dishCode,dishListCode)){
            try {
                yDishListDetail.setDishStatus(1);
                //throw new Exception("2");
                yDishListDetailDao.updateByBatchNo(yDishListDetail);
                return "successful";
            }catch (Exception e){
                return "fail";
            }
        }
        return "fail";
    }

}
