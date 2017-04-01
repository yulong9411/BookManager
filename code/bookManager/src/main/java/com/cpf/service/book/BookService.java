package com.cpf.service.book;

import com.cpf.common.model.Pager;
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
	
	/**
	 * 检索图书
	 * @param pageNo 
	 * @param pageSize
	 * @param word 模糊查询字段
	 * @param categoryId 图书类型
	 * @return
	 */
	Pager retrieveBookBySearch(Integer pageNo,Integer pageSize,String word,Integer categoryId);

	void removeBook(Long id);
	
	void modifyBook(Book book);
	
	Book retrieveBookById(Long id);
}
