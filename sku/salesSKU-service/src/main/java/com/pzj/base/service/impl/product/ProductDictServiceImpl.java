package com.pzj.base.service.impl.product;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductDict;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRulesIntegral;
import com.pzj.base.product.IProductDictMapper;
import com.pzj.base.service.product.IProductDictService;

/**
 * 产品字典表对外服务实现
 * 
 * @author apple
 * 
 */
@Service
public class ProductDictServiceImpl extends BaseServiceImpl<ProductDict, IProductDictMapper>
                                    implements IProductDictService {

    protected Logger logger = LoggerFactory.getLogger(ProductDictServiceImpl.class);

    @Override
    public List<ProductDict> findByIdsMap(Map<String, List<Long>> ids) {
        return mapper.findByIdsMap(ids);
    }

    @Override
    public ProductDict insertDict(ProductDict productDict) {
        super.insert(productDict);
        return productDict;
    }

    @Override
    public Long queryMaxVal(String type) {
        return mapper.queryMaxVal(type);
    }

    @Override
    public PageList<ProductRulesIntegral> findListAndProductByParams(ProductDict dict,
                                                                     ProductRelease release,
                                                                     PageModel page) {

        int count = mapper.countRulesIntegralAndProductByParams(dict, release);
        List<ProductRulesIntegral> rulesIntegralList = null;

        if (count > 0) {
            rulesIntegralList = mapper.selectRulesIntegralAndProductByParams(dict, release, page);
        }

        PageList<ProductRulesIntegral> result = new PageList(rulesIntegralList, page, count);
        return result;
    }

    @Override
    public List<ProductRulesIntegral> findProductOfRulesIntegralByParams(List<Long> ruleIds) {
        return mapper.selectProductOfRulesIntegralByParams(ruleIds);
    }
}
