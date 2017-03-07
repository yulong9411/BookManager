package com.cpf.dao.info;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cpf.common.dao.BaseDaoImpl;
import com.cpf.common.util.StringUtil;
import com.cpf.constant.WebConstant;
import com.cpf.entity.info.BRecord;
import com.cpf.entity.system.BReader;

@Repository("bRecordDao")
public class BRecordDaoImpl extends BaseDaoImpl implements BRecordDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<BRecord> retrieveBRecordByReader(BReader reader, String type)
	{
		Criteria c=getCurrentSession().createCriteria(BRecord.class);
		c.add(Restrictions.eq("reader", reader))
		.add(Restrictions.eq("hasDelete", WebConstant.HAS_DELETE_NO));
		if(StringUtil.isNotBlank(type)){
			c.add(Restrictions.eq("type", type));
		}
		return c.list();
	}

}
