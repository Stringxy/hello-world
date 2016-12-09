package com.xy.biz.impl;

import com.xy.biz.AdminBiz;
import com.xy.dao.AdminDao;
import com.xy.dao.impl.AdminDaoImpl;
import com.xy.entity.Admin;
import com.xy.entity.Role;

public class AdminBizImpl extends CommonBizImpl<Admin> implements AdminBiz {
	private AdminDao adminDao=new AdminDaoImpl();
	public AdminBizImpl(){
		super.setCommonDao(adminDao);
	}
	@Override
	public Admin login(String name, String pwd) {
		// TODO Auto-generated method stub
		return adminDao.login(name, pwd);
	}
	@Override
	public Role getRole(String name) {
		// TODO Auto-generated method stub
		return adminDao.getRole(name);
	}
	@Override
	public boolean isValid(String loginname) {
		return adminDao.getRole(loginname)==null;
	}

}
