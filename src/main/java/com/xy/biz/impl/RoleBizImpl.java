package com.xy.biz.impl;

import java.util.List;

import com.xy.biz.RoleBiz;
import com.xy.dao.RoleDao;
import com.xy.dao.impl.RoleDaoImpl;
import com.xy.entity.Role;

public class RoleBizImpl extends CommonBizImpl<Role> implements RoleBiz {

	private RoleDao roleDao=new RoleDaoImpl();
	public RoleBizImpl(){
		super.setCommonDao(roleDao);
	}
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleDao.getAll();
	}
	@Override
	public List<String> getPerms(Role r) {
		// TODO Auto-generated method stub
		return roleDao.getPerms(r);
	}
}
