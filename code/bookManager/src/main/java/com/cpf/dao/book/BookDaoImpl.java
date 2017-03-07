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

	@Override
	public List<Book> retrieveBookBySearch(String word, Integer categoryId)
	{
		Criteria c=getCurrentSession().createCriteria(Book.class);
		if(StringUtil.isNotBlank(word)){
			c.add(Restrictions.like("title", word));
		}
		if(categoryId!=null){
			c.add()
		}
		return null;
	}

}
