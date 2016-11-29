package com.six.jaxb;

public enum Gender {
	MALE(true),
	FEMALE(false);
	
	private boolean value;
	Gender(boolean _value){
		this.value = _value;
	}
}
