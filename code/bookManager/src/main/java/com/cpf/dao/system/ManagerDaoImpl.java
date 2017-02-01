package com.cpf.dao.system;

import org.springframework.stereotype.Repository;

import com.cpf.common.dao.HibernateDaoUtil;
import com.cpf.common.util.StringUtil;
import com.cpf.entity.system.Manager;

@Repository("managerDao")
public class ManagerDaoImpl extends HibernateDaoUtil implements ManagerDao
{

	public Manager retrieveManagerByUserName(String username, String password)
	{
		StringBuilder sb=new StringBuilder();
		if(StringUtil.isNotBlank(username)&&StringUtil.isNotBlank(password)){
			sb.append("from Manager where username='")
			.append(username)
			.append("'")
			.append(" and password='")
			.append(password)
			.append("'");
			return (Manager) this.getCurrentSession().createQuery(sb.toString()).uniqueResult();
		}
		return null;
	}

}
