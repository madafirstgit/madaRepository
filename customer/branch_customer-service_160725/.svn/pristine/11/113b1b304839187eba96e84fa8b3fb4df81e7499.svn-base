package com.pzj.service.Impl;

import java.util.Date;
import java.util.List;

import com.pzj.base.entity.SysChannelStrategy;

public class FilterStrategyUtil {
    private static FilterStrategyUtil util = new FilterStrategyUtil();

    private FilterStrategyUtil() {

    }

    public static FilterStrategyUtil getInstance() {
        return util;
    }

    public boolean haveValidStrategy(List<SysChannelStrategy> filterBeans, String flag, Date date, String... saleTypes) {
        if (filterBeans == null || filterBeans.isEmpty()) {
            return false;
        }

        for (SysChannelStrategy bean : filterBeans) {
            if (isValidStrategy(bean, flag, date, saleTypes)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidStrategy(SysChannelStrategy filterBean, String flag, Date date, String... saleTypes) {
        if (filterBean == null) {
            return false;
        }
        boolean result1 = isValidStrategyByByFlag(filterBean, flag);
        boolean result2 = isValidStrategyByDate(filterBean, date);
        boolean result3 = isValidStrategyBySaleType(filterBean, saleTypes);
        if (result1 && result2 && result3) {
            return true;
        }
        return false;

    }

    public boolean isValidStrategyBySaleType(SysChannelStrategy filterBean, String... saleTypes) {
        if (filterBean == null) {
            return false;
        }
        if (saleTypes == null) {
            return true;
        }
        String beanSaleTypes = filterBean.getSalesType();
        for (String saleType : saleTypes) {
            if (beanSaleTypes.indexOf(saleType) > -1) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidStrategyByDate(SysChannelStrategy filterBean, Date date) {
        if (filterBean == null) {
            return false;
        }
        Date startDate = filterBean.getBeginDate();
        Date endDate = filterBean.getEndDate();
        if (startDate != null && date.before(startDate)) {
            return false;
        }
        if (endDate != null && date.after(endDate)) {
            return false;
        }
        return true;

    }

    private boolean isValidStrategyByByFlag(SysChannelStrategy filterBean, String flag) {
        if (filterBean == null) {
            return false;
        }
        String delFlag = filterBean.getDelFlag();
        if (delFlag != null && flag.equals(delFlag)) {
            return true;
        }
        return false;
    }
}
