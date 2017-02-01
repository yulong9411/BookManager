package com.cpf.service.system;

import com.cpf.entity.system.Manager;

public interface ManagerService
{
	Manager retrieveManagerByUserName(String username,String password);
}	
