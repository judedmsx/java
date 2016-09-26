package com.effective;

public enum EnumTest {
/*	MON, TUE, WED, THU, FRI, SAT, SUN;*/
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);
	
	private int value;
	
	private EnumTest(int value){
		this.value = value;
	}
	
	
	public int getValue() {
		return value;
	}


	public static void main(String[] args) {
		/*for(EnumTest e : EnumTest.values()){
			System.out.println(e.name()+"---"+e.ordinal());
		}*/
		System.out.println(EnumTest.FRI.getValue());
	}
}
