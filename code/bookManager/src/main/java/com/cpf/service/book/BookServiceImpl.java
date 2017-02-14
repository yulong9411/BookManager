package com.cpf.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.dao.book.BookDao;
import com.cpf.entity.book.Book;

@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl implements BookService
{
	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
	
	public void addBook(Book book)
	{
		this.addObject(book);
	}


	@Override
	public Book retrieveBookByCode(String code) {
		return this.bookDao.retrieveBookByCode(code);
	}

	
	
}
