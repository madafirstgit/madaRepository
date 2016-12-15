/*
 * SysObjectDictRelationMapper.java
 
 * www.piaozhijia.coim
 */
package com.pzj.dao;

import java.util.List;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.common.SysObjectDictRelationChild;

/**
 * Mapper接口.区域
 * 
 * @author 票之家
 */
@MyBatisDao
public interface ISysObjectDictRelationMapper extends BaseMapper<SysObjectDictRelationChild> {
    /**
     * 按条件批量删除关系
     * 
     * @param deleteParam
     *            关系实体列表
     * @return 删除条数
     */
    int deleteBatchSelective(List<SysObjectDictRelation> deleteParam);

}
