package com.cpf.service.info;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.common.util.DateUtil;
import com.cpf.constant.WebConstant;
import com.cpf.entity.book.Book;
import com.cpf.entity.info.BRecord;
import com.cpf.entity.system.BReader;

public class BRecordServiceImpl extends BaseServiceImpl implements BRecordService {

	@Override
	public void addBRecord(Book book, BReader reader) {
		Date now=new Date();
		BRecord record=new BRecord(book, reader, now, WebConstant.IS_RENEW_NO
				, DateUtil.getNextDate(now, WebConstant.BORROW_TIME), null, WebConstant.HAS_DELETE_NO);
		
	}

}
