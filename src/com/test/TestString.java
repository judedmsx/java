package com.test;
/**
 * 	1、String类是final的，不可被继承。
	2、String类是的本质是字符数组char[], 并且其值不可改变。
	3、String类对象有个特殊的创建的方式，就是直接指定比如String x = "abc"，"abc"就表示一个字符串对象。而x是"abc"对象的地址，也叫做"abc"对象的引用。
	4、String对象可以通过“+”串联。串联后会生成新的字符串。
	5、Java运行时会维护一个String Pool（String池），JavaDoc翻译很模糊“字符串缓冲区”。String池用来存放运行时中产生的各种字符串，并且池中的字符串的内容不重复。而一般对象不存在这个缓冲池，并且创建的对象仅仅存在于方法的堆栈区。
	
	6、创建字符串的方式很多，归纳起来有三类：
	其一，使用new关键字创建字符串，比如String s1 = new String("abc");
	其二，直接指定。比如String s2 = "abc";
	其三，使用串联生成新的字符串。比如String s3 = "ab" + "c"; 
 */
public class TestString {
	public static void main(String[] args) {
		test_1();
		test_2();
		test_3();
		test_4();
		test_5();
		test_6();
		test_7();
		test_8();
		test_9();
	}
	
	public static void test_1(){
		/*	1) 栈中开辟一块空间存放引用str1；
			2) String池中开辟一块空间，存放String常量"abc"； 
			3) 引用str1指向池中String常量"abc"；
			4) str1所指代的地址即常量"abc"所在地址，输出为true；
		*/
		String str1 = "abc";
		System.out.println("test_1:" + (str1 == "abc"));
	}
	public static void test_2(){
		/*
			1) 栈中开辟一块空间存放引用str2； 
			2) 堆中开辟一块空间存放一个新建的String对象"abc"； 
			3) 引用str2指向堆中的新建的String对象"abc"；
			4) str2所指代的对象地址为堆中地址，而常量"abc"地址在池中，输出为false；
		*/
		String str2 = new String("abc");
		System.out.println("test_2:" + (str2 == "abc"));
	}
	public static void test_3(){
		/*
		 * 1) 栈中开辟一块空间存放引用str3；
			2) 堆中开辟一块新空间存放另外一个(不同于str2所指)新建的String对象； 
			3) 引用str3指向另外新建的那个String对象 ；
			4) str3和str2指向堆中不同的String对象，地址也不相同，输出为false
		 * */
		String str2 = new String("abc");
		String str3 = new String("abc");
		System.out.println("test_3:" + (str2 == str3));
	}
	
	public static void test_4(){
		/*
			1) 栈中开辟一块空间存放引用str4； 
			2) 根据编译器合并已知量的优化功能，池中开辟一块空间，存放合并后的String常量"ab"； 
			3) 引用str4指向池中常量"ab"；
			4) str4所指即池中常量"ab"，输出为true；
		*/
		String str4 = "a" + "b"; 
		System.out.println("test_4:" +(str4 == "ab"));
	}
	
	
	public static void test_5(){
		//同test_4();
		final String s = "a";
		String str5 = s + "b"; 
		System.out.println("test_5:" + (str5 == "ab"));
	}
	
	public static void test_6(){
//		1) 栈中开辟一块中间存放引用s1，s1指向池中String常量"a"， 
//		2) 栈中开辟一块中间存放引用s2，s2指向池中String常量"b"， 
//		3) 栈中开辟一块中间存放引用str5， 
//		4) s1 + s2通过StringBuilder的最后一步toString()方法还原一个新的String对象"ab"，因此堆中开辟一块空间存放此对象， 
//		5) 引用str6指向堆中(s1 + s2)所还原的新String对象， 
//		6) str6指向的对象在堆中，而常量"ab"在池中，输出为false
		String s1 = "a"; 
	    String s2 = "b"; 
	    String str6 = s1 + s2; 
		System.out.println("test_6:" + (str6 == "ab"));
	}
	
	public static void test_7(){
		/*1) 栈中开辟一块空间存放引用str7， 
		2) substring()方法还原一个新的String对象"ab"（不同于str6所指），堆中开辟一块空间存放此对象，
		3) 引用str7指向堆中的新String对象，*/
		String str7 = "abc".substring(0, 2); 
		System.out.println("test_7:" + (str7 == "ab"));
	}
	
	public static void test_8(){
		/*1) 栈中开辟一块空间存放引用str6， 
		2) toUpperCase()方法还原一个新的String对象"ABC"，池中并未开辟新的空间存放String常量"ABC"， 
		3) 引用str8指向堆中的新String对象*/
		String str8 = "abc".toUpperCase(); 
		System.out.println("test_8:" + (str8 == "abc"));
	}
	
	public static void test_9(){
		String s = "abc";
		String s1 = s;
		System.out.println(s1 == "abc");
		s = s + "hello";
		System.out.println(s1 == "abc");
		System.out.println(s == "abc");
	}
}
