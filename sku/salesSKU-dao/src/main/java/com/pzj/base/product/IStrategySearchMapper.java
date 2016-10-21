/*
 * ProductTicketInfoMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.SysSpcreRelationKey;

/**
 * 产品信息
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IStrategySearchMapper {

    /**
       * 根据（渠道产品）关系表对象的相关信息查询对象列表
       * @param key 渠道产品对象 
       * @return
       */
    List<SysLabelRelationKey> selectLabelRelationByParam(@Param("bParam") SysLabelRelationKey bParam);

    /**
     * 根据渠道查询参数查询渠道集合
     * @param bParam
     * @return
     */
    List<SysChannel> selectChannelByParam(@Param("bParam") SysChannel bParam);

    /**
    * 根据政策查询参数查询政策集合
    * @param bParam
    * @return
    */
    List<SysChannelStrategy> selectStratgyByParam(@Param("bParam") SysChannelStrategy bParam);

    /**
    * 查询产品渠道政策关系集合
    * @param bParam
    * @return
    */
    List<SysSpcreRelationKey> selectSpcreByParam(@Param("space") SysSpcreRelationKey bParam);

    /**
     * 根据政策、SysSpcreRelationKey查询参数查询政策集合
     * @param strategy
     * @param space
     * @return
     */
    List<SysChannelStrategy> selectStratgyBySpace(@Param("bParam") SysChannelStrategy strategy, @Param("space") SysSpcreRelationKey space);


}