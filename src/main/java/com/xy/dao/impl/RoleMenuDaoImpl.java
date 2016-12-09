package com.xy.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xy.dao.RoleMenuDao;
import com.xy.entity.Menu;
import com.xy.entity.RoleMenu;
import com.xy.util.PageUtil;

public class RoleMenuDaoImpl extends CommonDaoImpl<RoleMenu> implements RoleMenuDao {



	@Override
	public List<RoleMenu> searchPaging(Map<String, Object> params,
			PageUtil<RoleMenu> paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchPagingCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isExists(int roleid, int menuid) {
		String hql="from RoleMenu where roleId=:roleId and menuId=:menuId";
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("roleId", roleid);
		map.put("menuId", menuid);
		Object obj=HQLTemplate.searchHql(hql,map);
		return obj==null?false:true;
	}

	@Override
	public List<Menu> getBefore(int roleid) {
		String hql="select menu from RoleMenu rm where rm.role.roleId=:roleId";
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("roleId", roleid);
		return HQLTemplate.searchHql(hql, map);
	}

	


}
