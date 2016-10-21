/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.exception.stock.QueryStockDateIllegalException;

/**
 * 
 * @author Administrator
 * @version $Id: CommonUtils.java, v 0.1 2016年7月22日 上午11:28:48 Administrator Exp $
 */
public class CommonUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * 检查对象是否为空
     * @param objs（支持字符串，集合，map，普通对象）多对象传参
     * @return 空：true ；非空：false
     */
    public static boolean checkObjectIsNull(Object... objs) {
        boolean flag = Boolean.TRUE;
        if (null == objs || objs.length == 0) {
            return flag;
        }

        for (Object obj : objs) {
            if (obj instanceof String) {
                flag = checkStringIsNull((String) obj);
            }
            if (obj instanceof Collection) {
                checkCollectionIsNull((Collection<?>) obj);
            }
            if (obj instanceof Map) {
                checkMapIsNull((Map<?, ?>) obj);
            }
            flag = obj == null;
            if (flag) {
                break;
            }
        }
        return flag;
    }

    /**
     * 检查集合是否是空
     * @param collection
     * @return 空：true；非空：false
     */
    public static boolean checkCollectionIsNull(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 检查map是否是空
     * @param map
     * @return 空：true；非空：false
     */
    public static boolean checkMapIsNull(Map<?, ?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * 检查字符串是否为空
     * 空：true ；非空：false
     * @param str
     * @return
     */
    public static boolean checkStringIsNull(String str) {
        return checkStringIsNotNull(str) ? false : true;
    }

    /**
     * 严格检查字符串是否为空
     * 空：true ；非空：false
     * @param str
     * @return
     */
    public static boolean checkStringIsNullStrict(String str) {
        return !checkStringIsNotNull(str) || "null".equals(str) ? true : false;
    }

    /**
     * 检查字符串是否非空
     * 非空：true ；空：false
     * @param str
     * @return
     */
    public static boolean checkStringIsNotNull(String... str) {
        boolean flag = Boolean.FALSE;
        if (null == str || str.length == 0) {
            return flag;
        }
        for (String s : str) {
            if (null == s || "".equals(s.trim()))
                flag = false;
            else
                flag = true;
            if (!flag) {
                break;
            }
        }
        return flag;
    }

    /**
     * 检查long类型参数是否合法
     * 空：true ；非空：false
     * @param id
     * @param checkHigherZero
     * @return
     */
    public static boolean checkLongIsNull(Long id, boolean checkHigherZero) {
        boolean flag = false;
        if (null == id)
            flag = true;

        if (!flag && checkHigherZero && id <= 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 检查int类型参数是否合法
     * 空：true ；非空：false
     * @param id
     * @param checkHigherZero
     * @return
     */
    public static boolean checkIntegerIsNull(Integer id, boolean checkHigherZero) {
        boolean flag = false;
        if (null == id)
            flag = true;

        if (!flag && checkHigherZero && id <= 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 过滤字符串前后多余分隔符
     * 
     * @param str
     * @param separator
     * @return 过滤后的字符串对象
     */
    public static String filterHeadAndTailSeparator(String str, String separator) {
        if (checkStringIsNotNull(str)) {
            while (str.startsWith(separator)) {
                str = str.substring(1);
            }
            while (str.endsWith(separator)) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    /**
     * 过滤重复分隔符
     * 
     * @param str
     * @param separator
     * @return 过滤后的字符串
     */
    public static String filterRepeatSeparator(String str, String separator) {
        StringBuffer strBuffer = new StringBuffer("");
        if (checkStringIsNotNull(str)) {
            String[] arr = str.split(separator);
            for (String s : arr) {
                if (checkStringIsNotNull(s)) {
                    strBuffer.append(separator).append(s);
                }
            }
            if (strBuffer.length() > 0) {
                strBuffer.deleteCharAt(0);
            }
        }
        return strBuffer.toString();
    }

    /**
     * 过滤数组重复字符串
     * 
     * @param arr
     * @return 过滤后的数组对象
     */
    public static String[] filterRepeatString(String[] arr) {
        String[] filterStrArr = null;
        if (null != arr && arr.length > 0) {
            List<String> list = new ArrayList<String>();
            for (String str : arr) {
                if (checkStringIsNotNull(str) && !list.contains(str)) {
                    list.add(str);
                }
            }
            filterStrArr = list.toArray(new String[list.size()]);
        }
        return filterStrArr;
    }

    /**
     * 过滤集合重复元素
     * 
     * @param list
     * @return 过滤后的list
     */
    public static List<String> filterListRepeat(List<String> list) {
        if (!CommonUtils.checkObjectIsNull(list)) {
            Iterator<String> itera = list.iterator();
            List<String> filterList = new ArrayList<String>();
            String val = "";
            while (itera.hasNext()) {
                val = itera.next();
                if (checkStringIsNotNull(val) && !filterList.contains(val)) {
                    filterList.add(val);
                }
            }
            return filterList;
        }
        return list;
    }

    /**
     * 校验座位号是否合法
     * @param seats
     * @return 合法：true 不合法：false
     */
    public static boolean checkSeatIfLegal(List<String> seats) {
        for (String seat : seats) {
            if (CommonUtils.checkStringIsNull(seat)) {
                return Boolean.FALSE;
            }
            if (!seat.matches("\\d{0,10}[a-zA-Z]{1,10}\\d{0,10}_\\d{1,10}$")) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * 检查字符串长度和非空
     * 空或长度大于指定长度则为false，其余返回true
     * @param str
     * @param length
     * @return Boolean 
     */
    public static Boolean checkStrLengthAndNull(String str, int length) {
        if (checkStringIsNull(str)) {
            return Boolean.FALSE;
        }
        if (str.length() > length) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 字符串日期格式转换为int类型
     * <p>日期格式：</p>
     * </ul>
     * <li>20160727</li>
     * <li>2016-07-27</li>
     * <li>2016/07/27</li>
     * <ul>
     * 
     */
    //TODO 建议移至toolkit中，在facade中严格要求不允许定义无关类
    public static int strDate2Int(String dateStr) {
        /**
         * 日期格式.
         */
        final Pattern DATA_PATTERN = Pattern
            .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))");

        int temp = 0;
        if (dateStr == null) {
            return temp;
        }

        final Matcher m = DATA_PATTERN.matcher(dateStr);
        if (!m.matches()) {
            return temp;
        }

        String tempDate = dateStr.replaceAll("[\\-\\/]", "");
        temp = Integer.parseInt(tempDate);
        return temp;
    }

    /**
     * 检查库存时间是否可以占座
     * @param stockTime
     * @return boolean
     */
    public static boolean checkStockTimeIsAvai(Integer stockTime) {
        Integer nowTime = getStockDateInteger(new Date());
        if (checkObjectIsNull(stockTime, nowTime) || stockTime.intValue() < nowTime.intValue()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /**
     * 将日期格式转换为库存需要处理的日期整形
     * 
     * @param date
     * @return
     */
    public static Integer getStockDateInteger(Date date) {
        if (!checkObjectIsNull(date)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int bmonth = calendar.get(Calendar.MONTH) + 1;
            int bday = calendar.get(Calendar.DAY_OF_MONTH);
            String monthStr = (bmonth < 10) ? "0" + bmonth : "" + bmonth;
            String dayStr = (bday < 10) ? "0" + bday : "" + bday;
            String timeStr = year + monthStr + dayStr;
            if (logger.isDebugEnabled()) {
                logger.debug("日期格式转换为字符串,timeStr:{}", timeStr);
            }
            return Integer.parseInt(timeStr);
        }
        return null;
    }

    /**
     * 检查查询库存时间格式是否合法
     * @param stockTime
     * @return
     */
    public static String checkStockTime(String stockTime) {
        if (checkStringIsNotNull(stockTime)) {
            if (!stockTime.matches("^\\d{4}[-/_]?\\d{2}[-/_]?\\d{2}$")) {
                throw new QueryStockDateIllegalException(StockExceptionCode.STOCK_QUERY_DATE_ILLEGAL_ERR_MSG);
            } else {
                Pattern p = Pattern.compile("[-/_]");
                Matcher m = p.matcher(stockTime);
                stockTime = m.replaceAll("");
            }
        } else {
            throw new QueryStockDateIllegalException(StockExceptionCode.STOCK_QUERY_DATE_ILLEGAL_ERR_MSG);
        }
        return stockTime;
    }

    /**
     * 整形转日期类型
     * @param stockTime
     * @return
     * @throws ParseException
     */
    public static Date IntegerConvertDate(Integer stockTime) throws ParseException {
        if (!checkIntegerIsNull(stockTime, true)) {

            String datestr = stockTime.toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date strToDate = sdf.parse(datestr);
            return strToDate;

        }
        return null;
    }

    /**
     * 场次时间整形转成四位字符串格式
     * @param screeningsTime
     * @return
     */
    public static String screeningsTimeConvert(Integer screeningsTime) {
        if (!checkIntegerIsNull(screeningsTime, true)) {
            StringBuffer screenigsTimeBuffer = new StringBuffer(screeningsTime.toString());
            while (screenigsTimeBuffer.length() < 4) {
                screenigsTimeBuffer.insert(0, "0");
            }
            return screenigsTimeBuffer.toString();
        }
        return null;
    }

    /**
     * 校验场次时间
     * @param screeningsTime
     * @return
     */
    public static boolean checkScreeningsTime(String screeningsTime) {
        if (checkStringIsNotNull(screeningsTime) && screeningsTime.matches("^\\d{0,4}$")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 将字符串转换成整形
     * @param str
     * @return
     */
    public static Integer convertStringToInteger(String str) {
        if (checkStringIsNotNull(str) && str.matches("^\\d+$")) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    /**
     * 判断字符串是否是数值类型
     * @param str
     * @return 是数值：true;不是数值：false
     */
    public static Boolean judgeStringIsNum(String str) {
        if (checkStringIsNotNull(str) && str.matches("^\\d+$")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 检查字符串长度是否超出最大长度
     * @param len
     * @param strs
     * @return 未超出最大长度：true；超出最大长度：false
     */
    public static Boolean checkStringLen(int len, String... strs) {
        if (null == strs || strs.length == 0) {
            return Boolean.TRUE;
        }
        for (String str : strs) {
            str = str.trim();
            return str.matches("^[\\d\\D]{0," + len + "}$") ? Boolean.TRUE : Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 获取最小日期
     * @param dateList
     * @return Date
     */
    public static Date getMinDate(List<Date> dateList) {
        if (!checkObjectIsNull(dateList)) {
            Date minDate = null;
            for (Date date : dateList) {
                if (null == date) {
                    continue;
                }
                if (null == minDate) {
                    minDate = date;
                }
                long minDateLong = minDate.getTime();
                long curDateLong = date.getTime();
                if (curDateLong < minDateLong) {
                    minDate = date;
                }
            }
            return minDate;
        }
        return null;
    }

    /**
     * 检查生成库存最小时间是否小于当前时间
     * @param minDate
     * @return boolean 小于 false；大于 true
     */
    public static boolean checkStockMinTime(Date minDate) {
        boolean flag = true;
        if (!checkObjectIsNull(minDate)) {
            long minDateLong = minDate.getTime();
            long curDateLong = new Date().getTime();
            if (curDateLong > minDateLong) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 获取最大日期
     * @param dateList
     * @return Date
     */
    public static Date getMaxDate(List<Date> dateList) {
        if (!checkCollectionIsNull(dateList)) {
            Date maxDate = null;
            for (Date date : dateList) {
                if (null == date) {
                    continue;
                }
                if (null == maxDate) {
                    maxDate = date;
                }
                long maxDateLong = maxDate.getTime();
                long curDateLong = date.getTime();
                if (curDateLong > maxDateLong) {
                    maxDate = date;
                }
            }
            return maxDate;
        }
        return null;
    }

    /**
     * 获取两个日期相隔天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDateDiffDay(Date startDate, Date endDate) {
        if (!checkObjectIsNull(startDate, endDate) && startDate.getTime() < endDate.getTime()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            try {
                startDate = sdf.parse(sdf.format(startDate));
                endDate = sdf.parse(sdf.format(endDate));
            } catch (Exception e) {
                logger.error("获取两个日期相隔天数转换日期格式异常", e);
                throw new StockException(StockExceptionCode.STOCK_ERR_MSG);
            }
            Long startDateLong = startDate.getTime();
            Long endDateLong = endDate.getTime();

            long dayLong = 86400000; //(24 * 60 * 60 * 1000)
            long diffDay = (endDateLong - startDateLong) / dayLong;
            if (logger.isDebugEnabled()) {
                logger.debug("startDate:{},endDate:{} 相隔天数:{}", startDate, endDate, diffDay);
            }
            return diffDay;
        }
        return null;
    }

    /**
     * 处理日期添加指定天后的整形时间
     * @param date
     * @param addDay
     * @return Integer
     */
    public static Integer dateAddDay(Date date, Integer addDay) {
        if (!checkObjectIsNull(date, addDay)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, addDay);

            Integer addDayInt = getStockDateInteger(calendar.getTime());
            if (logger.isDebugEnabled()) {
                logger.debug("dateAddDay date:{},addDayInt:{} ", date, addDayInt);
            }
            return addDayInt;
        }
        return null;
    }

    /**
     * 日期添加指定月份后的最终日期整形格式
     * @param date
     * @param addMonth
     * @return Integer
     */
    public static Integer dateAddMonthMaxDay(Date date, Integer addMonth) {
        if (!checkObjectIsNull(date, addMonth)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, addMonth);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Integer addMonthInt = getStockDateInteger(calendar.getTime());
            if (logger.isDebugEnabled()) {
                logger.debug("dateAddMonth date:{},addMonthInt:{} ", date, addMonthInt);
            }
            return addMonthInt;
        }
        return null;
    }

    /**
     * 获取日期添加指定月份后的每天日期整形格式
     * @param date
     * @param addMonth
     * @return Integer[] 整形格式：20160101
     */
    public static Integer[] dateAddMonthDayArr(Date date, Integer addMonth) {
        if (!checkObjectIsNull(date, addMonth)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, addMonth);
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            Date endDate = calendar.getTime();

            Long diffDay = getDateDiffDay(date, endDate);
            if (checkLongIsNull(diffDay, true)) {
                return null;
            }

            int iteraNum = Integer.parseInt(diffDay.toString()) + 1;
            calendar.setTime(date);
            int count = 0;
            Integer[] retDayArr = new Integer[iteraNum];
            while (count < iteraNum) {
                if (count > 0) {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }
                Integer addDayInt = getStockDateInteger(calendar.getTime());
                retDayArr[count++] = addDayInt;
            }

            if (logger.isDebugEnabled()) {
                logger.debug("dateAddMonthDayArr date:{},returnDay:{} ", date, retDayArr);
            }
            return retDayArr;
        }
        return null;
    }

    public static Integer[] dateBetween(Date sDate, Date eDate) {
        if (!checkObjectIsNull(sDate, eDate)) {
            return new Integer[] { 1 };
        }
        return null;
    }

    /**
     * 
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("------ppp-------" + CommonUtils.checkStringIsNotNull("  a", ""));
        //        String date1 = "2016-09-13";
        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //        Date sDate = sdf.parse(date1);
        //        Integer[] retIntArr = dateAddMonthDayArr(sDate, 3);
        //        if (null != retIntArr && retIntArr.length > 0) {
        //            for (Integer retint : retIntArr) {
        //                System.out.println("日期整形格式：" + retint);
        //            }
        //        }
        //
        //        Integer threeMonthMaxDay = CommonUtils.dateAddMonthMaxDay(sDate, 3);
        //        System.out.println("3个月后的日期：" + threeMonthMaxDay);
        //        Date now = new Date();
        //        Integer addMonthDate = dateAddMonth(sDate, 2);
        //        System.out.println("3个月后的日期：" + addMonthDate);
        //        Long day = getDateDiffDay(now, addMonthDate) - 1;
        //        System.out.println("相差天数：" + day);
        //        System.out.println("添加指定天后的时间：" + dateAddDay(now, 92));
        //        String date1 = "20160809";
        //        String date2 = "20160812";
        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //        Date sDate = sdf.parse(date1);
        //        Date eDate = sdf.parse(date2);
        //        Long day = CommonUtils.getDateDiffDay(sDate, eDate);
        //        List<Date> startDateList = new ArrayList<Date>();
        //        List<Date> endDateList = new ArrayList<Date>();
        //        String date1 = "20160809";
        //        String date2 = "20150808";
        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //        endDateList.add(sdf.parse(date1));
        //        endDateList.add(sdf.parse(date2));
        //        System.out.println("date1=" + date1 + ";;;date2=" + date2);
        //        Date minDate = CommonUtils.getMinDate(startDateList);
        //        Date maxDate = CommonUtils.getMaxDate(endDateList);
        //
        //        System.out.println("minDate========" + minDate);
        //        System.out.println("maxDate========" + maxDate);
        //        String screeningsTime = "01245";
        //        System.out.println(CommonUtils.checkStringLen(16, screeningsTime, "null"));
        //        System.out.println(CommonUtils.checkStockTime(screeningsTime));
        //        try {
        //            CommonUtils.IntegerConvertDate(20160619);
        //        } catch (ParseException e) {
        //            e.printStackTrace();
        //        }

        //        String time = "2016_0712";
        //        CommonUtils.checkStockTime("2016_0712");
        //        System.out.println("main-----" + time);

        //        CommonUtils.checkStockTimeIsAvai(20160712);

        //        String[] arr = new String[] { null, "A1_1", "A1_12", "A1_1", "A1_1" };
        //        String[] filterArr = CommonUtils.filterRepeatString(arr);
        //        for (String str : filterArr) {
        //            System.out.println("str===" + str);
        //        }

        //        List<String> list = new ArrayList<String>();
        //        list.add(null);
        //        list.add("A1_1");
        //        list.add("A1_12");
        //        list.add("A1_1");

        //        list = filterListRepeat(list);
        //        System.out.println(Check.NuNCollections(list));
        //        for (String str : list) {
        //            System.out.println(str);
        //        }
    }
}
