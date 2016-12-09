package com.xy.dao;

import java.util.List;

import com.xy.entity.Menu;

public interface MenuDao extends CommonDao<Menu> {

	public List<Menu> findSuper();
	public List<Menu> hasChild(Menu m);
	public List<Menu> findAll();
}
