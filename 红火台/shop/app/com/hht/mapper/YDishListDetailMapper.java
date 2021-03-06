package com.hht.mapper;

import com.hht.models.YDishListDetail;

import java.util.List;

public interface YDishListDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_dish_list_detail
     *
     * @mbggenerated Thu Nov 17 16:47:00 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_dish_list_detail
     *
     * @mbggenerated Thu Nov 17 16:47:00 CST 2016
     */
    int insert(YDishListDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_dish_list_detail
     *
     * @mbggenerated Thu Nov 17 16:47:00 CST 2016
     */
    int insertSelective(YDishListDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_dish_list_detail
     *
     * @mbggenerated Thu Nov 17 16:47:00 CST 2016
     */
    YDishListDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_dish_list_detail
     *
     * @mbggenerated Thu Nov 17 16:47:00 CST 2016
     */
    int updateByPrimaryKeySelective(YDishListDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table y_dish_list_detail
     *
     * @mbggenerated Thu Nov 17 16:47:00 CST 2016
     */
    int updateByPrimaryKey(YDishListDetail record);

    /**
     * 更新菜单明细表
     * @param record
     * @return
     */
    int updateByBatchNo(YDishListDetail record);

    /**
     * 查询菜单明细通过菜单编号和菜品编号
     * @param dishCode
     * @param dishListCode
     * @return
     */
    YDishListDetail selectByBillParam(String dishCode,String dishListCode);

    /**
     * 根据菜单编号获取菜品明细
     * @param dishListCode
     * @return
     */
    List<YDishListDetail> selectByDishListCode(String dishListCode);
}