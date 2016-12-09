package com.xy.action.permission;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;





import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xy.biz.MenuBiz;
import com.xy.biz.RoleMenuBiz;
import com.xy.biz.impl.MenuBizImpl;
import com.xy.biz.impl.RoleMenuBizImpl;
import com.xy.entity.Menu;
import com.xy.util.StringUtil;

public class MenuAction implements Action {
	private MenuBiz menubiz=new MenuBizImpl();
	private StringBuffer sbf=null;
	private StringBuffer selectParent=null;
	private Integer id;
	private String menuname;
	private String url;
	private Integer parentId;
	private Integer menutype;
	private Integer state;
	private Integer sortno;
	private String perms;
	private Integer roleid;
	private RoleMenuBiz rolemenubiz=new RoleMenuBizImpl();
	
	
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		if(StringUtil.isNumeric(roleid.toString())&&roleid!=null&&roleid>0){
		this.roleid = roleid;
		}
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getMenutype() {
		return menutype;
	}

	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String search(){
		
		List<Menu> menus=menubiz.findSuper();
		this.sbf=new StringBuffer();
		this.selectParent=new StringBuffer();
		for(int i=0;i<menus.size();i++){
			Menu m=menus.get(i);
			sbf.append("\t <tr data-tt-id=\""+(i+1)+"\" > \n");
			sbf.append("\t\t <td >"+m.getId()+"</td> \n");
			sbf.append("\t\t <td>"+m.getName()+"</td> \n");
			sbf.append("\t\t <td>"+m.getPageurl()+"</td> \n");
			if(m.getType()==0){
				sbf.append("\t\t <td>按钮</td> \n");
			}else{
				sbf.append("\t\t <td>导航菜单</td> \n");
			}
			if(m.getState()==0){
				sbf.append("\t\t <td>否</td> \n");
			}else{
				sbf.append("\t\t <td>是</td> \n");
			}
			sbf.append("\t\t <td>"+m.getState()+"</td> \n");
			sbf.append("\t\t <td>"+m.getPerms()+"</td> \n");
			sbf.append("\t\t <td><a href=\"javascript:void(0)\" onclick=\"edit(this)\" >修改</a> </td> \n");
			sbf.append("\t </tr> \n");			
			selectParent.append("\t\t <option value=\""+m.getId()+"\">"+m.getName()+"</option> \n");
			if(menubiz.hasChild(m)!=null){
				this.getChilds(m,String.valueOf(i+1),new StringBuffer("--|"));
			}
			
		}
		
		ActionContext.getContext().getSession().put("table", sbf.toString());
		ActionContext.getContext().getSession().put("select", selectParent.toString());
		return "search";
	}
	
	private void getChilds(Menu m,String id,StringBuffer sign){
		List<Menu>childs=menubiz.hasChild(m);

		for(int i=0;i<childs.size();i++){
			
			this.sbf.append("\t <tr data-tt-id=\""+id+"-"+(i+1)+"\"  data-tt-parent-id=\""+id+"\"> \n");
			Menu child=childs.get(i);
			this.sbf.append("\t\t <td >"+child.getId()+"</td> \n");
			this.sbf.append("\t\t <td>"+child.getName()+"</td> \n");
			this.sbf.append("\t\t <td>"+child.getPageurl()+"</td> \n");
			if(child.getType()==0){
				this.sbf.append("\t\t <td>按钮</td> \n");
			}else{
				this.sbf.append("\t\t <td>导航菜单</td> \n");
			}
			if(child.getState()==0){
				this.sbf.append("\t\t <td>否</td> \n");
			}else{
				this.sbf.append("\t\t <td>是</td> \n");
			}
			this.sbf.append("\t\t <td>"+child.getState()+"</td> \n");
			this.sbf.append("\t\t <td>"+child.getPerms()+"</td> \n");
			sbf.append("\t\t <td><a href=\"javascript:void(0)\" onclick=\"edit(this)\" >修改</a> </td> \n");
			this.sbf.append("\t </tr> \n");
			this.selectParent.append("\t\t <option value=\""+child.getId()+"\">"+sign.toString()+child.getName()+"</option> \n");

			if(menubiz.hasChild(child)!=null&&menubiz.hasChild(child).size()>0){
				this.getChilds(child,id+"-"+(i+1),new StringBuffer(sign.toString()+"--|"));
			}
		}
	}

	public void save(){
		HttpServletResponse response=ServletActionContext.getResponse();  
		/* 
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
		 * */  
		response.setContentType("text/html;charset=utf-8");  
		response.setCharacterEncoding("UTF-8");  
		System.out.println(menuname);
		JSONObject json=new JSONObject();
		String message="";
		boolean success=false;
		if(id==null){
			Menu m=new Menu();
			m.setName(menuname);
			m.setPageurl(url);
			m.setParentId(parentId);
			m.setPerms(perms);
			m.setSortno(sortno);
			m.setState(state);
			m.setType(menutype);
			menubiz.insert(m);
			success=true;
			message=success?"新增成功！":"新增失败！";
		}else{
			Menu m=menubiz.findById(id);
			m.setName(menuname);
			m.setPageurl(url);
			m.setParentId(parentId);
			m.setPerms(perms);
			m.setSortno(sortno);
			m.setState(state);
			m.setType(menutype);
			menubiz.update(m);
			success=true;
			message=success?"修改成功！":"修改失败！";
		}
		
		System.out.println(message);
		json.put("success", success);
		json.put("message",message);
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

	public void getTree(){
		JSONArray json=new JSONArray();
		List<Menu> all=menubiz.findAll();
		List<Menu> before=rolemenubiz.getBefore(roleid);

		for(Menu m:all){
			JSONObject obj=new JSONObject();
			obj.put("id", m.getId());
			obj.put("pId", m.getParentId());
			obj.put("name", m.getName());
			
			if(before.contains(m)){
				obj.put("checked", "true");
			}
			json.add(obj);
		}
		HttpServletResponse response=ServletActionContext.getResponse();  
	    /* 
	     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
	     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
	     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
	     * */  
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
	

}
