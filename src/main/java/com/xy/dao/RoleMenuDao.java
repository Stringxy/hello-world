package com.xy.dao;

import java.util.List;

import com.xy.entity.Menu;
import com.xy.entity.RoleMenu;

public interface RoleMenuDao extends CommonDao<RoleMenu> {
	public boolean isExists(int roleid,int menuid);
	public List<Menu> getBefore(int roleid);

}
