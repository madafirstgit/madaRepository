/*
 * SysObjectDictRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.common.SysObjectDictRelationChild;
import com.pzj.base.service.sys.ISysObjectDictRelationService;
import com.pzj.dao.ISysObjectDictRelationMapper;

/**
 * service接口实现.区域
 * 
 * @author 票之家
 */
@Service
public class SysObjectDictRelationServiceImpl extends BaseServiceImpl<SysObjectDictRelationChild, ISysObjectDictRelationMapper> implements ISysObjectDictRelationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public int updateBatch(List<SysObjectDictRelation> updateDictRelation) {
        int result = 0;
        if (updateDictRelation == null || updateDictRelation.isEmpty()) {
            logger.info("SysObjectDictRelationService:updateBatch,参数updateDictRelation列表为null，不做处理");
            return result;
        }

        // 1.按照baseDeleteParam参数，先删除库里的数据
        result += deleteBatchSelective(updateDictRelation);

        // 2.新建最新的字典对应关系数据集
        List<SysObjectDictRelationChild> childList = SysObjectDictRelation.getAllChildList(updateDictRelation);

        Long insertResult = insertBatch(childList);

        if (insertResult != null) {
            result += new BigDecimal(insertResult).intValue();
        }

        return result;
    }

    public int deleteBatchSelective(List<SysObjectDictRelation> dictRelation) {
        return mapper.deleteBatchSelective(dictRelation);
    }

}
