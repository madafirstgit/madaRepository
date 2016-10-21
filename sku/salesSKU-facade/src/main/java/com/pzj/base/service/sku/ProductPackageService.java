package com.pzj.base.service.sku;

import java.util.List;

import com.pzj.base.entity.sku.XzSkuPkgAttrMappingDto;
import com.pzj.base.entity.sku.XzSkuPkgDto;

/**
 * @author zhengxw
 */
public interface ProductPackageService {
    /**
     * 查询打包产品
     * 编号0706
     * @param bossid
     * @return
     */
    List<XzSkuPkgDto> queryListSkuPkgByBossid(int bossid);

    /**
     * 查询产品的打包
     * 编号0707
     * @param skuId
     * @return
     */
    List<XzSkuPkgDto> queryListSkuPkg(int skuId);

    /**
     * 查询产品的打包属性映射
     * 编号0708
     * @param skuId
     * @return
     */
    List<XzSkuPkgAttrMappingDto> queryListSkuPkgAttrMapping(int skuId);

    /**
     * 保存打包产品
     * 编号0709
     * @param xzSkuPkgDto
     * @return
     */
    XzSkuPkgDto saveSkuPkg(XzSkuPkgDto xzSkuPkgDto);

    /**
     * 保存打包产品属性映射
     * 编号0710
     * @param xzSkuPkgAttrMappingDto
     * @return
     */
    XzSkuPkgAttrMappingDto saveSkuPkgAttrMapping(XzSkuPkgAttrMappingDto xzSkuPkgAttrMappingDto);

    /**
     * 修改打包产品，关联修改XZ_SKU_PKG_ATTR_MAPPING
     * 编码0712
     * @param xzSkuPkgDto
     * @return
     */
    XzSkuPkgDto updateSkuPkg(XzSkuPkgDto xzSkuPkgDto);

    /**
     * 删除打包产品，关联删除XZ_SKU_PKG_ATTR_MAPPING
     * 编码0713
     * @param bossid
     * @param id
     * @return
     */
    boolean deleteSkuPkg(int bossid, int id);

    /**
     * 查询产品包
     * 编码0716
     * @param id
     * @return
     */
    XzSkuPkgDto querySkuPkg(int id);

    /**
     * 修改产品的父子分组类型
     * 编号0717
     * @param skuIds    产品ID
     * @param bossid 公司ID
     * @param value    值 SkuProductPackage.code
     * @return
     */
    int updateSkuParentChild(int[] skuIds, int bossid, String value);

    /**
     * 查询被打包产品
     * 编码0718
     * @param bossid
     * @param packageSkuId
     * @return
     */
    List<XzSkuPkgDto> queryListSkuPkgByPkgSkuid(int bossid, int packageSkuId);
}
