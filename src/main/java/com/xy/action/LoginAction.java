package com.xy.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.opensymphony.xwork2.ActionSupport;
import com.xy.util.StringUtil;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	private boolean rememberme;
	
	public boolean isRememberme() {
		return rememberme;
	}

	public void setRememberme(boolean rememberme) {
		this.rememberme = rememberme;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password,rememberme);
		try {
			subject.login(token);
			
		} catch(UnknownAccountException e){
			super.addFieldError("tips", "用户名或者密码错误!");

			return INPUT;
		}catch (IncorrectCredentialsException e) {
			super.addFieldError("tips", "用户名或者密码错误!");

			return INPUT;
		}catch(AuthenticationException  e){
			super.addFieldError("tips", "账户被锁定!");

			return INPUT;
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
		if(StringUtil.isEmpty(username)){
			super.addFieldError("username", "用户名不能为空");
		}
		if(StringUtil.isEmpty(password)){
			super.addFieldError("password", "密码不能为空");
		}
	}

}
