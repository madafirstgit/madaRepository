package com.pzj.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.pzj.base.common.BaseEntity;

public class EntityCommonUtil {
	 public  static <T extends BaseEntity> void filterTById(List<T> entityList){
	    	if(entityList == null){
	    		return;
	    	}
	    	Set<Long> set = new HashSet<Long>();
	    	Iterator<T> it = entityList.iterator();
	    	while(it.hasNext()){
	    		T t = it.next();
	    		if(set.contains(t.getId())){
	    			it.remove();
	    			continue;
	    		}
	    		set.add(t.getId());	    
	    	}
	    }  

}
