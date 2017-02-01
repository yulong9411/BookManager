package com.cpf.bean;

import java.lang.reflect.Method;

import com.cpf.common.util.LogUtil;
import com.cpf.constant.BookValue;
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
	public BookBuilder setValue(BookValue valueName,Object value){
		StringBuilder sb=new StringBuilder("set");
		String key=valueName.name().toLowerCase();
		sb.append(key.substring(0, 1).toUpperCase());
		sb.append(key.substring(1));
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
}
