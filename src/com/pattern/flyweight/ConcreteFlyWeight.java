package com.pattern.flyweight;

public class ConcreteFlyWeight implements FlyWeight{
	private Character internalState;
	
	public ConcreteFlyWeight(Character internalState) {
		super();
		this.internalState = internalState;
	}


	@Override
	public void operation(String state) {
		System.out.println("�ڲ�״̬��"+internalState+" �ⲿ״̬��"+state);
	}
	
}
