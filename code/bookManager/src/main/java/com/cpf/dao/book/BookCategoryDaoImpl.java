package com.cpf.dao.book;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cpf.common.dao.HibernateDaoUtil;
import com.cpf.entity.book.BookCategory;

@Repository("bookCategoryDao")
public class BookCategoryDaoImpl extends HibernateDaoUtil implements BookCategoryDao
{

	@SuppressWarnings("unchecked")
	public List<BookCategory> retrieveBookCategoryByName(String name)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("from BookCategory c where 1=1");
		if (name!=null)
		{
			sb.append(" and c.type='")
			.append(name)
			.append("'");
		}
		return this.getCurrentSession().createQuery(sb.toString()).list();
	}


}
