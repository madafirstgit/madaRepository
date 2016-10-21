package com.pzj.base.service.sku;

import java.util.List;
import java.util.Map;

import com.pzj.base.entity.json.CommonResult;
import com.pzj.base.entity.json.Page;
import com.pzj.base.entity.sku.SkuQueryDto;
import com.pzj.base.entity.sku.XzSkuDto;
import com.pzj.base.entity.sku.XzSkuImageDto;

/**
 * @author zhengxw
 */
public interface ProductService {

    /**
     * 查询产品，包括各关联表数据
     * 编号0101
     * @param id
     * @param language XZ_SKU_I18N.language编号
     * @return
     */
    XzSkuDto querySku(int id, String language);

    /**
     * 产品列表，只查 XZ_SKU,XZ_SKU_I18N 数据
     * 编号0102
     * @param status 状态 XZ_SKU
     * @param categoryId 分类 XZ_SKU
     * @param keyword 关键字，查询XZ_SKU 外部编码, XZ_SKU_I18N 标题
     * @param language XZ_SKU_I18N。language
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<SkuQueryDto> queryPageSku(int bossid, Integer status, int categoryId, String keyword,
                                   String language, int pageNo, int pageSize);

    /**
     * 产品列表
     * 编号0103
     * @param bossid
     * @param language
     * @return
     */
    List<XzSkuDto> queryListSku(int bossid, String language);

    /**
     * 新增XZ_SKU，包括关联表
     * 编号0104
     * @param xzSkuDto
     * @return
     */
    XzSkuDto saveSku(XzSkuDto xzSkuDto);

    /**
     * 修改产品，xzSkuI18nDto修改，xzSkuImageDtos不动，xzSkuAllocationDto修改，
     * xzSkuAllocationDto.xzSkuAllocationTimeslotDtos删除（删除全部=skuId）再新增
     * xzSkuAttrApplyToDtos修改，xzSkuAttrApplyToDtos.xzSkuAttrDto不动，xzSkuPriceBaseDtos新增、修改，
     * xzSkuPriceBaseDtos.xzSkuAttrDto不动，xzSkuPriceEventApplyToDtos不动，xzSkuPriceEventNewPriceDtos不动
     * xzSkuPkgDtos新增
     * 编号0105
     * @param xzSkuDto
     * @return
     */
    XzSkuDto updateSku(XzSkuDto xzSkuDto);

    /**
     * 查询产品列表，不包括当前ID产品，查询 XZ_SKU,XZ_SKU_I18N
     * 编号0111
     * @param bossid
     * @param language
     * @param keyword
     * @param skuId
     * @return
     */
    List<SkuQueryDto> queryListSku(int bossid, String language, String keyword, int skuId);

    /**
     * 保存产品图片
     * 编码0114
     * @param imageDto
     * @return
     */
    XzSkuImageDto saveSkuImage(XzSkuImageDto imageDto);

    /**
     * 删除图片
     * 编码0115
     * @param bossid
     * @param id
     * @return
     */
    boolean deleteSkuImage(int bossid, int id);

    /**
     * 修改图片，where ID AND BOSSID
     * 编码0117
     * @param imageDto
     * @return
     */
    XzSkuImageDto updateSkuImage(XzSkuImageDto imageDto);

    /**
     * 查询产品图片数量
     * 编码0117
     * @param skuId
     * @return
     */
    int querySkuImageCount(int skuId);

    /**
     * 批量插入
     * 编码0118
     * @param list 实体集合
     * @return Boolean(成功 为true)
     */
    CommonResult insertBatch(Map<String, Object> map);

}
