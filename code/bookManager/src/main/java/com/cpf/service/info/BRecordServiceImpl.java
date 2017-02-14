package com.cpf.service.info;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.common.util.DateUtil;
import com.cpf.constant.WebConstant;
import com.cpf.entity.book.Book;
import com.cpf.entity.info.BRecord;
import com.cpf.entity.system.BReader;

@Service("bRecordService")
public class BRecordServiceImpl extends BaseServiceImpl implements BRecordService {

	@Override
	public void addBRecord(Book book, BReader reader,String type) {
		Date now=new Date();
		BRecord record=new BRecord(book, reader, now, WebConstant.IS_RENEW_NO
				, DateUtil.getNextDate(now, WebConstant.BORROW_TIME), type, WebConstant.HAS_DELETE_NO);
		this.addObject(record);
	}

}
