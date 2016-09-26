package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		IHelloWorld helloWorld=new HelloWorld();
        InvocationHandler handler=new HelloWorldHandler(helloWorld);
        
        //创建动态代理对象
        IHelloWorld proxy=(IHelloWorld)Proxy.newProxyInstance(
                helloWorld.getClass().getClassLoader(), 
                helloWorld.getClass().getInterfaces(), 
                handler);
        proxy.say();
	}
}
