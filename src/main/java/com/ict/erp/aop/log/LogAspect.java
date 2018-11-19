package com.ict.erp.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	@Before("execution(* com.ict.erp.controller.*Controller.*(..))")
	public void beforeLog(JoinPoint jp) {
		log.info("@Before => {}", jp);
	}

	@Around("execution(* com.ict.erp.controller.*Controller.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp)
			throws Throwable {
		log.info("@Around start");
		log.info("pjp=>",pjp);
		Object obj = null;
		long startTime = System.currentTimeMillis();
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			throw e;
		}
		long logTime = System.currentTimeMillis() - startTime;
		log.info("@Around end, RunTime : {} ms", (logTime));
		return obj;
	}

	@After("execution(public String com.ict.erp..*Controller.*(..))")
	public void afterLog(JoinPoint jp) {
		log.info("@After => {}", jp);
	}
}