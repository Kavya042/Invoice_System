package com.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InvoiceAspect {

	@Before(value="execution(* com.system.controller.InvoiceController.*(..))")
	public void beforeAdviceInController(JoinPoint jp) {
		System.out.println("Invoice details before the controller " + jp.getSignature());
	}
	
	@Before(value="execution(* com.system.service.InvoiceServiceImpl.*(..))")
	public void beforeAdviceInService(JoinPoint jp) {
		System.out.println("Invoice details before the service " + jp.getSignature());
	}
	
	@After(value="execution(* com.system.controller.InvoiceController.*(..))")
	public void afterAdviceInController(JoinPoint jp) {
		System.out.println("Invoice details after the controller " + jp.getSignature());
	}
	
	@After(value="execution(* com.system.service.InvoiceServiceImpl.*(..))")
	public void afterAdviceInService(JoinPoint jp) {
		System.out.println("Invoice details after the advice "+ jp.getSignature());
	}
	
}
