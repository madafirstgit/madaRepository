package com.pzj.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.app.service.AppMessageService;
import com.pzj.app.vo.AppMessageVO;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.app.AppMessage;
import com.pzj.base.service.sys.app.IAppMessageService;
import com.pzj.util.app.AppMessageConvertUtil;

@Service
public class AppMessageServiceImpl implements AppMessageService {

    @Autowired
    private IAppMessageService appMessageService;

    @Override
    public Long create(AppMessageVO vo) throws Exception {
        return appMessageService.insert(AppMessageConvertUtil
                .convert2Entity(vo));
    }

    @Override
    public Integer update(AppMessageVO vo) throws Exception {
        return appMessageService.updateByPrimaryKey(AppMessageConvertUtil
                .convert2Entity(vo));
    }

    @Override
    public AppMessageVO getById(Long id) throws Exception {
        return AppMessageConvertUtil.convert2VO(appMessageService.getById(id));
    }

    @Override
    public PageList<AppMessageVO> queryPageByParamMap(PageModel pager,
            AppMessageVO vo) throws Exception {

        AppMessage param = AppMessageConvertUtil.convert2Entity(vo);
        PageList<AppMessage> pageList = appMessageService.queryPageByParamMap(
                pager, param);

        PageList<AppMessageVO> returnList = new PageList<AppMessageVO>();

        returnList.setPageBean(pageList.getPageBean());

        List<AppMessageVO> list = new ArrayList<AppMessageVO>();
        for (AppMessage entity : pageList.getResultList()) {
            list.add(AppMessageConvertUtil.convert2VO(entity));
        }

        returnList.setResultList(list);

        return returnList;
    }

}
