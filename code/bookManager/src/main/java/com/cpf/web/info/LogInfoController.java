package com.cpf.web.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpf.common.bean.ResponseBean;
import com.cpf.common.constant.CommonConstant;
import com.cpf.common.model.Pager;
import com.cpf.common.util.LogUtil;
import com.cpf.service.info.LogInfoService;

@Controller
@RequestMapping(value="/log_info")
public class LogInfoController
{
	@Autowired
	@Qualifier("logInfoService")
	LogInfoService logInfoService;
	
	@RequestMapping(value="getAllLogInfo",method=RequestMethod.GET)
	@ResponseBody
	public Object getAllLogInfo(Integer pageNo,Integer pageSize){
		try
		{
			Pager pager=logInfoService.getAllLogInfo(pageNo, pageSize);
			return new ResponseBean(CommonConstant.RESPONSE_CODE_200, CommonConstant.MSG_SUCCESS, pager);
		} catch (Exception e)
		{
			e.printStackTrace();
			LogUtil.logException("LogInfoController getAllLogInfo", e);
			return new ResponseBean(CommonConstant.RESPONSE_CODE_500, CommonConstant.MSG_FAIL);
		}
	}
}
