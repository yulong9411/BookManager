package com.cpf.dao.book;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cpf.common.dao.BaseDaoImpl;
import com.cpf.entity.book.Book;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl implements BookDao {

	@Override
	public Book retrieveBookByCode(String code) {
		Criteria c=this.getCurrentSession().createCriteria(Book.class);
		c.add(Restrictions.eq("code", code));
		return (Book) c.uniqueResult();
	}

}
