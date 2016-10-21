/*
 * AppEquipmentService.java
 
 * www.piaozhijia.com
 */
package com.pzj.service.Impl.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.app.AppEquipment;
import com.pzj.base.service.sys.app.IAppEquipmentService;
import com.pzj.dao.app.IAppEquipmentMapper;

/**
 * service接口实现.人员设备
 * @author 票之家
 */
@Service
public class AppEquipmentServiceImpl  extends BaseServiceImpl<AppEquipment,IAppEquipmentMapper> implements IAppEquipmentService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//    @Autowired
//	private IAppEquipmentMapper appEquipmentMapper;
//	
//	@Override
//	public IAppEquipmentMapper getDefaulteMapper() {
//		return appEquipmentMapper;
//	}
 
}
