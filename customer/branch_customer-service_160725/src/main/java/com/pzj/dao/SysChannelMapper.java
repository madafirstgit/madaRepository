package com.pzj.dao;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysChannel;

@MyBatisDao
public interface SysChannelMapper extends BaseUserMapper<SysChannel> {

    List<SysChannel> findListByObjID(Map<String, Object> params);

    int countByObjID(Map<String, Object> params);

    List<SysChannel> findListByRefID(Map<String, Object> params);

    int countByRefID(Map<String, Object> params);

    List<SysChannel> findNotByProductID(Map<String, Object> params);

    int countNotByProductID(Map<String, Object> params);
    
    int countPageSingleTable(Map<String, Object> params);
    List<SysChannel> queryPageSingleTable(Map<String, Object> params);
}
