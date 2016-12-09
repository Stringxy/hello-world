package com.xy.dao;

import com.xy.entity.Admin;
import com.xy.entity.Role;

public interface AdminDao extends CommonDao<Admin> {

	public Admin login(String name,String pwd);
	public Role getRole(String name);
}
