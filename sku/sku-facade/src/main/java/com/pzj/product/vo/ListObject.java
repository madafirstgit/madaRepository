package com.pzj.product.vo;

import java.util.List;

/**
 * Created by Administrator on 2016-8-25.
 */
public interface ListObject<T> {
    List<T> dataList();
    void dataList(List<T> dataList);
}
