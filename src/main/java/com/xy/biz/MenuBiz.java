package com.xy.biz;

import java.util.List;

import com.xy.entity.Menu;

public interface MenuBiz extends CommonBiz<Menu> {

	public List<Menu> findSuper();
	public List<Menu> hasChild(Menu m);
	public List<Menu> findAll();
}
