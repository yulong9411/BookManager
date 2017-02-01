package com.cpf.util;

import com.cpf.common.util.RandUtil;

public class CodeUtil
{
	public static String createCode(String isbn){
		StringBuffer sb=new StringBuffer();
		sb.append(isbn.substring(isbn.length()/2));
		sb.append(RandUtil.randStr(4));
		return sb.toString();
	}
	
	
}
