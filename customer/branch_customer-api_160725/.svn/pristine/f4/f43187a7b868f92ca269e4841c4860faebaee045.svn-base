package com.pzj.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.app.service.AppFeedbackService;
import com.pzj.app.vo.AppFeedbackVO;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.app.AppFeedback;
import com.pzj.base.service.sys.app.IAppFeedbackService;
import com.pzj.util.app.AppFeedBackConvertUtil;

@Service
public class AppFeedbackServiceImpl implements AppFeedbackService {

    @Autowired
    private IAppFeedbackService appFeedbackService;

    @Override
    public Long create(AppFeedbackVO vo) throws Exception {
        return appFeedbackService.insert(AppFeedBackConvertUtil
                .convert2Entity(vo));
    }

    @Override
    public Integer update(AppFeedbackVO vo) throws Exception {
        return appFeedbackService.updateByPrimaryKey(AppFeedBackConvertUtil
                .convert2Entity(vo));
    }

    @Override
    public AppFeedbackVO getById(Long id) throws Exception {
        return AppFeedBackConvertUtil
                .convert2VO(appFeedbackService.getById(id));
    }

    @Override
    public PageList<AppFeedbackVO> queryPageByParamMap(PageModel pager,
            AppFeedbackVO vo) throws Exception {
        AppFeedback param = AppFeedBackConvertUtil.convert2Entity(vo);
        PageList<AppFeedback> pageList = appFeedbackService
                .queryPageByParamMap(pager, param);

        PageList<AppFeedbackVO> returnList = new PageList<AppFeedbackVO>();

        returnList.setPageBean(pageList.getPageBean());

        List<AppFeedbackVO> list = new ArrayList<AppFeedbackVO>();
        for (AppFeedback entity : pageList.getResultList()) {
            list.add(AppFeedBackConvertUtil.convert2VO(entity));
        }

        returnList.setResultList(list);

        return returnList;
    }

}
