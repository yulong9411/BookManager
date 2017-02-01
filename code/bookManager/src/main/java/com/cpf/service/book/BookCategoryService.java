package com.cpf.service.book;

import com.cpf.entity.book.BookCategory;

public interface BookCategoryService
{
	boolean isBookCategoryExist(String type);
	BookCategory addBookCategory(String type);
}
