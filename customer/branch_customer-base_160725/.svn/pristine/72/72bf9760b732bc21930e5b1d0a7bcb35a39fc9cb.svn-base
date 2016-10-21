package com.pzj.base.common.objectDict.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.objectDict.BaseObjectDictRelationService;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.common.ObjectDictRelationParam;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.common.SysObjectDictRelationChild;
import com.pzj.base.service.sys.ISysObjectDictRelationService;

public abstract class BaseObjectDictRelationServiceImpl<T extends BaseEntity, E extends BaseMapper<T>> extends BaseServiceImpl<T, E> implements BaseObjectDictRelationService<T> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysObjectDictRelationService sysObjectDictRelationService;

    @Autowired
    protected E mapper;

    public Long insert(T entity) {
        super.insert(entity);

        // 新建或更新实体的多选数据字典的关系集
        updateObjectDictReltionForBean(entity);

        return entity.getId();
    }

    public Integer updateByPrimaryKey(T entity) {
        Integer num = super.updateByPrimaryKey(entity);

        // 新建或更新实体的多选数据字典的关系集
        updateObjectDictReltionForBean(entity);

        return num;
    }

    public Long insertOrUpdate(T entity) {
        super.insertOrUpdate(entity);

        // 新建或更新实体的多选数据字典的关系集
        updateObjectDictReltionForBean(entity);

        return entity.getId();
    }

    public Integer delete(Long id) {
        if (id == null) {
            String msg = "id不可以为空";
            logger.error(msg);
            return null;
        }
        return mapper.deleteByPrimaryKey(id);
    }

    public PageList<T> queryPageByParamMap(PageModel pager, T entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", entity);

        // 加入多选数据字典的查询条件
        setObjectDictReltionQueryParam(params, entity);

        List<T> listBean = mapper.queryByParamMap(params);
        Integer count = mapper.countByParamMap(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<T> pagelist = null;
        pagelist = new PageList<T>(listBean, pageObj);
        return pagelist;
    }

    public List<T> findListByParams(T entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bParam", entity);

        // 加入多选数据字典的查询条件
        setObjectDictReltionQueryParam(params, entity);

        List<T> listBean = mapper.queryByParamMap(params);
        return listBean;
    }

    public Long insertBatch(List<T> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            String msg = "操作数据集合不可以为空";
            logger.error(msg);
            return null;
        }
        logger.debug("批量插入对象：{} 条", entityList.size());
        Long result = mapper.insertBatch(entityList);

        // 新建或更新实体的多选数据字典的关系集
        result += updateObjectDictReltionForBean(entityList);
        return result;
    }

    public Integer updateBatchByPrimaryKey(List<T> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            String msg = "操作数据集合不可以为空";
            logger.error(msg);
            return null;
        }
        logger.debug("批量更新对象：{} 条", entityList.size());
        Integer result = mapper.updateBatchByPrimaryKey(entityList);

        // 新建或更新实体的多选数据字典的关系集
        result += updateObjectDictReltionForBean(entityList);
        return result;
    }

    public Long insertOrUpdateBatch(List<T> entityList) {
        Long num = 0l;
        try {
            if (entityList == null || entityList.isEmpty()) {
                String msg = "操作数据集合不可以为空";
                logger.error(msg);
                return num;
            }
            List<T> insertList = new ArrayList<T>();
            List<T> updateList = new ArrayList<T>();
            for (T pr : entityList) {
                Long id = pr.getId();
                if (id == null) {
                    insertList.add(pr);
                } else {
                    updateList.add(pr);
                }
            }
            if (!insertList.isEmpty()) {
                num += insertBatch(insertList);
                logger.debug("批量插入对象：{} 条", insertList.size());
            }
            if (!updateList.isEmpty()) {
                num += updateBatchByPrimaryKey(updateList);
                logger.debug("批量更新对象：{} 条", updateList.size());
            }

            // 新建或更新实体的多选数据字典的关系集
            num += updateObjectDictReltionForBean(entityList);
            return num;

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

    }

    public Integer updateObjectDictReltionForBean(List<T> entityList) {
        Integer result = 0;
        if (entityList == null || entityList.isEmpty()) {
            return result;
        }
        // 插入实体对应的所有数据字典关系属性
        List<SysObjectDictRelation> allList = new ArrayList<SysObjectDictRelation>();
        for (T entity : entityList) {
            if (entity.getDictRelationList() != null) {
                allList.addAll(entity.getDictRelationList());
            }

        }

        if (allList != null && !allList.isEmpty()) {
            result += sysObjectDictRelationService.updateBatch(allList);
        }
        return result;
    }

    public Integer updateObjectDictReltionForBean(T entity) {
        Integer result = 0;
        if (entity == null) {
            return result;
        }
        List<SysObjectDictRelation> allList = entity.getDictRelationList();

        result = sysObjectDictRelationService.updateBatch(allList);

        return result;
    }

    /**
     * 设置数据字典多选集的查询条件
     * 
     * @param queryParam
     */
    public void setObjectDictReltionQueryParam(Map<String, Object> queryParam, T entity) {
        StringBuffer resultBuff = null;
        StringBuffer buff = new StringBuffer();
        if (entity != null) {
            List<SysObjectDictRelation> allList = entity.getDictRelationList();
            if (allList != null && !allList.isEmpty()) {
                for (SysObjectDictRelation vo : allList) {
                    List<SysObjectDictRelationChild> childList = vo.getChildList();
                    if (childList == null || childList.isEmpty()) {
                        continue;
                    }
                    buff.append("(").append(" dr.object = '").append(vo.getObject()).append("'").append(" and dr.attribute = '").append(vo.getAttribute()).append("'").append(" and dr.object_id = '")
                            .append(vo.getObjectId()).append("'");
                    StringBuffer typeBuff = new StringBuffer();
                    StringBuffer valueBuff = new StringBuffer();
                    StringBuffer labelBuff = new StringBuffer();
                    for (SysObjectDictRelationChild child : childList) {
                        String type = child.getType();
                        String value = child.getValue();
                        String label = child.getLabel();
                        if (StringUtils.isNotBlank(type) && typeBuff.indexOf("'" + type + "'") < 0) {
                            typeBuff.append("'").append(type).append("',");
                        }

                        if (StringUtils.isNotBlank(value) && valueBuff.indexOf("'" + value + "'") < 0) {
                            valueBuff.append("'").append(value).append("',");
                        }

                        if (StringUtils.isNotBlank(label) && labelBuff.indexOf("'" + label + "'") < 0) {
                            labelBuff.append("'").append(label).append("',");
                        }
                    }

                    if (StringUtils.isNotBlank(typeBuff)) {
                        buff.append(" and dr.type in (").append(typeBuff.substring(0, typeBuff.length() - 1)).append(")");
                    }
                    if (StringUtils.isNotBlank(valueBuff)) {
                        buff.append(" and dr.value in (").append(valueBuff.substring(0, valueBuff.length() - 1)).append(")");
                    }
                    if (StringUtils.isNotBlank(labelBuff)) {
                        buff.append(" and dr.label in (").append(labelBuff.substring(0, labelBuff.length() - 1)).append(")");
                    }

                    buff.append(")");
                }

            }
        }
        if (StringUtils.isNotBlank(buff)) {
            resultBuff = new StringBuffer();
            resultBuff.append("left join sys_object_dict_relation dr on ");
            resultBuff.append(buff);
            queryParam.put(ObjectDictRelationParam.queryParam, resultBuff.toString());
        } else {
            queryParam.put(ObjectDictRelationParam.queryParam, null);
        }

    }

}
