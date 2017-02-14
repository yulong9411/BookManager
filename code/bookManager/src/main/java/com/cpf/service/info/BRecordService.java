package com.cpf.service.info;

import com.cpf.entity.book.Book;
import com.cpf.entity.system.BReader;

public interface BRecordService {
	/**
	 * 添加记录
	 * @param book
	 * @param reader
	 * @param type 0借阅记录，1预订记录
	 */
	void addBRecord(Book book,BReader reader,String type);
}
