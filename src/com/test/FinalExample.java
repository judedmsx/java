package com.test;
/**
 * 遇到new getstatic putstatic invokestatic字节码指令，类没有初始化，则先进行初始化；
 * reflect反射机制调用时，类没有初始化，则先进行初始化；
 * 初始化一个类时，若父类没有初始化，则父类先初始化；
 * main函数执行时，类现初始化；
 * jdk1.7动态语言支持，MethodHandler最后解析结果REF_getStatic,REF_putStatic,REF_invokeStatic的方法
 * 句柄，句柄所对应的类没有初始化，则需要触发初始化
 * @author maosx
 *
 */
public class FinalExample {
	int i;
	final int j;
	static FinalExample obj;
	
	static{
		System.out.println("class init");
	}
	
	public FinalExample(){
		i = 1;
		j = 2;
		System.out.println("obj constructor init");
	}
	
	public static void writer(){
//		obj = new FinalExample();
		System.out.println("----");
	}
	
	public static void read(){
		FinalExample object = obj;
		int a = object.i;
		int b = object.j;
		
		System.out.println("===="+a);
	}
	
	public static void main(String[] args) {
		FinalExample.writer();
	}
}
