package com.pzj.base.service.balance;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.entity.product.ProductBalance;

/**
 * 结算消息接口
 * 
 * @author apple
 * 
 */
public interface IProductBalanceService {

	/** 添加结算消息信息 **/
	public Integer addProductBalance(ProductBalance productBalance);

	/** 通过id查询结算消息 **/
	public ProductBalance getProductBalanc(ProductBalance productBalance);

	/** 获取全部结算消息信息集合 **/
	public List<ProductBalance> getAllProductBalance(
			ProductBalance productBalance);

	/** * 分页查询时得到符合条件的数据 * @param page * @return */
	public Integer getCount(ProductBalance productBalance);

	/** * 获取分页集合 * @param page * @return */
	public PageList<ProductBalance> getBypage(Integer page, Integer pageSize,
			ProductBalance productBalance);

	/** * 删除结算消息，修改状态 * @param page * @return */
	public Integer delProductBalance(ProductBalance productBalance);

	/** 修改结算消息信息 **/
	public Integer updateProductBalance(ProductBalance productBalance);
}
