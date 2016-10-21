package com.pzj.regulation.convertUtil;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.common.BaseVoConvertUtil;
import com.pzj.regulation.entity.StrategyVo;
import com.pzj.util.KeyValueVo;

public class StrategyVoConvertUtil extends BaseVoConvertUtil<StrategyVo, SysChannelStrategy> {
    private static StrategyVoConvertUtil util = new StrategyVoConvertUtil();

    private StrategyVoConvertUtil() {

    }

    public static StrategyVoConvertUtil getInstance() {
        return util;
    }

    public SysChannelStrategy convertTSysBean(StrategyVo vo) {
        if (vo == null)
            return null;
        SysChannelStrategy bean = new SysChannelStrategy();
        bean.setId(vo.getId());
        bean.setType(vo.getType());
        bean.setName(vo.getName());
        bean.setRemark(vo.getRemark());
        bean.setStrategyExpireType(vo.getStrategyExpireType());
        bean.setBeginDate(vo.getBeginDate());
        bean.setEndDate(vo.getEndDate());
        bean.setCheckinExpireType(vo.getCheckinExpireType());
        bean.setCheckinExpireNum(vo.getCheckinExpireNum());
        bean.setCheckinExpireUnit(vo.getCheckinExpireUnit());
        bean.setTicketVarie(vo.getTicketVarie());
        bean.setPrice(vo.getPrice());
        bean.setSettlementPrice(vo.getSettlementPrice());
        /** 销售端口转换 */
        bean.setSalesType(KeyValueVo.getString(vo.getSalesType()));
        bean.setExpire(vo.getExpire());
        bean.setExpireMode(vo.getExpireMode());
        /** 适用范围转换 */
        bean.setScope(KeyValueVo.getString(vo.getScope()));
        bean.setStatus(vo.getStatus());
        bean.setPublishStatus(vo.getPublishStatus());
        bean.setPublishBy(vo.getPublishBy());
        bean.setPublishDate(vo.getPublishDate());
        bean.setAuditStatus(vo.getAuditStatus());
        bean.setRefuseReason(vo.getRefuseReason());
        bean.setIsMF(vo.getIsMF());
        bean.setCreateDate(vo.getCreateDate());
        bean.setCreateBy(vo.getCreateBy());
        bean.setUpdateDate(vo.getUpdateDate());
        bean.setUpdateBy(vo.getUpdateBy());
        bean.setDelFlag(vo.getDelFlag());
        bean.setDataSource(vo.getDataSource());
        bean.setSupplierId(vo.getSupplierId());
        /** 是否更新值为null的字段 */
        bean.setIsNeedUpdateNull(vo.getIsNeedUpdateNull());

        /** 废弃字段 **/
        bean.setPreSale(vo.getPreSale());
        bean.setPreSaleMode(vo.getPreSaleMode());
        bean.setQuantity(vo.getQuantity());
        bean.setIsOpenMultiRebate(vo.getIsOpenMultiRebate());
        return null;
    }

    public StrategyVo convertTApiBean(SysChannelStrategy vo) {
        if (vo == null)
            return null;
        StrategyVo bean = new StrategyVo();
        bean.setId(vo.getId());
        bean.setType(vo.getType());
        bean.setName(vo.getName());
        bean.setRemark(vo.getRemark());
        bean.setStrategyExpireType(vo.getStrategyExpireType());
        bean.setBeginDate(vo.getBeginDate());
        bean.setEndDate(vo.getEndDate());
        bean.setCheckinExpireType(vo.getCheckinExpireType());
        bean.setCheckinExpireNum(vo.getCheckinExpireNum());
        bean.setCheckinExpireUnit(vo.getCheckinExpireUnit());
        bean.setTicketVarie(vo.getTicketVarie());
        bean.setPrice(vo.getPrice());
        bean.setSettlementPrice(vo.getSettlementPrice());
        /** 销售端口转换 */
        bean.setSalesType(KeyValueVo.getList(vo.getSalesType()));
        bean.setExpire(vo.getExpire());
        bean.setExpireMode(vo.getExpireMode());
        /** 适用范围转换 */
        bean.setScope(KeyValueVo.getList(vo.getScope()));
        bean.setStatus(vo.getStatus());
        bean.setPublishStatus(vo.getPublishStatus());
        bean.setPublishBy(vo.getPublishBy());
        bean.setPublishDate(vo.getPublishDate());
        bean.setAuditStatus(vo.getAuditStatus());
        bean.setRefuseReason(vo.getRefuseReason());
        bean.setIsMF(vo.getIsMF());
        bean.setCreateDate(vo.getCreateDate());
        bean.setCreateBy(vo.getCreateBy());
        bean.setUpdateDate(vo.getUpdateDate());
        bean.setUpdateBy(vo.getUpdateBy());
        bean.setDelFlag(vo.getDelFlag());
        bean.setDataSource(vo.getDataSource());
        bean.setSupplierId(vo.getSupplierId());

        /** 废弃字段 **/
        bean.setPreSale(vo.getPreSale());
        bean.setPreSaleMode(vo.getPreSaleMode());
        bean.setQuantity(vo.getQuantity());
        bean.setIsOpenMultiRebate(vo.getIsOpenMultiRebate());

        return bean;
    }

    @Override
    public SysChannelStrategy convertTSysBeanForIU(StrategyVo vo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SysChannelStrategy convertTSysBeanForS(StrategyVo vo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void validData(StrategyVo vo) throws ServiceException {
        // TODO Auto-generated method stub

    }

}
