package com.xy.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xy.dao.AdminDao;
import com.xy.entity.Admin;
import com.xy.entity.Role;
import com.xy.util.PageUtil;

public class AdminDaoImpl extends CommonDaoImpl<Admin> implements AdminDao {

	@Override
	public List<Admin> searchPaging(Map<String, Object> params,
			PageUtil<Admin> paging) {
		StringBuffer hql = new StringBuffer("from Admin where 1=1 ");
		if (params != null) {
			if (params.containsKey("roleId")) {
				hql.append(" and role.roleId=:roleId");
			}
		}
		hql.append(" order by adminId ");
		return HQLTemplate.searchHql(hql.toString(), params, paging);
	}

	@Override
	public int searchPagingCount(Map<String, Object> params) {
		StringBuffer hql = new StringBuffer(
				"select count(*) from Admin where 1=1 ");
		if (params != null) {
			if (params.containsKey("roleId")) {
				hql.append(" and role.roleId=:roleId");
			}
		}
		return HQLTemplate.searchCount(hql.toString(), params);
	}

	@Override
	public Admin login(String name, String pwd) {
		String hql = "from Admin where loginName=:loginName and loginPwd=:loginPwd";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", name);
		params.put("loginPwd", pwd);
		Object obj = HQLTemplate.searchUnique(hql, params);

		return obj == null ? null : (Admin) obj;
	}

	@Override
	public Role getRole(String name) {
		String hql = "select role from Admin where loginName=:loginName";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", name);
		Object obj = HQLTemplate.searchUnique(hql, params);
		return obj == null ? null : (Role) obj;
	}

}
