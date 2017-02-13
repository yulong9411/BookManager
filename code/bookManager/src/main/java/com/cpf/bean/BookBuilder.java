package com.cpf.bean;

import java.lang.reflect.Method;

import com.cpf.common.util.LogUtil;
import com.cpf.common.util.StringUtil;
import com.cpf.constant.BookValueEnum;
import com.cpf.constant.WebConstant;
import com.cpf.entity.book.Book;

public class BookBuilder
{
	private Book book=null;
	public BookBuilder(){
		book=new Book();
		book.setHasDelete(WebConstant.HAS_DELETE_NO);
	}
	
	public Book toBook(){
		return book;
	}
	
	@SuppressWarnings("rawtypes")
	public BookBuilder setValue(BookValueEnum valueName,Object value){
		StringBuilder sb=new StringBuilder();
		sb=getSetter(sb, valueName);
		Class clazz=Book.class;
		Method[] methods=clazz.getMethods();
		for (Method m : methods)
		{
			String methodName=m.getName();
			if (methodName.equals(sb.toString()))
			{
				try
				{
					m.invoke(book, value);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					LogUtil.logException("BookBuilder setValue", e);
				}
			}
		}
		return this;
	}
	
	private StringBuilder getSetter(StringBuilder sb,BookValueEnum valueName){
		String[] keys=valueName.name().toLowerCase().split("_");
		sb.append("set");
		for (String s : keys) {
			sb.append(StringUtil.upperFirstChar(s));
		}
		return sb;
	}
	
	
}
