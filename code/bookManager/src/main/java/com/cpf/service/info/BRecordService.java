package com.cpf.service.info;

import com.cpf.common.model.Pager;
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
	
	/**
	 * 
	 * @param reader
	 * @param type 记录类型，借阅或预订
	 * @return
	 */
	Pager retrieveBRecord(Integer pageNo,Integer pageSize,BReader reader,String type);
}
