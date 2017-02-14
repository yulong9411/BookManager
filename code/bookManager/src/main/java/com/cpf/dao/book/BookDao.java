package com.cpf.dao.book;

import com.cpf.entity.book.Book;

public interface BookDao {
	
	/**
	 * 根据编号查询图书
	 * @param code
	 * @return 
	 */
	Book retrieveBookByCode(String code);
	
}
