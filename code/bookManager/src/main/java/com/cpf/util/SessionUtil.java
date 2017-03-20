package com.cpf.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtil
{
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes arr=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		return arr.getRequest();
	}
	
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
}
