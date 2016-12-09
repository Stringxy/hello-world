package com.xy.biz.impl;

import java.util.List;

import com.xy.biz.MenuBiz;
import com.xy.dao.MenuDao;
import com.xy.dao.impl.MenuDaoImpl;
import com.xy.entity.Menu;

public class MenuBizImpl extends CommonBizImpl<Menu> implements MenuBiz {

	private MenuDao menudao=new MenuDaoImpl();
	
	public MenuBizImpl(){
		super.setCommonDao(menudao);
	}

	@Override
	public List<Menu> findSuper() {
		// TODO Auto-generated method stub
		return this.menudao.findSuper();
	}

	@Override
	public List<Menu> hasChild(Menu m) {
		// TODO Auto-generated method stub
		return this.menudao.hasChild(m);
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return this.menudao.findAll();
	}

}
