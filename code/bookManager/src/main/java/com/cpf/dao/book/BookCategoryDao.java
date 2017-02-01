package com.cpf.dao.book;

import java.util.List;

import com.cpf.entity.book.BookCategory;


public interface BookCategoryDao
{
	List<BookCategory> retrieveBookCategoryByName(String name);
}
