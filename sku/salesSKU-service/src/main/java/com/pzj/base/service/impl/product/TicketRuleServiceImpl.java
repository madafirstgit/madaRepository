package com.pzj.base.service.impl.product;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductRuleRel;
import com.pzj.base.entity.product.TicketRule;
import com.pzj.base.product.IProductRuleRelMapper;
import com.pzj.base.product.ITicketRuleMapper;
import com.pzj.base.service.product.ITicketRuleService;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 */
@Service(value = "ticketRuleService")
public class TicketRuleServiceImpl implements ITicketRuleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketRuleServiceImpl.class);

    @Autowired
    ITicketRuleMapper           ruleMapper;

    @Autowired
    IProductRuleRelMapper       relMapper;

    @Override
    public Long insert(TicketRule entity) {
        if (validateEntity(entity, false))// 数据验证
            return 0L;
        // 插入退换票规则
        entity.setCreateDate(new Date());
        ruleMapper.insert(entity);
        // 绑定退换票规则与产品关系
        List<Long> pIds = entity.getProIds();
        if (pIds == null || pIds.size() == 0)
            return entity.getId();
        // 创建中间实体维护关系
        List<ProductRuleRel> rels = new ArrayList<>();
        Long rId = entity.getId();
        Long sId = entity.getSupId();
        for (Long pId : pIds) {
            ProductRuleRel rel = new ProductRuleRel();
            rel.setP_id(pId);
            rel.setR_id(rId);
            rel.setS_id(sId);
            rels.add(rel);
        }
        // 维护关系
        relMapper.insertBatch(rels);
        LOGGER.info("插入数据：{}", entity);
        return rId;
    }

    @Override
    public Integer updateByPrimaryKey(TicketRule entity) {
        // 验证数据
        if (validateEntity(entity, true))
            return null;
        Integer num = 0;
        // 更新退换票规则
        entity.setUpdateDate(new Date());
        num += ruleMapper.updateByPrimaryKey(entity);
        //依据ProIds集合是否为空，判断是否需要更新相关关系
        if (entity.getProIds() == null)
            return num;
        // 删除旧关系
        Long id = entity.getId();
        ProductRuleRel rel = new ProductRuleRel();
        rel.setR_id(id);
        relMapper.deleteByParams(rel);
        // 维护新关系
        // 创建中间实体维护关系
        List<Long> pIds = entity.getProIds();
        if (pIds == null || pIds.size() == 0)
            return num;
        List<ProductRuleRel> rels = new ArrayList<>();
        Long sId = entity.getSupId();
        for (Long pId : pIds) {
            ProductRuleRel r = new ProductRuleRel();
            r.setP_id(pId);
            r.setR_id(id);
            r.setS_id(sId);
            rels.add(r);
        }
        relMapper.insertBatch(rels).intValue();
        LOGGER.info("更新数据：{}", entity);
        return num;
    }

    @Override
    public Long insertOrUpdate(TicketRule entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(new Date());
            return this.insert(entity);
        }
        entity.setUpdateDate(new Date());
        return this.updateByPrimaryKey(entity).longValue();
    }

    @Override
    public Integer delete(Long id) {
        if (id == null || id < 1) {
            LOGGER.error("操作数据：{}有误", id);
            return 0;
        }
        // 删除票规则
        Integer count = ruleMapper.deleteByPrimaryKey(id);
        // 删除中间关系
        ProductRuleRel rel = new ProductRuleRel();
        rel.setR_id(id);
        count += relMapper.deleteByParams(rel);
        LOGGER.info("删除数据：{}", id);
        return count;
    }

    @Override
    public TicketRule getById(Long id) {
        if (id == null || id < 1) {
            LOGGER.error("操作数据：{}有误", id);
            return null;
        }
        return ruleMapper.selectByPrimaryKey(id);
    }

    @Override
    @Deprecated
    public List<TicketRule> findListByParams(TicketRule rule) {
        // 验证数据
        if (validateEntity(rule, false))
            return null;
        Map<String, Object> param = new HashMap<>();
        param.put("bParam", rule);
        param.put("pParam", null);
        return ruleMapper.queryByParamMap(param);
    }

    @Override
    public PageList<TicketRule> queryPageByParamMap(PageModel pager, TicketRule entity) {
        Map<String, Object> param = new HashMap<>();
        param.put("bParam", entity);
        param.put("pParam", pager);
        Integer count = ruleMapper.countByParamMap(param);
        if (count == null || count == 0)
            return null;
        List<TicketRule> list = ruleMapper.queryByParamMap(param);
        List<TicketRule> convertPorIds = convertPorIds(list);
        PageBean pageObj = new PageBean(count, pager);
        return new PageList<TicketRule>(convertPorIds, pageObj);
    }

    @Override
    public Long insertBatch(List<TicketRule> list) {

        if (list == null || list.size() == 0)
            return null;
        // 插入退换票规则
        Date currentDate = new Date();
        for (TicketRule ticketRule : list) {
            ticketRule.setCreateDate(currentDate);
        }
        Long count = ruleMapper.insertBatch(list);
        // 绑定退换票规则与产品关系
        // 创建中间实体维护关系
        List<ProductRuleRel> rels = new ArrayList<>();
        for (TicketRule entity : list) {
            List<Long> pIds = entity.getProIds();
            if (pIds == null || pIds.size() == 0)
                continue;
            Long id = entity.getId();
            Long sId = entity.getSupId();
            for (Long pId : pIds) {
                ProductRuleRel rel = new ProductRuleRel();
                rel.setP_id(pId);
                rel.setR_id(id);
                rel.setS_id(sId);
                rels.add(rel);
            }
        }
        // 维护关系
        count += relMapper.insertBatch(rels);
        LOGGER.info("插入数据：{}", list);
        return count;
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<TicketRule> entityList) {
        if (validateList(entityList))
            return null;
        // 更新退换票规则
        Integer num = 0;
        Date currentDate = new Date();
        //批量设置更新时间
        for (TicketRule ticketRule : entityList) {
            ticketRule.setUpdateDate(currentDate);
        }
        ruleMapper.updateBatchByPrimaryKey(entityList);
        num += entityList.size();
        LOGGER.info("批量更新{}条退款规则", num);
        //根据proIDs 集合是否为空判断 是否需要更新 规则与产品的关系
        for (TicketRule ticketRule : entityList) {
            if (ticketRule.getProIds() == null)
                continue;//产品id集合为空，则不进行关系的更新操作
            // 删除旧关系
            ProductRuleRel rel = new ProductRuleRel();
            rel.setR_id(ticketRule.getId());
            relMapper.deleteByParams(rel);
            // 维护新关系
            // 创建中间实体维护关系
            List<Long> pIds = ticketRule.getProIds();
            Long sId = ticketRule.getSupId();
            if (pIds == null || pIds.size() == 0)
                continue;
            Long id = ticketRule.getId();
            List<ProductRuleRel> rels = new ArrayList<>();
            for (Long pId : pIds) {
                ProductRuleRel r = new ProductRuleRel();
                r.setP_id(pId);
                r.setR_id(id);
                r.setS_id(sId);
                rels.add(r);
            }
            // 维护关系
            relMapper.insertBatch(rels);
            LOGGER.info("维护退款规则{}与产品的关系", ticketRule);
        }
        return num;
    }

    @Override
    public Long insertOrUpdateBatch(List<TicketRule> entityList) {
        if (validateList(entityList))
            return null;
        List<TicketRule> up = new ArrayList<>();
        List<TicketRule> in = new ArrayList<>();
        for (TicketRule rule : entityList) {
            if (rule.getId() == null) {
                in.add(rule);
                continue;
            }
            up.add(rule);
        }
        Long count = 0L;
        Date currentDate = new Date();
        if (in.size() > 0) {
            for (TicketRule ticketRule : in) {
                ticketRule.setUpdateDate(currentDate);
            }
            count += this.insertBatch(in);
        }
        if (up.size() > 0) {
            for (TicketRule ticketRule : up) {
                ticketRule.setUpdateDate(currentDate);
            }
            count += this.updateBatchByPrimaryKey(up);
        }
        return count;
    }

    @Override
    public Map<String, TicketRule> listTMap(List<TicketRule> entityList, String regx) {
        if (entityList == null)
            return null;
        Map<String, TicketRule> map = new HashMap<String, TicketRule>();
        for (TicketRule record : entityList) {
            Long id = record.getId();
            String key = "";
            if (id != null) {
                key = String.valueOf(id);
            }
            if (StringUtils.isNotBlank(key) && !map.containsKey(record)) {
                map.put(key, record);
            }
        }
        return map;
    }

    //将查询结果的关心实体id集合封装到proIds 集合中
    private List<TicketRule> convertPorIds(List<TicketRule> list) {
        if (list == null || list.size() == 0)
            return null;
        for (TicketRule ticketRule : list) {
            List<Long> proIds = new ArrayList<>(list.size());
            List<ProductRuleRel> rels = ticketRule.getRels();
            if (rels == null || rels.size() == 0)
                continue;
            for (ProductRuleRel productRuleRel : rels) {
                proIds.add(productRuleRel.getP_id());
            }
            ticketRule.setProIds(proIds);
        }
        return list;
    }

    /**
     * @param list 规则实体集合
     * @return false
     */
    private Boolean validateList(List<TicketRule> list) {
        if (list == null || list.size() == 0) {
            LOGGER.error("操作数据：{},不应为空", list);
            return true;
        }
        return false;
    }

    /**
     * 
     * 验证实体
     * @param rule 退款规则实体
     * @param validateId 是否需要验证实体的ID属性
     * @return 验证失败返回 true
     */
    private Boolean validateEntity(TicketRule rule, Boolean validateId) {
        if (rule == null) {
            LOGGER.error("操作数据：{},不应为空", rule);
            return true;
        }

        if (validateId) {
            if (rule.getId() == null) {
                LOGGER.error("操作数据：{},ID 不应为空", rule);
                return true;
            }
        }
        return false;
    }

}
