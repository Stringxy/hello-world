package com.xy.biz;

import java.util.List;
import java.util.Map;

import com.xy.util.PageUtil;

public interface CommonBiz<T> {
	/**
	 * 新增
	 * @param obj
	 */
	public void insert(T obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	public void update(T obj);
	
	/**
	 * 删除
	 * @param obj
	 */
	public void delete(T obj);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	public void delete(int id);
	
	
	/**
	 * 根据主键来查询
	 * @param id
	 * @return
	 */
	public T findById(int id);
	
	
	/**
	 * 分页查询
	 * @param params 查询参数
	 * @param paging 分页对象
	 * @return
	 */
	public void searchPaging(Map<String, Object> params, PageUtil<T> paging);
	

}
