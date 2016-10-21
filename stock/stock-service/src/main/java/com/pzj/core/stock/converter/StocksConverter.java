package com.pzj.core.stock.converter;

import java.util.ArrayList;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.entity.Stock;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.model.StockModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;

/**
 * 库存转换器.
 * @author YRJ
 *
 */
@Component(value = "stocksConverter")
public class StocksConverter implements ObjectConverter<ArrayList<Stock>, ServiceContext, ArrayList<StockModel>> {
    private static final Logger logger = LoggerFactory.getLogger(StocksConverter.class);

    /** 底层实体 转换为  VO*/
    @Override
    public ArrayList<StockModel> convert(ArrayList<Stock> list, ServiceContext context) {

        if (null == list || list.size() == 0)
            return null;
        ArrayList<StockModel> vos = new ArrayList<StockModel>(list.size());

        for (Stock stock : list) {
            StockModel model = new StockModel();
            try {
                PropertyUtils.copyProperties(model, stock);
            } catch (Exception e) {
                logger.error(" copy stock properties to stock model error ", e);
                throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
            }
            vos.add(model);
        }
        return vos;
    }
}
