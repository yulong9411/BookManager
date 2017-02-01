package com.cpf.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cpf.common.service.BaseServiceImpl;
import com.cpf.dao.system.ManagerDao;
import com.cpf.entity.system.Manager;

@Repository("managerService")
public class ManagerServiceImpl extends BaseServiceImpl implements ManagerService
{
	@Autowired
	@Qualifier("managerDao")
	private ManagerDao managerDao;
	
	
	@Override
	public Manager retrieveManagerByUserName(String username, String password)
	{
		return this.managerDao.retrieveManagerByUserName(username, password);
	}
}
