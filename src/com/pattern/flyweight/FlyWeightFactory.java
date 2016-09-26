package com.pattern.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeightFactory {
	private Map<Character,FlyWeight> files = new HashMap<Character,FlyWeight>();
	
	public FlyWeight factory(Character state){
		FlyWeight fly = files.get(state);
		if(fly == null){
			fly = new ConcreteFlyWeight(state);
			files.put(state, fly);
		}
		return fly;
	}
	
	public FlyWeight factory(List<Character> list){
		CompositeFlyWeight composite = new CompositeFlyWeight();
		for(Character f : list){
			composite.add(f, this.factory(f));
		}
		return composite;
	}
	
	public static void main(String[] args) {
		//������Ԫģʽ
		FlyWeightFactory factory = new FlyWeightFactory();
		FlyWeight a = factory.factory(new Character('a'));
		a.operation("call a ");
		
		FlyWeight a1 = factory.factory(new Character('a'));
		a1.operation("call a again ");
		System.out.println(a == a1);
		//������Ԫģʽ   �ⲿ״̬һ��   ����״̬��ͬ
		
		
		List<Character> list1 = new ArrayList<Character>();
		list1.add('a');
		list1.add('b');
		
		FlyWeight composite1 = factory.factory(list1);
		composite1.operation("call composite1");
		
		FlyWeight composite2 = factory.factory(list1);
		composite2.operation("call composite1");
		
		System.out.println(composite1 == composite2);
	}
}
