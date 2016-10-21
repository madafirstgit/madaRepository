package com.pzj.scenic.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

/**
 * Created by Administrator on 2016-4-26.
 */
public class ScenicBuilder extends CommonBuiler<ProductScenic, Scenic> {
    public static final ScenicBuilder AScenicBuilder = new ScenicBuilder();

    @Override
    public Scenic convertFrom(ProductScenic entity) {
        Scenic scenic = new Scenic();
        scenic.setId(entity.getId());
        scenic.setName(entity.getName());
        scenic.setStatus(entity.getStatus());
        scenic.setType(entity.getType());
        //scenic.setSource(entity.getSource());

        if (entity.getSupplierId() != null)
            scenic.setSupplierId(Long.valueOf(entity.getSupplierId()));

        return scenic;
    }

    @Override
    public ProductScenic convertTo(Scenic entity) {
        ProductScenic scenic = new ProductScenic();
        scenic.setId(entity.getId());
        scenic.setName(entity.getName());
        scenic.setStatus(entity.getStatus());
        scenic.setType(entity.getType());
        //scenic.setSource(entity.getSource());

        if (entity.getSupplierId() != null)
            scenic.setSupplierId(entity.getSupplierId().toString());

        return scenic;
    }

    @Override
    protected void validtionValueWhenCreate(Scenic entity, CommonCheck check) throws ServiceException {

    }

    @Override
    protected void customValueWhenCreate(Scenic entity) {

    }

    @Override
    protected void customValueWhenModify(Scenic entity) {

    }
}
