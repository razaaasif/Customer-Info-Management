package com.spring.hibernate.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogingAspect {
	// set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// set up pointcut
	@Pointcut("execution(* com.spring.hibernate.controller.*.*(..))")
	public void forControllerPackage() {
	}

	@Pointcut("execution(* com.spring.hibernate.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.spring.hibernate.business.impl.*.*(..))")
	public void forServicePackage() {
	}

	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void appFlow() {
	}

	// add @Before
	@Before("appFlow()")
	public void before(JoinPoint thJoinPoint) {
		System.out.println("<-----------" + thJoinPoint.toLongString() + "----------- >");
		System.out.println("<-----------" + thJoinPoint.getArgs().toString() + "----------- >");
	}

	@AfterReturning(pointcut = "appFlow()", returning = "result")
	public void afetrReturning(JoinPoint joinPoint, Object result) {
		myLogger.info("AfterReturning" + result);
	}
}
