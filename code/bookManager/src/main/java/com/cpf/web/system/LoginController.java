package com.cpf.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpf.common.bean.ResponseBean;
import com.cpf.common.constant.CommonConstant;
import com.cpf.common.util.LogUtil;
import com.cpf.common.util.StringUtil;
import com.cpf.constant.WebConstant;
import com.cpf.service.system.BReaderService;
import com.cpf.service.system.ManagerService;

@Controller
public class LoginController
{
	
	@Autowired
	@Qualifier("bReaderService")
	private BReaderService bReaderService;
	
	@Autowired
	@Qualifier("managerService")
	private ManagerService managerService;
	
	/**
	 * 登录接口
	 * @param username
	 * @param passwrod
	 * @param type 0：读者登录，1：管理员登录
	 * @return
	 */
	@RequestMapping(value="/goLogining")
	@ResponseBody
	public Object goLogining(String username,String password,String type){
		try
		{
			if(StringUtil.isBlank(username)||StringUtil.isBlank(password)||StringUtil.isBlank(type)){
				return new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_PARAMETER_EMPTY);
			}
			String page=null;//TODO 跳转的页面
			Object user=null;
			if(WebConstant.MANAGER_ROLE_TYPE.equals(type)){
				user=this.managerService.retrieveManagerByUserName(username, password);
			}else if(WebConstant.READER_ROLE_TYPE.equals(type)) {
				user=this.bReaderService.retrieveBReaderByUserName(username, password);
			}else {
				return new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_PARAMETER_ERROR);
			}
			if(null==user){
				return new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_LOGIN_FAIL);
			}
			return new ResponseBean(CommonConstant.RESPONSE_CODE_200, CommonConstant.MSG_SUCCESS);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			LogUtil.logException("LoginController goLogining", e);
			return new ResponseBean(CommonConstant.RESPONSE_CODE_500,CommonConstant.MSG_FAIL);
		}
	}
}
