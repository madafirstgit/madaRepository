package com.pzj.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.service.sys.ISysUserRelationService;
import com.pzj.customer.entity.CustomerRelation;

@Service
public class CustomerRelationServiceImpl implements CustomerRelationService {

    @Autowired
    private ISysUserRelationService sysUserRelationService;

    @Override
    public void insertBatch(Long userId, List<Long> relIdList, String relType) {
        if (userId == null || relIdList == null || StringUtils.isEmpty(relType)) {
            return;
        }

        List<SysUserRelation> relList = new ArrayList<>(relIdList.size());

        for (Long relId : relIdList) {
            SysUserRelation rel = new SysUserRelation();
            rel.setUserId(userId);
            rel.setRelUserId(relId);
            rel.setRelType(relType);

            relList.add(rel);
        }
        sysUserRelationService.insertBatch(relList);
    }

    @Override
    public void deleteBatch(Long userId, List<Long> relIdList, String relType) {
        if (userId == null || relIdList == null || StringUtils.isEmpty(relType)) {
            return;
        }

        List<SysUserRelation> relList = new ArrayList<>(relIdList.size());

        for (Long relId : relIdList) {
            SysUserRelation rel = new SysUserRelation();
            rel.setUserId(userId);
            rel.setRelUserId(relId);
            rel.setRelType(relType);

            relList.add(rel);
        }
        sysUserRelationService.delAuthBatch(relList);
    }

    public PageList<CustomerRelation> queryPageByParamMap(PageModel pager, CustomerRelation vo) throws Exception {
        PageList<SysUserRelation> userRelList = sysUserRelationService.queryAuthPageByParamMap(pager, CustomerRelationUtil.convert2Entity(vo));

        PageList<CustomerRelation> resultList = new PageList<>();

        resultList.setPageBean(userRelList.getPageBean());

        if (userRelList.getResultList() != null) {
            List<CustomerRelation> voList = CustomerRelationUtil.convert2VoList(userRelList.getResultList());
            resultList.setResultList(voList);
        }

        return resultList;
    }

}
