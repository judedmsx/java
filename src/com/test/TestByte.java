package com.test;

import java.math.BigInteger;
import java.util.Collections;


public class TestByte {
	public static void main(String[] args) {
		/*String str = "2faf";
		str.substring(0, 2);*/
		
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int c = a+b;
		System.out.println("a="+a+" b="+b+" c="+c);
		
		/*int d = Integer.valueOf(129);
		int e = Integer.valueOf(129);*/
		System.out.println(Integer.valueOf(127)==Integer.valueOf(127));
	}
}
