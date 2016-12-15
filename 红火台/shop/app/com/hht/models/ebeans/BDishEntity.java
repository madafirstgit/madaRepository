package com.hht.models.ebeans;

import java.math.BigInteger;

/**
 * Created by Zhu Tao on 2016-11-23.
 */
public class BDishEntity {
      private String id;

      private String parent_code;  //父类编号

      private String class_code;   //菜品类型编号

      private String class_name;   //菜品类型名称

      private String class_type;   //分类类型

      private String dish_code;    //菜品编号

      private String name;         //菜品名称

      private String dish_py;      //菜品拼音代码

      private String unit;         //菜品单位

      private String dish_class;   //菜品对外类型

      private String inner_class;  //菜品对内类型

      private double guide_price;  //指导价

      private String description;  //菜品描述

      private String hot_rate;     //热门度

      private String is_free;      //是否是赠品

      private String is_stopped;   //是否已停售

      private String health_index; //健康指数

      private String discount_flag;//允许折扣标志

      private String update_time;  //修改时间

      private String source_info;  //溯源信息

      private String bigImageUrl;  //大图图片信息

      private String MediumImageUrl; //中图图片信息

      private String SmallImageUrl;//小图图片信息

      private BigInteger link_store_dishId; //关联菜品ID

      private String amount;        //装盘斤两

      private String type;          //项目属性, 单品，套餐

      private String producing_area;//产地

      private String provider;      //供应商

      private String food_safety;   //食品安全

      private String yyzs;          //营养指数

      private String shrq;          //适合人群

      private String bshrq;         //不适合人群

      private String jggy;          //加工工艺

      private String cooking_id;    //做法ID

      private String cooking_name;  //做法名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    public String getDish_code() {
        return dish_code;
    }

    public void setDish_code(String dish_code) {
        this.dish_code = dish_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDish_py() {
        return dish_py;
    }

    public void setDish_py(String dish_py) {
        this.dish_py = dish_py;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDish_class() {
        return dish_class;
    }

    public void setDish_class(String dish_class) {
        this.dish_class = dish_class;
    }

    public String getInner_class() {
        return inner_class;
    }

    public void setInner_class(String inner_class) {
        this.inner_class = inner_class;
    }

    public double getGuide_price() {
        return guide_price;
    }

    public void setGuide_price(double guide_price) {
        this.guide_price = guide_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHot_rate() {
        return hot_rate;
    }

    public void setHot_rate(String hot_rate) {
        this.hot_rate = hot_rate;
    }

    public String getIs_free() {
        return is_free;
    }

    public void setIs_free(String is_free) {
        this.is_free = is_free;
    }

    public String getIs_stopped() {
        return is_stopped;
    }

    public void setIs_stopped(String is_stopped) {
        this.is_stopped = is_stopped;
    }

    public String getHealth_index() {
        return health_index;
    }

    public void setHealth_index(String health_index) {
        this.health_index = health_index;
    }

    public String getDiscount_flag() {
        return discount_flag;
    }

    public void setDiscount_flag(String discount_flag) {
        this.discount_flag = discount_flag;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getSource_info() {
        return source_info;
    }

    public void setSource_info(String source_info) {
        this.source_info = source_info;
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public String getMediumImageUrl() {
        return MediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        MediumImageUrl = mediumImageUrl;
    }

    public String getSmallImageUrl() {
        return SmallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        SmallImageUrl = smallImageUrl;
    }

    public BigInteger getLink_store_dishId() {
        return link_store_dishId;
    }

    public void setLink_store_dishId(BigInteger link_store_dishId) {
        this.link_store_dishId = link_store_dishId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducing_area() {
        return producing_area;
    }

    public void setProducing_area(String producing_area) {
        this.producing_area = producing_area;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getFood_safety() {
        return food_safety;
    }

    public void setFood_safety(String food_safety) {
        this.food_safety = food_safety;
    }

    public String getYyzs() {
        return yyzs;
    }

    public void setYyzs(String yyzs) {
        this.yyzs = yyzs;
    }

    public String getShrq() {
        return shrq;
    }

    public void setShrq(String shrq) {
        this.shrq = shrq;
    }

    public String getBshrq() {
        return bshrq;
    }

    public void setBshrq(String bshrq) {
        this.bshrq = bshrq;
    }

    public String getJggy() {
        return jggy;
    }

    public void setJggy(String jggy) {
        this.jggy = jggy;
    }

    public String getCooking_id() {
        return cooking_id;
    }

    public void setCooking_id(String cooking_id) {
        this.cooking_id = cooking_id;
    }

    public String getCooking_name() {
        return cooking_name;
    }

    public void setCooking_name(String cooking_name) {
        this.cooking_name = cooking_name;
    }
}
