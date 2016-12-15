package com.pzj.base.entity.product.pms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pzj.base.entity.product.ProductRelease;

public class ProductReleaseUtil {

    private static ProductReleaseUtil productUtil = new ProductReleaseUtil();

    private ProductReleaseUtil() {
    }

    public static ProductReleaseUtil getInstance() {
        return productUtil;
    }

    public Map<Long, List<ProductBed>> getProductBedMap(List<ProductRelease> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<Long, List<ProductBed>> map = new HashMap<Long, List<ProductBed>>();
        for (ProductRelease vo : list) {
            List<ProductBed> childList = vo.getBedList();
            map.put(vo.getId(), childList);
        }
        return map;

    }

    public Map<Long, List<ProductPriceRule>> getProductPriceRuleMap(List<ProductRelease> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<Long, List<ProductPriceRule>> map = new HashMap<Long, List<ProductPriceRule>>();
        for (ProductRelease vo : list) {
            List<ProductPriceRule> childList = vo.getProductPriceRules();
            map.put(vo.getId(), childList);
        }
        return map;

    }

    public Map<Long, List<ProductPenalty>> getProductPenaltyMap(List<ProductRelease> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<Long, List<ProductPenalty>> map = new HashMap<Long, List<ProductPenalty>>();
        for (ProductRelease vo : list) {
            List<ProductPenalty> childList = vo.getProductPenaltys();
            map.put(vo.getId(), childList);
        }
        return map;
    }
}
