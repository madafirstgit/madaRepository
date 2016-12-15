package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysSpcreRelationKey;

@MyBatisDao
public interface SysSpcreRelationMapper extends
		BaseRelationshipMapper<SysSpcreRelationKey> {

	List<SysSpcreRelationKey> findSpcreRelation(Map<String, Object> map);

	Integer findCouSpcreRelation(Map<String, Object> map);

	Integer updateByChannelStrategy(List<SysSpcreRelationKey> list);
}
