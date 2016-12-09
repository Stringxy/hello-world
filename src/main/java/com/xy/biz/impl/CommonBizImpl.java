package com.xy.biz.impl;

import java.util.List;
import java.util.Map;

import com.xy.biz.CommonBiz;
import com.xy.dao.CommonDao;
import com.xy.util.PageUtil;

public class CommonBizImpl<T> implements CommonBiz<T> {

	protected CommonDao<T> commondao=null;
	protected void setCommonDao(CommonDao cd){
		this.commondao=cd;
	}
	@Override
	public void insert(T obj) {
		this.commondao.insert(obj);
		
	}

	@Override
	public void update(T obj) {
		this.commondao.update(obj);
		
	}

	@Override
	public void delete(T obj) {
		this.commondao.delete(obj);
		
	}

	@Override
	public void delete(int id) {
		this.commondao.delete(id);
		
	}

	@Override
	public T findById(int id) {
		
		return this.commondao.findById(id);
	}

	@Override
	public void searchPaging(Map<String, Object> params, PageUtil<T> paging) {
		paging.setData(this.commondao.searchPaging(params, paging));
		paging.setTotalRecords(this.commondao.searchPagingCount(params));
	}

}
