package com.pzj.util.app;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.pzj.app.vo.AppEquipmentVO;
import com.pzj.base.entity.app.AppEquipment;

public class AppEquipmentConvertUtil {
    public static AppEquipment convert2Entity(AppEquipmentVO vo) {
        AppEquipment entity = new AppEquipment();

        try {
            BeanUtils.copyProperties(entity, vo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static AppEquipmentVO convert2VO(AppEquipment entity) {
        AppEquipmentVO vo = new AppEquipmentVO();

        try {
            BeanUtils.copyProperties(vo, entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return vo;
    }
}
