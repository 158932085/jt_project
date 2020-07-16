package com.jt.vop;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 *全局异常处理类
 * 
 * 
 * */
@RestControllerAdvice
@Slf4j
public class SysconfigExceptionAop {
/*
 * 1.拦截什么样的异常  运行时异常
 * 2.返回值的结果是什么  系统返回值VO对象
 * */
	@ExceptionHandler(RuntimeException.class)
	public Object sysResult(Exception exception)
	{
		log.error(exception.getMessage());
		exception.printStackTrace();
		return com.jt.vo.SysResult.fail();
	}
}
