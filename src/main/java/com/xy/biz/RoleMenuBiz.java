package com.xy.biz;

import java.util.List;

import com.xy.entity.Menu;
import com.xy.entity.RoleMenu;

public interface RoleMenuBiz extends CommonBiz<RoleMenu> {
	public boolean isExists(int roleid,int menuid);
	public List<Menu> getBefore(int roleid);

}
