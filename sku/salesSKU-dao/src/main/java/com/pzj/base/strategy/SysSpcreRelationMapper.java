package com.pzj.base.strategy;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.common.QueryPageModel;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface SysSpcreRelationMapper {

	List<SysSpcreRelationKey> selectByParam(@Param("space") SysSpcreRelationKey param,@Param("page") QueryPageModel queryPageModel);

	int countByParam(@Param("space") SysSpcreRelationKey param);

	List<SysSpcreRelationKey> selectByChannelAndInfoId(@Param("productInfoId") Long productInfoId, @Param("channelId") Long channelId);
}
