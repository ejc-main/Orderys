package com.revature.orderys.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
public class AuthenticationAspect {
	
	/*
	 * create an advice within this aspect that runs around any controller methods 
	 * and checks whether or not the HTTP request contains valid authentication information 
	 * (and possibly checks if the authenticated user has the correct permissions required to 
	 * access the endpoint being requested)
	 */
	
	@Pointcut("execution(* com.revature.orderys.controller.* (..))")
	public void pc() {}
	
	@Around("pc()")
	public void checkAuthentication(ProceedingJoinPoint pjp) {
		
	}

}
