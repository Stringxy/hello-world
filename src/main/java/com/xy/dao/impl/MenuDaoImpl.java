package com.xy.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xy.dao.MenuDao;
import com.xy.entity.Menu;
import com.xy.util.PageUtil;
import com.xy.util.StringUtil;

public class MenuDaoImpl extends CommonDaoImpl<Menu> implements MenuDao {

	@Override
	public List<Menu> searchPaging(Map<String, Object> params,
			PageUtil<Menu> paging) {
		
		return null;
	}

	@Override
	public int searchPagingCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Menu> findSuper() {
		String hql="from Menu where parentId is null";
		return HQLTemplate.searchHql(hql,null);
	}

	@Override
	public List<Menu> hasChild(Menu m) {
		String hql="from Menu where parentId=:parentId";
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("parentId",m.getId());
		
		return HQLTemplate.searchHql(hql, map);
	}

	@Override
	public List<Menu> findAll() {
		String hql="from Menu order by sortno";
		return HQLTemplate.searchHql(hql, null);
	}

}
