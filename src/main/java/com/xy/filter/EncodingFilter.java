package com.xy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xy.util.StringUtil;

public class EncodingFilter implements Filter{

	private String encoding="UTF-8";
	private boolean before=false;//是否response也要设定编码
	
	@Override
	public void destroy() {
		encoding=null;
		before=false;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		if(this.before){
			response.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		if(!StringUtil.isEmpty(config.getInitParameter("encoding"))){
			this.encoding=config.getInitParameter("encoding");
		}
		if(!StringUtil.isEmpty(config.getInitParameter("before"))){
			this.before=Boolean.parseBoolean(config.getInitParameter("before"));
		}
		
	}

}
