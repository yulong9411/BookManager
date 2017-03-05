package com.cpf.service.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cpf.common.model.Pager;
import com.cpf.common.service.BaseServiceImpl;
import com.cpf.entity.info.LogInfo;

@Service("logInfoService")
public class LogInfoServiceImpl extends BaseServiceImpl implements LogInfoService
{

	@Override
	public void addLogInfo(LogInfo logInfo)
	{
		this.addObject(logInfo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Pager getAllLogInfo(Integer pageNo,Integer pageSize)
	{
		List list=retrieveObjectAll(LogInfo.class);
		return getPager(pageNo, pageSize, list, null);
	}

	
	
}
