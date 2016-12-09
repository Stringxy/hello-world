package com.xy.biz;

import java.util.List;

import com.xy.entity.Role;

public interface RoleBiz extends CommonBiz<Role> {

	public List<Role> getAll();
	public List<String> getPerms(Role r);
}
