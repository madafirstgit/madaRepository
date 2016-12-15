package com.pzj.regulation.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysSettlementRule;
import com.pzj.base.service.sys.ISysSettlementRuleService;
import com.pzj.regulation.convertUtil.SettlementRuleConvertUtil;
import com.pzj.regulation.entity.StrategySettlementRule;
import com.pzj.regulation.service.StrategySettlementRuleService;

@Service
public class StrategySettlementRuleServiceImpl implements
        StrategySettlementRuleService {
    // 创建日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysSettlementRuleService isysSettlementRuleService;

    private SettlementRuleConvertUtil settlementUtil = SettlementRuleConvertUtil.getInstance();

    /**
     * 创建减免规则
     */
    public Long create(StrategySettlementRule vo) throws Exception {
        Long num = 0l;
        try {
            if (vo == null) {
                logger.error("接口方法[StrategySettlementRuleService.create],参数vo不能为空");
                return num;
            }

            // 转换实体
            SysSettlementRule bean = settlementUtil.convertTSysBeanForIU(vo);

            num = isysSettlementRuleService.insert(bean);// 需要实现该服务接口：

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 批量创建减免规则
     */
    public Long createBatch(List<StrategySettlementRule> voList)
            throws Exception {
        Long num = 0l;
        try {
            if (voList == null) {
                logger.error("接口方法[StrategySettlementRuleService.createBatch],参数voList不能为空");
                return num;
            }

            // 转换实体
            List<SysSettlementRule> beanList = settlementUtil
                    .convertListTSysBeanForIU(voList);

            num = isysSettlementRuleService.insertBatch(beanList);// 需要实现该服务接口：

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;

    }

    /**
     * 更新减免规则
     */
    public Integer update(StrategySettlementRule vo) throws Exception {
        int num = 0;
        try {
            if (vo == null) {
                logger.error("接口方法[StrategySettlementRuleService.update],参数vo不能为空");
                return num;
            }
            Long id = vo.getId();
            if (id == null) {
                logger.error("接口方法[StrategySettlementRuleService.update],参数vo的id不能为空");
                return num;
            }
            // 转换实体
            SysSettlementRule bean = settlementUtil.convertTSysBeanForIU(vo);
            num = isysSettlementRuleService.updateByPrimaryKey(bean);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;

        }
        return num;
    }

    /**
     * 批量更新减免规则
     */
    public Integer updateBatch(List<StrategySettlementRule> voList)
            throws Exception {
        Integer num = 0;
        try {
            if (voList == null) {
                logger.error("接口方法[StrategySettlementRuleService.updateBatch],参数voList不能为空");
                return num;
            }

            // 转换实体
            List<SysSettlementRule> beanList = settlementUtil
                    .convertListTSysBeanForIU(voList);

            num = isysSettlementRuleService.updateBatchByPrimaryKey(beanList);// 需要实现该服务接口：

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 根据id查询减免规则
     */
    public StrategySettlementRule getById(Long id) throws Exception {
        StrategySettlementRule vo = null;
        try {
            if (id == null || id < 1) {
                logger.error("接口方法[StrategySettlementRuleService.getById],参数id不能为空");
            }
            SysSettlementRule bean = isysSettlementRuleService.getById(id);
            if (bean != null) {
                vo = settlementUtil.convertTApiBean(bean);
            }
        } catch (Exception e) {

            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
        return vo;
    }

    /**
     * 分页查询 根据减免规则的基础信息，主键集合，政策主键集合，产品主键集合，联合产品的主键集合查询减免规则
     * 
     * @param pager
     *            分页对象
     * @param vo
     *            查询参数
     * 
     */
    public PageList<StrategySettlementRule> queryPageByParamMap(
            PageModel pager, StrategySettlementRule vo) throws Exception {
        PageList<StrategySettlementRule> list = new PageList<StrategySettlementRule>();
        try {
            SysSettlementRule rule = settlementUtil.convertTSysBeanForS(vo);

            PageList<SysSettlementRule> pageList = isysSettlementRuleService
                    .queryPageByParamMap(pager, rule);

            List<StrategySettlementRule> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysSettlementRule> records = pageList.getResultList();
                voList = settlementUtil.convertListTApiBean(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    /**
     * 列表查询 根据减免规则的基础信息，主键集合，政策主键集合，产品主键集合，联合产品的主键集合查询减免规则
     * 
     * @param vo
     *            查询参数
     * 
     */
    public List<StrategySettlementRule> queryByParamMap(
            StrategySettlementRule vo) throws Exception {
        List<StrategySettlementRule> voList = null;
        try {
            SysSettlementRule rule = settlementUtil.convertTSysBeanForS(vo);

            List<SysSettlementRule> slist = isysSettlementRuleService
                    .findListByParams(rule);

            if (slist != null && (!slist.isEmpty())) {
                voList = settlementUtil.convertListTApiBean(slist);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return voList;
    }

}
