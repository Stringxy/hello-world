package rw_shop;

import org.junit.Test;

import com.xy.biz.AdminBiz;
import com.xy.biz.impl.AdminBizImpl;
import com.xy.entity.Admin;

public class testAdmin {

	@Test
	public void testLogin(){
		String name="admin";
		String pwd="admin1111";
		AdminBiz ab=new AdminBizImpl();
		Admin a=ab.login(name, pwd);
		System.out.println(a.getLoginName());
	}
}
