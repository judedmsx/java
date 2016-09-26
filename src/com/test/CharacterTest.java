package com.test;

public class CharacterTest {
	public static void main(String[] args) {
		Character a = new Character('a');
		Character A = new Character('A');
		
		int aX = a;
		int AX = A;
		System.out.println(aX);
		System.out.println(AX);
		
		System.out.println(Character.isUpperCase(a));
		System.out.println(Character.isUpperCase(A));
	}
}
