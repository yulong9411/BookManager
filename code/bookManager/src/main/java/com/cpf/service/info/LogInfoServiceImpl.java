package com.cpf.service.info;

import org.springframework.stereotype.Service;

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

}
