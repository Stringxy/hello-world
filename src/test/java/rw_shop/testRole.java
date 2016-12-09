package rw_shop;

import java.util.List;

import org.junit.Test;

import com.xy.biz.RoleBiz;
import com.xy.biz.impl.RoleBizImpl;
import com.xy.entity.Role;
import com.xy.util.PageUtil;

public class testRole {
	@Test
	public void testInsert(){
		RoleBiz rolebiz=new RoleBizImpl();
		Role r=new Role();
		r.setRoleName("小李");
		rolebiz.insert(r);
	}
	@Test
	public void testQuery(){
		RoleBiz rolebiz=new RoleBizImpl();
		PageUtil<Role> paging=new PageUtil<Role>();
		rolebiz.searchPaging(null,paging);
		for(Role r:paging.getData()){
			System.out.println(r.getRoleName());
		}
	}
}
