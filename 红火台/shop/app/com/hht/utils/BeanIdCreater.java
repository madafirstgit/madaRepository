package com.hht.utils;

import java.util.HashMap;

/**
 * Created by mada on 2016/12/12.
 */
public class BeanIdCreater {

    private static HashMap<String,IDGenerater> beanMap;

    /* 获取实例 */
    public IDGenerater getBeanIdCreater(String beanName) {
        if(beanMap.get(beanName) !=null){
            return beanMap.get(beanName);
        } else {
            beanMap.put(beanName,new IDGenerater());
            return beanMap.get(beanName);
        }
    }
    /* 私有构造方法，防止被实例化 */
    private BeanIdCreater() {
        beanMap = new HashMap<String,IDGenerater>();
    }

    /* 此处使用一个内部类来维护单例 */
    private static class BeanIdCreaterFactory {
        private static BeanIdCreater instance = new BeanIdCreater();
    }

    /* 获取实例 */
    public static BeanIdCreater getInstance() {
        return BeanIdCreaterFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
