package com.cpf.service.info;

import com.cpf.entity.book.Book;
import com.cpf.entity.system.BReader;

public interface BRecordService {
	void addBRecord(Book book,BReader reader);
}
