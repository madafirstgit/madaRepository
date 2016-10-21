package com.pzj.util.app;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.pzj.app.vo.AppMessageVO;
import com.pzj.base.entity.app.AppMessage;

public class AppMessageConvertUtil {

    public static AppMessage convert2Entity(AppMessageVO vo) {
        AppMessage entity = new AppMessage();
        try {
            BeanUtils.copyProperties(entity, vo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static AppMessageVO convert2VO(AppMessage entity) {
        AppMessageVO vo = new AppMessageVO();
        try {
            BeanUtils.copyProperties(vo, entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return vo;
    }
}
