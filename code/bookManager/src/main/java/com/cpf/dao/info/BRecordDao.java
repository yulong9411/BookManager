package com.cpf.dao.info;

import java.util.List;

import com.cpf.entity.info.BRecord;
import com.cpf.entity.system.BReader;

public interface BRecordDao
{
	/**
	 * 
	 * @param reader
	 * @param type 记录类型，借阅或预订
	 * @return
	 */
	List<BRecord> retrieveBRecordByReader(BReader reader,String type);
}
