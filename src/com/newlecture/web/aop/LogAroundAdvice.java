package com.newlecture.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;


public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// TODO Auto-generated method stub
		
		StopWatch sw = new StopWatch();
		
		System.out.println("[�ð�üũ] ȣ�� ����");
		sw.start();
		Object result = method.proceed();

		System.out.println("[�ð�üũ] ȣ�� ��");
		sw.stop();
		
		System.out.println("[TIMELOG]Method: " + method.getMethod().getName()+" is finished");
		System.out.println("[TIMELOG]Process Time:"+sw.getTotalTimeMillis());
		
		
		return result;
	}
	
	
	
}
