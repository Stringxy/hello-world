package rw_shop;

import java.util.List;

import org.junit.Test;

import com.xy.biz.MenuBiz;
import com.xy.biz.impl.MenuBizImpl;
import com.xy.entity.Menu;

public class testMenu {

	@Test
	public void testFindAll(){
		MenuBiz menubiz=new MenuBizImpl();
		Menu m=menubiz.findById(3);
		System.out.println(menubiz.hasChild(m)!=null&&menubiz.hasChild(m).size()>0);
		List<Menu>c=menubiz.hasChild(m);
		for(Menu a:c){
			System.out.println(a.getName());
		}
	}
}
