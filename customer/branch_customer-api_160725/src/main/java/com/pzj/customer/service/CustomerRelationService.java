package com.pzj.customer.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.customer.entity.CustomerRelation;

public interface CustomerRelationService {
    /**
     * 批量新增,修改也用这个接口 每次保存前会根据userId和relType删除以前的数据 关联类型（1供应商关系，2常用部门）
     * 
     */
    public void insertBatch(Long userId, List<Long> relIdList, String relType);

    /**
     * 
     * @param userId
     * @param relId
     * @param relType
     */
    public void deleteBatch(Long userId, List<Long> relId, String relType);

    public PageList<CustomerRelation> queryPageByParamMap(PageModel pager,
            CustomerRelation vo) throws Exception;
}
