package com.xy.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xy.dao.RoleDao;
import com.xy.entity.Role;
import com.xy.util.PageUtil;

public class RoleDaoImpl extends CommonDaoImpl<Role> implements RoleDao {


	@Override
	public List<Role> searchPaging(Map<String, Object> params,
			PageUtil<Role> paging) {
		String hql="from Role order by roleId";
		
		return HQLTemplate.searchHql(hql,params, paging);
	}

	@Override
	public int searchPagingCount(Map<String, Object> params) {
		String hql="select count(*) from Role";
		return HQLTemplate.searchCount(hql, params);
	}

	@Override
	public List<Role> getAll() {
		String hql="from Role order by roleId";
		return HQLTemplate.searchHql(hql,null);
	}

	@Override
	public List<String> getPerms(Role r) {
		String hql="select perms from Menu m where id in (select menu.id from RoleMenu where role=:role) and m.perms is not null";
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("role", r);
		
		return HQLTemplate.searchHql(hql, map);
	}

}
