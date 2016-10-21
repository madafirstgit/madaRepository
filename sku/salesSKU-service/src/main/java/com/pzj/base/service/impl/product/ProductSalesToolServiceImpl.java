package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductSalesTool;
import com.pzj.base.product.IProductSalesToolMapper;
import com.pzj.base.service.product.IProductSalesToolService;

/**
 * 直销工具对外服务接口
 * 
 * @author apple
 * 
 */
@Service
@Lazy
public class ProductSalesToolServiceImpl extends
                                         BaseServiceImpl<ProductSalesTool, IProductSalesToolMapper>
                                         implements IProductSalesToolService {

    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(ProductSalesToolServiceImpl.class);

    @Override
    public List<ProductSalesTool> findSalesToolsWithSupplier(ProductSalesTool param) {
        if (param == null)
            return null;

        List<ProductSalesTool> result = mapper.findSalesToolsWithSupplier(param);

        return result;
    }

}
