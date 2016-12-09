package com.xy.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xy.biz.AdminBiz;
import com.xy.biz.RoleBiz;
import com.xy.biz.impl.AdminBizImpl;
import com.xy.biz.impl.RoleBizImpl;
import com.xy.entity.Admin;
import com.xy.entity.Role;

public class AdminPermissionRealm extends AuthorizingRealm{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "adminRealm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return token instanceof UsernamePasswordToken;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username=(String)getAvailablePrincipal(principals);
		AdminBiz ab=new AdminBizImpl();
		Role r=ab.getRole(username);

		RoleBiz rolebiz=new RoleBizImpl();
		Set<String>parms=new HashSet<String>();
			parms.addAll(rolebiz.getPerms(r));

		SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
		info.addRole(r.getRoleName());
		info.setStringPermissions(parms);
		return info;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String username=token.getPrincipal().toString();
		String password=new String((char[])token.getCredentials());
		
		AdminBiz adminbiz=new AdminBizImpl();
		Admin a=adminbiz.login(username, password);
		if(a==null){
			throw new UnknownAccountException();
		}
		
		if(a.getState()==0){
			throw new AuthenticationException();
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
