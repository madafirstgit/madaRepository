/*
 * SysAreaService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.impl.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.SysArea;
import com.pzj.base.product.ISysAreaMapper;
import com.pzj.base.service.product.ISysAreaService;

/**
 * service接口实现.区域
 * 
 * @author 票之家
 */
@Service
@Lazy
public class SysAreaServiceImpl extends BaseServiceImpl<SysArea, ISysAreaMapper>
                                implements ISysAreaService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

}
