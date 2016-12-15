package com.hht.mapper;

import com.hht.models.BShopVersion;
import org.apache.ibatis.annotations.Param;

public interface BShopVersionMapper {
 
    int deleteByPrimaryKey(String id);

 
    int insert(BShopVersion record);

 
    int insertSelective(BShopVersion record);

 
    BShopVersion selectByPrimaryKey();

    BShopVersion selectAllVersion();

 
    int updateByPrimaryKeySelective(BShopVersion record);

 
    int updateByPrimaryKey(BShopVersion record);

    /**
     * 根据门店ID和租户ID查询总部版本号
     * @param tenantId
     * @param shopId
     * @return
     */
    BShopVersion selectByTenantIdAndShopId(@Param("tenantId") String tenantId, @Param("shopId") String shopId);
}