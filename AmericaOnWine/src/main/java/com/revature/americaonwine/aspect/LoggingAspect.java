package com.revature.americaonwine.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger log = Logger.getRootLogger();
	
	@Around("everything()")
	public Object log(ProceedingJoinPoint pjp) {
		Object obj = null;
		log.trace("Method with signature " + pjp.getSignature()+ " called.");
		log.trace("With arguments: " + Arrays.toString(pjp.getArgs()));
		
		try {
			obj = pjp.proceed();
		}
		catch (Throwable e) {
			log.error(e.getMessage());
			for (StackTraceElement s : e.getStackTrace()) {
				log.warn(s);
			}
		}
		log.info(pjp.getSignature() + " returned: " + obj);
		return obj;
	}
	
	@Pointcut("execution(* com.revature..*(..))")
	public void everything() {
		// sonarqube requires that we have a comment in here
	}
}
