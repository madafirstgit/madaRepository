package com.pzj.base.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysRebateStrategy;
import com.pzj.common.QueryPageModel;

@MyBatisDao
public interface IRebateStrategySearchMapper {

    List<SysRebateStrategy> queryByParamMap(@Param("bParam") SysRebateStrategy params,
                                            @Param("pParam") QueryPageModel pageModel);

}