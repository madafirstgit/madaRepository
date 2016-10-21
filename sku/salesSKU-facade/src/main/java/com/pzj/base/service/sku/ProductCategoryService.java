package com.pzj.base.service.sku;

import java.util.List;

import com.pzj.base.entity.json.Page;
import com.pzj.base.entity.sku.XzSkuCategoryDto;

/**
 * @author zhengxw
 * 服务编码  95
 */
public interface ProductCategoryService {

    /**
     * 查询产品分类，XZ_SKU_CATEGORY
     * 方法编号0301
     * @param bossid 公司ID
     * @return
     */
    List<XzSkuCategoryDto> queryListCategory(int bossid);

    /**
     * 查询产品分类，XZ_SKU_CATEGORY
     * 方法编号0302
     * @param bossid
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<XzSkuCategoryDto> queryPageCategory(int bossid, int pageNo, int pageSize);

    /**
     * 查询分类
     * 编号0303
     * @param id
     * @return
     */
    XzSkuCategoryDto queryCategory(int id);

    /**
     * 新增分类， XZ_SKU_CATEGORY
     * 编号0304
     * @param dto
     * @return
     */
    XzSkuCategoryDto saveCategory(XzSkuCategoryDto dto) throws Exception;

    /**
     * 修改分类
     * 编号0305
     * @param xzSkuCategoryDto
     * @return
     */
    XzSkuCategoryDto updateCategoryById(XzSkuCategoryDto xzSkuCategoryDto);

    /**
     * 删除分类
     * 编号0306
     * @param bossid
     * @param categoryId
     * @return
     */
    boolean delCategory(int bossid, int categoryId);
}
