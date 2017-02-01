package com.cpf.dao.system;

import com.cpf.entity.system.Manager;

public interface ManagerDao
{
	Manager retrieveManagerByUserName(String username,String password);
}
