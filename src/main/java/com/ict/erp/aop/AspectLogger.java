package com.ict.erp.aop;

 import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

 @Service
@Aspect
public class AspectLogger {
	private static final Logger logger = 
			LoggerFactory.getLogger(AspectLogger.class); 		/*before 메소드 사용전*/
	private long sTime;
	
	@Before("execution(* com.ict.erp.controller.*.*(..))")		/* *(..) 어떠한 메소드명 상관없고 .. 은 0개 이상*/
	public void beforeLog(JoinPoint jp) {
		logger.debug("jp=>{}",jp);		
		sTime = System.currentTimeMillis();
	}
	
	@Around("execution(* com.ict.erp.controller.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String sigName = pjp.getSignature().getName();
		String targetName = pjp.getTarget().toString();
		Object[] params = pjp.getArgs();
		logger.debug("{}.{}({})",new Object[] {targetName,sigName,params});
		Object obj = pjp.proceed();
		logger.debug("result => {}", obj);
		return obj;
	}
	
	@After("execution(* com.ict.erp.controller.*.*(..))")
	public void afterLog(JoinPoint jp) {
		logger.debug("end=>{}",jp);
		logger.debug("execution time =>{}ms",(System.currentTimeMillis() - sTime));
	}
}