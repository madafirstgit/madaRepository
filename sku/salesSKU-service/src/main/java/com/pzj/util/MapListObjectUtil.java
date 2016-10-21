package com.pzj.util;

import com.pzj.product.vo.ListObject;
import com.pzj.product.vo.MapObject;
import com.pzj.util.productConvertUtil.CommonConvert;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-8-25.
 */
public class MapListObjectUtil {

    public interface ComposeConvert<Data, MapKey, ListValue> {
        MapKey mapKey(Data data);

        ListValue listValue(Data data);
    }

    public static <SourceData, MapKey, NewValue, MapValue extends ListObject<NewValue>, TargetData extends MapObject<MapKey,MapValue>> void
        composeListObjcet(List<TargetData> targetData, List<SourceData> sourceData, ComposeConvert<SourceData, MapKey, NewValue> b){
        Map<MapKey, MapValue> map = CommonConvert.convertToMap(targetData);

        for (SourceData data : sourceData){
            MapValue targetValue = map.get(b.mapKey(data));

            if (targetValue == null)
                continue;

            CommonConvert.addToList(targetValue, b.listValue(data));
        }
    }
}
