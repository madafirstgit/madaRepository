package com.pzj.base.sku.mapper;

import java.util.List;

public interface BaseMapper<T> {
	public int insertBatch(List<T> list);
}
