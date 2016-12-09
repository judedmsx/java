package com.eight;

public class TestFormula {
	public static void main(String[] args) {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
		};
		double value = formula.calculate(4);
		System.out.println(value);
	}
}
