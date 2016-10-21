package com.pzj.base.service.sku;

import java.util.List;

import com.pzj.base.entity.sku.XzSkuAttrApplyToDto;
import com.pzj.base.entity.sku.XzSkuAttrDto;

/**
 * @author zhengxw
 */
public interface ProductAttrService {
    /**
     * 查询参数，XZ_SKU_ATTR,XZ_SKU_ATTR_I18N
     * 编号0201
     * @param bossid
     * @param language
     * @return
     */
    List<XzSkuAttrDto> queryListAttr(int bossid, String language);

    /**
     * 查询参数，XZ_SKU_ATTR,XZ_SKU_ATTR_I18N
     * 编号0202
     * @param ids
     * @param language
     * @return
     */
    List<XzSkuAttrDto> queryListAttr(int[] ids, String language);

    /**
     * 查询参数
     * 编号0203
     * @param id
     * @return
     */
    XzSkuAttrDto queryAttr(int id);

    /**
     * 新增参数
     * 编号0204
     * @return
     */
    XzSkuAttrDto saveAttr(XzSkuAttrDto xzSkuAttrDto);

    /**
     * 修改参数
     * 编号0205
     * @param xzSkuAttrDto
     * @return
     */
    XzSkuAttrDto updateAttrById(XzSkuAttrDto xzSkuAttrDto);

    /**
     * 查询产品的参数
     * 编号0206
     * @param skuId 产品ID
     * @param language 语言
     * @return
     */
    List<XzSkuAttrApplyToDto> queryListAttrApplyTo(int skuId, String language);

    /**
     * 给产品添加参数
     * 编号0207
     * @param bossid    公司ID
     * @param skuId     产品ID
     * @param attrId    参数ID 数组
     * @return
     */
    boolean skuAttachAttr(int bossid, int skuId, int[] attrId);

    /**
     * 删除产品参数
     * 编号0208
     * @param bossid    公司ID
     * @param skuId     产品ID
     * @param attrId    参数ID
     * @return
     */
    boolean skuDetachAttr(int bossid, int skuId, int attrId);

    /**
     * 查询产品没有的参数
     * 编号0209
     * @param skuId
     * @param bossid
     * @param language
     * @return
     */
    List<XzSkuAttrDto> queryListAttrNotInSku(int skuId, int bossid, String language);

    /**
     * 查询产品参数个数
     * 编号0210
     * @param skuId
     * @return
     */
    int querySkuAttrApplyToCount(int skuId);

    /**
     * 保存产品参数
     * 编号0211
     * @param xzSkuAttrApplyToDto
     * @return
     */
    XzSkuAttrApplyToDto saveSkuAttrApplyDto(XzSkuAttrApplyToDto xzSkuAttrApplyToDto);

    /**
     * 查询参数个数
     * 编号0212
     * @param bossid
     * @return
     */
    int querySkuAttrCount(int bossid);
}
