package com.datapine.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoginInterceptor {
	@Pointcut("execution(* com.datapine.service.LoginService.login(..))")
	public void k() {
	}

	@Before("k()")
	public void myadvice(JoinPoint jp) {
		Object[] args = jp.getArgs();
		System.out.println("logging attempt made for " + args[0]);
	}
}
