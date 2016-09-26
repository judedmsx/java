package com.test;
/**
 * 	1��String����final�ģ����ɱ��̳С�
	2��String���ǵı������ַ�����char[], ������ֵ���ɸı䡣
	3��String������и�����Ĵ����ķ�ʽ������ֱ��ָ������String x = "abc"��"abc"�ͱ�ʾһ���ַ������󡣶�x��"abc"����ĵ�ַ��Ҳ����"abc"��������á�
	4��String�������ͨ����+��������������������µ��ַ�����
	5��Java����ʱ��ά��һ��String Pool��String�أ���JavaDoc�����ģ�����ַ�������������String�������������ʱ�в����ĸ����ַ��������ҳ��е��ַ��������ݲ��ظ�����һ����󲻴����������أ����Ҵ����Ķ�����������ڷ����Ķ�ջ����
	
	6�������ַ����ķ�ʽ�ܶ࣬�������������ࣺ
	��һ��ʹ��new�ؼ��ִ����ַ���������String s1 = new String("abc");
	�����ֱ��ָ��������String s2 = "abc";
	������ʹ�ô��������µ��ַ���������String s3 = "ab" + "c"; 
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
		/*	1) ջ�п���һ��ռ�������str1��
			2) String���п���һ��ռ䣬���String����"abc"�� 
			3) ����str1ָ�����String����"abc"��
			4) str1��ָ���ĵ�ַ������"abc"���ڵ�ַ�����Ϊtrue��
		*/
		String str1 = "abc";
		System.out.println("test_1:" + (str1 == "abc"));
	}
	public static void test_2(){
		/*
			1) ջ�п���һ��ռ�������str2�� 
			2) ���п���һ��ռ���һ���½���String����"abc"�� 
			3) ����str2ָ����е��½���String����"abc"��
			4) str2��ָ���Ķ����ַΪ���е�ַ��������"abc"��ַ�ڳ��У����Ϊfalse��
		*/
		String str2 = new String("abc");
		System.out.println("test_2:" + (str2 == "abc"));
	}
	public static void test_3(){
		/*
		 * 1) ջ�п���һ��ռ�������str3��
			2) ���п���һ���¿ռ�������һ��(��ͬ��str2��ָ)�½���String���� 
			3) ����str3ָ�������½����Ǹ�String���� ��
			4) str3��str2ָ����в�ͬ��String���󣬵�ַҲ����ͬ�����Ϊfalse
		 * */
		String str2 = new String("abc");
		String str3 = new String("abc");
		System.out.println("test_3:" + (str2 == str3));
	}
	
	public static void test_4(){
		/*
			1) ջ�п���һ��ռ�������str4�� 
			2) ���ݱ������ϲ���֪�����Ż����ܣ����п���һ��ռ䣬��źϲ����String����"ab"�� 
			3) ����str4ָ����г���"ab"��
			4) str4��ָ�����г���"ab"�����Ϊtrue��
		*/
		String str4 = "a" + "b"; 
		System.out.println("test_4:" +(str4 == "ab"));
	}
	
	
	public static void test_5(){
		//ͬtest_4();
		final String s = "a";
		String str5 = s + "b"; 
		System.out.println("test_5:" + (str5 == "ab"));
	}
	
	public static void test_6(){
//		1) ջ�п���һ���м�������s1��s1ָ�����String����"a"�� 
//		2) ջ�п���һ���м�������s2��s2ָ�����String����"b"�� 
//		3) ջ�п���һ���м�������str5�� 
//		4) s1 + s2ͨ��StringBuilder�����һ��toString()������ԭһ���µ�String����"ab"����˶��п���һ��ռ��Ŵ˶��� 
//		5) ����str6ָ�����(s1 + s2)����ԭ����String���� 
//		6) str6ָ��Ķ����ڶ��У�������"ab"�ڳ��У����Ϊfalse
		String s1 = "a"; 
	    String s2 = "b"; 
	    String str6 = s1 + s2; 
		System.out.println("test_6:" + (str6 == "ab"));
	}
	
	public static void test_7(){
		/*1) ջ�п���һ��ռ�������str7�� 
		2) substring()������ԭһ���µ�String����"ab"����ͬ��str6��ָ�������п���һ��ռ��Ŵ˶���
		3) ����str7ָ����е���String����*/
		String str7 = "abc".substring(0, 2); 
		System.out.println("test_7:" + (str7 == "ab"));
	}
	
	public static void test_8(){
		/*1) ջ�п���һ��ռ�������str6�� 
		2) toUpperCase()������ԭһ���µ�String����"ABC"�����в�δ�����µĿռ���String����"ABC"�� 
		3) ����str8ָ����е���String����*/
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
