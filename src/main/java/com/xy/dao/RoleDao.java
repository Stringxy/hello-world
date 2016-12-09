package com.xy.dao;

import java.util.List;

import com.xy.entity.Role;

public interface RoleDao extends CommonDao<Role> {

	public List<Role> getAll();
	public List<String> getPerms(Role r);
}
