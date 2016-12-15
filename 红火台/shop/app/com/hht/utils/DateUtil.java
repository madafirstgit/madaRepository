package com.hht.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.logging.Level.parse;

/**
 * @author panghui
 * @version 1.0
 * @since 2016-11-21
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String dateFormat(Date date){
        return sdf.format(date);
    }

    public static Date StrToDate(String str) throws ParseException {
        return sdf.parse(str);
    }
}
