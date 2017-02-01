package com.cpf.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.dao.system.BReaderDao;
import com.cpf.entity.system.BReader;

@Repository("bReaderService")
public class BReaderServiceImpl extends BaseServiceImpl implements BReaderService
{

	@Autowired
	@Qualifier("bReaderDao")
	private BReaderDao bReaderDao;
	
	public BReader retrieveBReaderByUserName(String userName, String password)
	{
		return this.bReaderDao.retrieveBReaderByUsername(userName, password);
	}

}
