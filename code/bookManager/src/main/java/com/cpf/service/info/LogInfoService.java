package com.cpf.service.info;

import com.cpf.common.model.Pager;
import com.cpf.entity.info.LogInfo;

public interface LogInfoService
{
	void addLogInfo(LogInfo logInfo);
	
	Pager getAllLogInfo(Integer pageNo,Integer pageSize);
}
