package com.cpf.service.book;

import com.cpf.entity.book.Book;

public interface BookService
{
	void addBook(Book book);
	
	/**
	 * 根据编码查询图书
	 * @param code
	 * @return 图书对象or null
	 */
	Book retrieveBookByCode(String code);
}
