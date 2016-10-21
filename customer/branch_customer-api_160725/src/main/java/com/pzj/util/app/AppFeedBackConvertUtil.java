package com.pzj.util.app;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.pzj.app.vo.AppFeedbackVO;
import com.pzj.base.entity.app.AppFeedback;

public class AppFeedBackConvertUtil {

    public static AppFeedback convert2Entity(AppFeedbackVO vo) {
        AppFeedback entity = new AppFeedback();

        try {
            BeanUtils.copyProperties(entity, vo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static AppFeedbackVO convert2VO(AppFeedback entity) {
        AppFeedbackVO vo = new AppFeedbackVO();

        try {
            BeanUtils.copyProperties(vo, entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
