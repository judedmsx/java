package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class HelloWorldHandler implements InvocationHandler{
	private Object target;
	
	public HelloWorldHandler(Object obj){
		super();
		target = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		doBefore();
		result = method.invoke(target, args);
		doAfter();
		return result;
	}
	
	
	public void doBefore(){
		System.out.println("before method invoke");
	}
	
	public void doAfter(){
		System.out.println("after method invoke");
	}
}
