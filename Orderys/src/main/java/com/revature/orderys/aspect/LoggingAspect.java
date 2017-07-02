package com.revature.orderys.aspect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LoggingAspect {
	
	private static String filename = "./log.txt";
	private static String serverLogfile = "./server-log.txt";
	
	@Pointcut("execution(* com.revature.orderys..* (..))")
	public void pc() {}
	
	@Around("pc()")
	public void logMethod(ProceedingJoinPoint pjp) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));) {
			pw.println("Executing " + pjp.getSignature().getName() + " from " + pjp.getSourceLocation().getFileName() + ":"
				+ pjp.getSourceLocation().getLine() /*+ " with arguments " +*/ /*pjp.getArgs()*/);
			try {
				pjp.proceed();
			} catch (Throwable t) {
			    t.printStackTrace(pw);
			}
			pw.println("Finished execution of " + pjp.getSignature());
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
		    
	}

}
