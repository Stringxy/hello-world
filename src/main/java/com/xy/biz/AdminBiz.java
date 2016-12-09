package com.xy.biz;

import com.xy.entity.Admin;
import com.xy.entity.Role;

public interface AdminBiz extends CommonBiz<Admin> {

	public Admin login(String name,String pwd);
	public Role getRole(String name);
	public boolean isValid(String loginname);
}
