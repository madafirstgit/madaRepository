package com.pzj.base.common.objectDict;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseService;

public abstract interface BaseObjectDictRelationService<T extends BaseEntity> extends BaseService<T> {

    /**
     * 新建或更新实体的多选数据字典关系集
     * 
     * @param entityList
     * @return
     */
    Integer updateObjectDictReltionForBean(List<T> entityList);
    
    
    public void setObjectDictReltionQueryParam(Map<String, Object> queryParam,
			T entity);

}
