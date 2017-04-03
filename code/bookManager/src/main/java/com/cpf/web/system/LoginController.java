package com.cpf.web.system;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value="goLogining")
	public ModelAndView goLogining(HttpSession session,String username,String password,String type){
		ResponseBean bean=null;
		ModelAndView mv=new ModelAndView();
		try
		{
			if(StringUtil.isBlank(username)||StringUtil.isBlank(password)||StringUtil.isBlank(type)){
				bean=new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_PARAMETER_EMPTY);
			}
			String page=null;//TODO 跳转的页面
			Object user=null;
			if(WebConstant.MANAGER_ROLE_TYPE.equals(type)){
				user=this.managerService.retrieveManagerByUserName(username, password);
				page=WebConstant.VIEW_MANAGER_INDEX;
				session.setAttribute(WebConstant.SESSION_KEY_MANAGER, user);
			}else if(WebConstant.READER_ROLE_TYPE.equals(type)) {
				user=this.bReaderService.retrieveBReaderByUserName(username, password);
				page=WebConstant.VIEW_USER_INDEX;
				session.setAttribute(WebConstant.SESSION_KEY_READER, user);
			}else {
				bean=new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_PARAMETER_ERROR);
			}
			if(null==user){
				bean= new ResponseBean(CommonConstant.RESPONSE_CODE_400, CommonConstant.MSG_LOGIN_FAIL);
			}
			bean= new ResponseBean(CommonConstant.RESPONSE_CODE_200, CommonConstant.MSG_SUCCESS,page);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			LogUtil.logException("LoginController goLogining", e);
			bean= new ResponseBean(CommonConstant.RESPONSE_CODE_500,CommonConstant.MSG_FAIL);
		}
		mv.setViewName(WebConstant.VIEW_LOGIN_CONTROL);
		mv.addObject(CommonConstant.KEY_RESPONSEBEAN, bean);
		return mv;
	}
}
