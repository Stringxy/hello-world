package com.xy.action.permission;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xy.biz.AdminBiz;
import com.xy.biz.RoleBiz;
import com.xy.biz.impl.AdminBizImpl;
import com.xy.biz.impl.RoleBizImpl;
import com.xy.entity.Admin;
import com.xy.entity.Role;
import com.xy.util.PageUtil;
import com.xy.util.StringUtil;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	private AdminBiz ab = new AdminBizImpl();
	private PageUtil<Admin> paging = new PageUtil<Admin>();
	private Admin admin = null;
	private Integer roleId;
	private RoleBiz rolebiz=new RoleBizImpl();

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		if (roleId != null && StringUtil.isNumeric(roleId.toString())) {
			this.roleId = roleId;
		}
	}

	public void setPage(Integer page) {
		if (page != null && page > 0) {
			paging.setPage(page);
		}
	}

	public void setRows(Integer rows) {
		if (rows != null && rows > 0) {
			paging.setRows(rows);
		}
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String search() {
		AdminBiz ab = new AdminBizImpl();
		ab.searchPaging(null, paging);
		RoleBiz rolebiz=new RoleBizImpl();
		List<Role>all=rolebiz.getAll();
		ActionContext.getContext().getSession().put("roles", all);
		ActionContext.getContext().getSession().put("paging", paging);
		return "search";
	}

	public void valid() {
		JSONObject json = new JSONObject();
		Admin old = ab.findById(admin.getAdminId());
		if (old.getLoginName() == admin.getLoginName()) {
			json.put("valid", true);
		} else {

			json.put("valid", ab.isValid(admin.getLoginName()));
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		/*
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码),
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。
		 */
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Admin getModel() {
		if (admin == null) {
			admin = new Admin();
		}
		return admin;
	}

	public void save() {
		HttpServletResponse response = ServletActionContext.getResponse();
		/*
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码),
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。
		 */
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		admin.setRole(rolebiz.findById(roleId));
		if (admin.getAdminId() == null) {
			try {
				
				ab.insert(admin);
				json.put("success", true);
				json.put("message", "新增成功");
			} catch (Exception e) {
				
				json.put("success", false);
				json.put("message", "新增失败");
			}
		} else {
			try {
				
				ab.update(admin);
				json.put("success", true);
				json.put("message", "修改成功");

			} catch (Exception e) {
				
				json.put("success", false);
				json.put("message", "修改失败");
			}
		}
		try {
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
