package com.cpf.dao.book;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cpf.common.dao.BaseDaoImpl;
import com.cpf.common.util.StringUtil;
import com.cpf.entity.book.Book;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl implements BookDao {

	@Override
	public Book retrieveBookByCode(String code) {
		Criteria c=this.getCurrentSession().createCriteria(Book.class);
		c.add(Restrictions.eq("code", code));
		return (Book) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> retrieveBookBySearch(String word, Integer categoryId)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("select b.* from book b,book_category_relation br where 1=1");
		if(StringUtil.isNotBlank(word)){
			sb.append(" and (b.title like '%")
			.append(word)
			.append("%'")
			.append(" or b.author like '%")
			.append(word)
			.append("%'");
			sb.append(")");
		}
		if (null!=categoryId)
		{
			sb.append(" and b.id=br.bookId and br.categoryId=").append(categoryId);
		}
		return getCurrentSession().createSQLQuery(sb.toString()).addEntity(Book.class).list();
	}

}
