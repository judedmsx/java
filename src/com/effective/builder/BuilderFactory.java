package com.effective.builder;

public class BuilderFactory {
	private IBuilder builder;
	
	public Object test(IBuilder builder){
		return builder.build();
	}
	
	public static void main(String[] args) {
		BuilderFactory fatory = new BuilderFactory();
		Person person = (Person)fatory.test(new Person.Builder("1","dd","20"));
		System.out.println(person.getAge());
		
	}
}
