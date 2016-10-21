package com.pzj.base.service.sku;

import java.util.List;

import com.pzj.base.entity.json.Page;
import com.pzj.base.entity.sku.XzSkuPriceBaseDto;
import com.pzj.base.entity.sku.XzSkuPriceEventApplyToDto;
import com.pzj.base.entity.sku.XzSkuPriceEventDto;
import com.pzj.base.entity.sku.XzSkuPriceEventNewPriceDto;
import com.pzj.base.entity.sku.XzSkuPriceEventRulesDto;

/**
 * @author zhengxw
 */
public interface ProductPriceService {
    /**
     * 查询产品的价格，关联查询参数
     * 服务编号0401
     * @param skuId
     * @param lanuage
     * @return
     */
    List<XzSkuPriceBaseDto> queryListPrice(int skuId, String lanuage);

    /**
     * 查询价格事件
     * 编号0402
     * @param bossid
     * @return
     */
    List<XzSkuPriceEventDto> queryListPriceEvent(int bossid);

    /**
     * 查询价格事件
     * 编号0403
     * @param bossid
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<XzSkuPriceEventDto> queryPagePriceEvent(int bossid, int pageNo, int pageSize);

    /**
     * 查询价格事件
     * 编号0404
     * @param id
     * @return
     */
    XzSkuPriceEventDto queryPriceEvent(int id);

    /**
     * 查询产品的价格事件，XZ_SKU_PRICE_EVENT XZ_SKU_PRICE_APPLAY_TO XZ_SKU_PRICE_EVENT_NEW_PRICE
     * 编号0405
     * @param skuId
     * @return
     */
    List<XzSkuPriceEventApplyToDto> queryListPriceEventApplyTo(int skuId);

    /**
     * 新增价格事件
     * 编号0406
     * @param xzSkuPriceEventDto
     * @return
     */
    XzSkuPriceEventDto savePriceEvent(XzSkuPriceEventDto xzSkuPriceEventDto);

    /**
     * 修改价格事件
     * 编号0407
     * @return xzSkuPriceEventDto
     */
    XzSkuPriceEventDto updatePriceEventById(XzSkuPriceEventDto xzSkuPriceEventDto);

    /**
     * 价格事件规则
     * 编号0408
     * @param bossid
     * @return
     */
    List<XzSkuPriceEventRulesDto> queryListPriceEventRules(int bossid);

    /**
     * 保存价格事件规则
     * 编号0409
     * @param xzSkuPriceEventRulesDto
     * @return
     */
    XzSkuPriceEventRulesDto savePriceEventRules(XzSkuPriceEventRulesDto xzSkuPriceEventRulesDto);

    /**
     * 修改价格事件规则
     * 编号0410
     * @param xzSkuPriceEventRulesDto
     * @return
     */
    XzSkuPriceEventRulesDto updatePriceEventRulesById(XzSkuPriceEventRulesDto xzSkuPriceEventRulesDto);

    /**
     * 查询价格事件规则
     * 编号0411
     * @param id
     * @return
     */
    XzSkuPriceEventRulesDto queryPriceEventRules(int id);

    /**
     * 产品添加价格
     * 编号0412
     * @param bossid
     * @param skuId
     * @param attrId
     * @return
     */
    boolean skuAttachAttrPrice(int bossid, int skuId, int[] attrId);

    /**
     * 删除产品价格
     * 编号0413
     * @param skuId
     * @param attrId
     * @return
     */
    boolean skuDetachAttrPrice(int bossid, int skuId, int attrId);

    /**
     * 删除事件规则
     * 编号0414
     * @param bossid
     * @param rulesId
     * @return
     */
    boolean delPriceEventRules(int bossid, int rulesId);

    /**
     * 查询价格事件的新价格，XZ_SKU_PRICE_EVENT_NEW_PRICE
     * 编号0415
     * @param bossid
     * @param skuId
     * @return
     */
    List<XzSkuPriceEventNewPriceDto> queryListPriceEventNewPrice(int bossid, int skuId);

    /**
     * 编号0416
     * ----新增或修改---- 价格事件的新价格，XZ_SKU_PRICE_EVENT_NEW_PRICE
     * @param xzSkuPriceEventNewPriceDtoList
     * @return
     */
    List<XzSkuPriceEventNewPriceDto> saveListPriceEventNewPrice(List<XzSkuPriceEventNewPriceDto> xzSkuPriceEventNewPriceDtoList);

    /**
     * 新增产品价格事件
     * 编码0417
     * @param xzSkuPriceEventApplyToDto
     * @return
     */
    XzSkuPriceEventApplyToDto savePriceEventApplyTo(XzSkuPriceEventApplyToDto xzSkuPriceEventApplyToDto);

}