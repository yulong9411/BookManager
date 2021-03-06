package com.cpf.service.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cpf.common.model.Pager;
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
		addObject(book);
	}


	@Override
	public Book retrieveBookByCode(String code) {
		return this.bookDao.retrieveBookByCode(code);
	}


	@Override
	public Pager retrieveBookBySearch(Integer pageNo, Integer pageSize, String word, Integer categoryId)
	{
		List<Book> list=bookDao.retrieveBookBySearch(word, categoryId);
		return getPager(pageNo, pageSize, list, null);
	}


	@Override
	public void removeBook(Long id)
	{
		removeObject(Book.class, id);
	}


	@Override
	public void modifyBook(Book book)
	{
		modifyObject(book);
	}


	@Override
	public Book retrieveBookById(Long id)
	{
		return (Book) retrieveAnObject(Book.class, id);
	}

	
	
}
