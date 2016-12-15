package com.hht.annotation;

/**
 * Created by Zhu Tao on 2016-11-18.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*暂时不用了，请别再调用此注释宏*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface Transaction {
}