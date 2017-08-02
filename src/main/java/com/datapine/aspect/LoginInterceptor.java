package com.datapine.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoginInterceptor {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public LoginInterceptor() {
		logger.info("here i am");
	}

	@Pointcut("execution(* com.datapine.security.CustomAuthenticationManager.authenticate(..))")
	public void k() {
	}

	@Before("k()")
	public void myadvice(JoinPoint jp) {
		Object[] args = jp.getArgs();
		logger.info("logging attempt made for " + args[0]);
	}
}
