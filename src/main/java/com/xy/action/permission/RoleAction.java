package com.xy.action.permission;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xy.biz.MenuBiz;
import com.xy.biz.RoleBiz;
import com.xy.biz.RoleMenuBiz;
import com.xy.biz.impl.MenuBizImpl;
import com.xy.biz.impl.RoleBizImpl;
import com.xy.biz.impl.RoleMenuBizImpl;
import com.xy.entity.Menu;
import com.xy.entity.Role;
import com.xy.entity.RoleMenu;
import com.xy.util.PageUtil;

public class RoleAction implements Action {
	private String jsonArray;
	private Integer roleid = -1;
	private RoleBiz rolebiz = new RoleBizImpl();
	public String getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(String jsonArray) {
		this.jsonArray = jsonArray;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		if (roleid != null && roleid > 0) {
			this.roleid = roleid;
		}
	}

	private PageUtil<Role> paging = new PageUtil<>();

	public void setPage(Integer page) {
		if (page != null && page > 0) {
			this.paging.setPage(page);
		}
	}

	public void setRows(Integer rows) {
		if (rows != null && rows > 0) {
			this.paging.setRows(rows);
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String search() {

		RoleBiz rolebiz = new RoleBizImpl();
		rolebiz.searchPaging(null, paging);



		ActionContext.getContext().getSession().put("paging", paging);
		return "search";
	}

	public String setPermission() {
		RoleMenuBiz biz = new RoleMenuBizImpl();
		List<Menu> before = biz.getBefore(roleid);

		MenuBiz menubiz = new MenuBizImpl();
		JSONArray jsonarray = JSONArray.fromObject(jsonArray);

		for (int i = 0; i < jsonarray.size(); i++) {
			JSONObject obj = jsonarray.getJSONObject(i);
			int menuId = obj.getInt("id");
			Menu changed=menubiz.findById(menuId);
			RoleMenu rm = new RoleMenu();
			
			rm.setRole(rolebiz.findById(roleid));
			
			rm.setMenu(changed);
			if(before.contains(changed)){
				biz.delete(rm);
			}else{
				
				biz.insert(rm);
			}
		}
		return "getPermission";
	}
	

}
