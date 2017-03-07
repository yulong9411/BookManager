package com.cpf.dao.book;

import java.util.List;

import com.cpf.entity.book.Book;

public interface BookDao {
	
	/**
	 * 根据编号查询图书
	 * @param code
	 * @return 
	 */
	Book retrieveBookByCode(String code);
	
	/**
	 * 查询图书列表
	 * @param word 关键字
	 * @param categoryId 图书类型
	 * @return
	 */
	List<Book> retrieveBookBySearch(String word,Integer categoryId);
}
