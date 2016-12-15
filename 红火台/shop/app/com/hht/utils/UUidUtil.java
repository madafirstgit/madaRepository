package com.hht.utils;

import java.util.UUID;

/**
 * @author panghui
 * @version 1.0
 * @since 2016/11/18
 */
public class UUidUtil {

    /**
     * 生成全局唯一ID
     *
     * @return
     */
    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
