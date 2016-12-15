package test;

import org.junit.Test;

import com.pzj.dict.entity.Dict;
import com.pzj.dict.service.DictService;
import com.pzj.dict.service.DictServiceImpl;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class dictTest {

	private DictService dictService = new DictServiceImpl();

    @Test
    public void save() throws Exception {
        Dict dict = new Dict();
        dict.setId(0L);
        dict.setCreateBy("fewfewf");
        dictService.saveDict(dict);
    }

    @Test
    public void getListByType() throws Exception {
        // TEST
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        String type = "product:ticketType";
        List<Dict> dicts = dictService.getListByType(type);
        assertNotNull(dicts);

        System.out.println("总数" + dicts.size());
        for(Dict dict : dicts){
            System.out.println("\t" + dict.getId() + "\t" + dict.getSort());
        }
    }
    @Test
    public void getListByTypeEE() throws Exception {
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        for (int i = 0; i < 1000; i++){
            System.out.println(">>>>>> " + i);
            getListByType();
        }
    }
}