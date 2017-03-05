package com.cpf.aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cpf.constant.WebConstant;
import com.cpf.entity.info.LogInfo;
import com.cpf.service.info.LogInfoService;

/**
 * 处理日志切入点
 * @author CPF
 *
 */
public class LogAspect
{
	@Autowired
	@Qualifier("logInfoService")
	private LogInfoService logInfoService;
	
	@Pointcut("@annotation(com.cpf.aop.LogMark)")
	public void joinPoint(){}
	
	/**
	 * joinPoint方法执行后添加操作日志
	 * @param joinPoint
	 * @param returnValue
	 */
	@AfterReturning(pointcut="joinPoint",returning="returnValue")
	public void afterReturning(JoinPoint joinPoint,Object returnValue){
		LogInfo logInfo=new LogInfo();
		logInfo=fillLogInfo(joinPoint, returnValue, logInfo);
		//TODO 需要一个全局Session存储当前登录用户,可能需要shiro管理用户
		
		logInfo.setOperateTime(new Date());
		logInfo.setHasDelete(WebConstant.HAS_DELETE_NO);
		logInfoService.addLogInfo(logInfo);
	}
	
	/**
	 * 把注解的信息填充到日志对象中
	 * @param joinPoint
	 * @param returnValue
	 * @param logInfo
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private LogInfo fillLogInfo(JoinPoint joinPoint,Object returnValue,LogInfo logInfo){
		String methodName=joinPoint.getSignature().getName();
		Class targetClass=joinPoint.getTarget().getClass();
		Class[] argsType=convertObjectToClass(joinPoint.getArgs());
		try
		{
			Method m=targetClass.getMethod(methodName, argsType);
			LogMark logMark=m.getAnnotation(LogMark.class);
			logInfo.setContent(logMark.content());
			logInfo.setTitle(logMark.title());
			logInfo.setType(logMark.type());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return logInfo;
	}
	
	@SuppressWarnings("rawtypes")
	private Class[] convertObjectToClass(Object[] args){
		Class[] classes=new Class[args.length];
		for (int i=0;i<classes.length;i++)
		{
			classes[i]=args[i].getClass();
		}
		return classes;
	}
}
