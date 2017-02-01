package com.cpf.dao.system;

import com.cpf.entity.system.BReader;

public interface BReaderDao
{
	public BReader retrieveBReaderByUsername(String username,String password);
}
