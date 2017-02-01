package com.cpf.dao.system;

import org.springframework.stereotype.Repository;

import com.cpf.common.dao.HibernateDaoUtil;
import com.cpf.common.util.StringUtil;
import com.cpf.entity.system.BReader;

@Repository("bReaderDao")
public class BReaderDaoImpl extends HibernateDaoUtil implements BReaderDao
{

	public BReader retrieveBReaderByUsername(String username, String password)
	{
		StringBuilder sb=new StringBuilder();
		if(StringUtil.isNotBlank(username)&&StringUtil.isNotBlank(password)){
			sb.append("from BReader where readerId='")
			.append(username)
			.append("'")
			.append(" and password='")
			.append(password)
			.append("'");
			return (BReader) this.getCurrentSession().createQuery(sb.toString()).uniqueResult();
		}
		return null;
	}

}
