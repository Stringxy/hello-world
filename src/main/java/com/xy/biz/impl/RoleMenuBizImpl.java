package com.xy.biz.impl;

import java.util.List;

import com.xy.biz.RoleMenuBiz;
import com.xy.dao.RoleMenuDao;
import com.xy.dao.impl.RoleMenuDaoImpl;
import com.xy.entity.Menu;
import com.xy.entity.RoleMenu;

public class RoleMenuBizImpl extends CommonBizImpl<RoleMenu> implements RoleMenuBiz {
	private RoleMenuDao roledao=new RoleMenuDaoImpl();
	public RoleMenuBizImpl(){
		super.setCommonDao(roledao);
	}
	@Override
	public boolean isExists(int roleid, int menuid) {
		// TODO Auto-generated method stub
		return roledao.isExists(roleid, menuid);
	}
	@Override
	public List<Menu> getBefore(int roleid) {
		// TODO Auto-generated method stub
		return roledao.getBefore(roleid);
	}



}
