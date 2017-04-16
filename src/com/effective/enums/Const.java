package com.effective.enums;

public enum Const {
	STOP(11),
	START(12);
	
	private int code;
	private Const(int code){
		this.code = code;
	}
	
	public static void main(String[] args) {
		System.out.println(Const.START.code);
	}
}
