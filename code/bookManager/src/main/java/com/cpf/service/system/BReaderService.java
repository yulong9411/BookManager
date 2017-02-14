package com.cpf.service.system;

import com.cpf.entity.system.BReader;

public interface BReaderService
{
	BReader retrieveBReaderByUserName(String userName,String password);
	BReader retrieveBReaderById(Long id);
}
