package com.cpf.service.book;

import org.springframework.stereotype.Service;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.entity.book.Book;

@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl implements BookService
{

	@Override
	public void addBook(Book book)
	{
		this.addObject(book);
	}

}
