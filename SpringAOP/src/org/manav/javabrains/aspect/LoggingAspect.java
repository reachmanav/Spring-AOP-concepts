package org.manav.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.manav.javbrains.model.Circle;

@Aspect
public class LoggingAspect {

	//@Before("execution(public String org.manav.javbrains.model.Circle.getName())")
	
	
	//@Before("circleAllMethods() && allGetters()")
	@Before("circleAllMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)  {
		//System.out.println("Aspect method LoggingAdvice() called. " + joinPoint.toString());
		//Circle cir = (Circle) joinPoint.getTarget();
		//cir.setName("Dummy Name");
		System.out.println("Aspect method LoggingAdvice() called. " + joinPoint.toString());
		System.out.println("Exiting from Advice");
		
	}
	
	
	/*
	@Before("allGetters()")
	public void SecondLoggingAdvice()  {
		System.out.println("Aspect method SecondLoggingAdvice() called. ");
	}
	*/
	
	//@After
	//@AfterReturning -- after returning success
	//@AfterThrowing - 
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void demoAfterThrowing(String name, RuntimeException ex)  {
		System.out.println("An error has occured: ex:"+ex);
	}
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void demoAfterReturning(String name, String returnString)  {
		System.out.println("demoAfterReturning has been called- name:"+name + "returnString is:"+returnString);
	}
	
	//@Around("allGetters()")
	@Around("@annotation(org.manav.javabrains.aspect.Loggable)")
	public Object myArroundAdvice(ProceedingJoinPoint proceedingJoinPoint)  {
		
		Object returnValue=null;
		
		try {
			System.out.println("myArroundAdvice has been called - BEFORE");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("myArroundAdvice has been called - AFTER");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After throwing");
		}
		
		System.out.println("AROUND FINALLY");
		
		return returnValue;
		
	}
	
	@Before("args(name)")
	public void stringArgumentAdvice(String name)  {
		System.out.println("A method with String argument was executed. Received argument:"+name);
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	
	//within takes class names as arguments
	@Pointcut("within(org.manav.javbrains.model.Circle)")
	public void circleAllMethods()  {}
	
	
	
}
