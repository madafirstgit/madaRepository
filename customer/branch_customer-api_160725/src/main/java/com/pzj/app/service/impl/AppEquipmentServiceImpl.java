package com.pzj.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.app.service.AppEquipmentService;
import com.pzj.app.vo.AppEquipmentVO;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.app.AppEquipment;
import com.pzj.base.service.sys.app.IAppEquipmentService;
import com.pzj.util.app.AppEquipmentConvertUtil;

@Service
public class AppEquipmentServiceImpl implements AppEquipmentService {

    @Autowired
    private IAppEquipmentService appEquipmentService;

    @Override
    public Long create(AppEquipmentVO vo) throws Exception {

        return appEquipmentService.insert(AppEquipmentConvertUtil
                .convert2Entity(vo));
    }

    @Override
    public Integer update(AppEquipmentVO vo) throws Exception {
        return appEquipmentService.updateByPrimaryKey(AppEquipmentConvertUtil
                .convert2Entity(vo));
    }

    @Override
    public AppEquipmentVO getById(Long id) throws Exception {
        return AppEquipmentConvertUtil.convert2VO(appEquipmentService
                .getById(id));
    }

    @Override
    public PageList<AppEquipmentVO> queryPageByParamMap(PageModel pager,
            AppEquipmentVO vo) throws Exception {
        AppEquipment param = AppEquipmentConvertUtil.convert2Entity(vo);
        PageList<AppEquipment> pageList = appEquipmentService
                .queryPageByParamMap(pager, param);

        PageList<AppEquipmentVO> returnList = new PageList<AppEquipmentVO>();

        returnList.setPageBean(pageList.getPageBean());

        List<AppEquipmentVO> list = new ArrayList<AppEquipmentVO>();
        for (AppEquipment entity : pageList.getResultList()) {
            list.add(AppEquipmentConvertUtil.convert2VO(entity));
        }

        returnList.setResultList(list);

        return returnList;
    }

}
