/*
 * ProductCloseTimeslotService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.exception.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.product.IProductCloseTimeslotMapper;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.product.IProductCloseTimeslotService;
import com.pzj.product.service.ICloseTimeSlotService;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.voParam.queryParam.CloseTimeSlotQueryParam;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.ProductConvert;

/**
 * service接口实现.区域
 * @author 票之家
 */
@Service
public class ProductCloseTimeslotServiceImpl extends
                                             BaseServiceImpl<ProductCloseTimeslot, IProductCloseTimeslotMapper>
                                             implements ICloseTimeSlotService,
                                             IProductCloseTimeslotService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Long addCloseTimeSlot(SkuCloseTimeSlot vo) throws Exception {
        ProductCloseTimeslot entity = new ProductCloseTimeslot();
        CommonConvert.copyProperties(entity, vo);
        
        return this.insert(entity);
    }

    @Override
    public Integer addBatchCloseTimeSlot(List<SkuCloseTimeSlot> voList) throws Exception {
        if (voList == null) {
            return 0;
        }
        List<ProductCloseTimeslot> entityList = new ArrayList<ProductCloseTimeslot>();
        for (SkuCloseTimeSlot vo : voList) {
            ProductCloseTimeslot entity = new ProductCloseTimeslot();
            CommonConvert.copyProperties(entity, vo);
            entityList.add(entity);
        }
        Long result = this.insertBatch(entityList);

        return result == null ? 0 : new BigDecimal(result).intValue();
    }

    @Override
    public Integer saveCloseTimeSlot(SkuCloseTimeSlot vo) throws Exception {
        ProductCloseTimeslot entity = new ProductCloseTimeslot();
        CommonConvert.copyProperties(entity, vo);

        return this.updateByPrimaryKey(entity);
    }

    @Override
    public Integer saveBatchCloseTimeSlot(List<SkuCloseTimeSlot> voList) throws Exception {
        if (voList == null) {
            return 0;
        }
        List<ProductCloseTimeslot> entityList = new ArrayList<ProductCloseTimeslot>();
        for (SkuCloseTimeSlot vo : voList) {
            ProductCloseTimeslot entity = new ProductCloseTimeslot();
            CommonConvert.copyProperties(entity, vo);
            entityList.add(entity);
        }

        return this.updateBatchByPrimaryKey(entityList);
    }

    @Override
    public Integer delCloseTimeSlot(Long id) throws Exception {

        return this.delete(id);
    }

    public Integer delByPid(Long pid) {
        return mapper.deleteByPid(pid);
    }

    @Override
    public Integer delBatchCloseTimeSlot(List<Long> id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SkuCloseTimeSlot> querySkuCloseTimeSlotByParams(CloseTimeSlotQueryParam param) {
        ProductCloseTimeslot productCloseTimeslotParam = ProductConvert
            .convertTProductCloseTimeslot(param);
        List<ProductCloseTimeslot> listByParams = this.findListByParams(productCloseTimeslotParam);
        return CommonConvert.convertList(listByParams, SkuCloseTimeSlot.class);
    }

    public Integer saveSkuAndCloseTimeSlotRelation(ProductInfo info,
                                                   List<ProductCloseTimeslot> closeTimeSlotIds) {
        if (closeTimeSlotIds == null || closeTimeSlotIds.isEmpty()) {
            logger.error("新建产品接口[saveSkuAndCloseTimeSlotRelation]：传入参数没有时间事件信息");
            throw new SkuParamNullException("新建产品接口[saveSkuAndCloseTimeSlotRelation]：传入参数没有时间事件信息");
        }
        try {
            Integer result = 0;
            //1.验证数据
            
            
            //2.先根据产品组id删除产品关闭事件
            result += delByPid(info.getId());

            List<ProductCloseTimeslot> addList = new ArrayList<ProductCloseTimeslot>();
            for (ProductCloseTimeslot slot : closeTimeSlotIds) {
            	slot.setProductInfoId(info.getId());
            	slot.setCreateDate(new Date());
            	if(info.getSupplierId() != null)
            	slot.setSupplierId(Long.valueOf(info.getSupplierId()));
                addList.add(slot);
            }
            insertBatch(addList);
        } catch (Exception ex) {
            throw new ServiceException("新建产品接口[saveSkuAndCloseTimeSlotRelation]：创建产品关闭时间事件失败");
        }

        return 0;

    }

	@Override
	public List<ProductCloseTimeslot> findValidListByProductIds(
			List<Long> productIds) {
		if(CollectionUtils.isEmpty(productIds)){
			throw  new SkuParamNullException("根据产品组id集合查询有效的产品关闭时间事件集合[findValidListByProductIds],入参为空");
		}
		ProductCloseTimeslot query = new ProductCloseTimeslot();
		query.setIds(productIds);
		query.setFlag(GlobalParam.FLAG.start());
		return findListByParams(query);
	}
	
	
	private void checkAddDate(List<ProductCloseTimeslot> slotList){
		if(CollectionUtils.isEmpty(slotList)){
			return;
		}
		Collections.sort(slotList, ProductCloseTimeslot.getComparator());
	}

}
