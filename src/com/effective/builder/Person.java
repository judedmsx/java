package com.effective.builder;

import java.io.Serializable;
/**
 * Builder模式
 * @author Administrator
 *
 */
public class Person implements Serializable{
	private int index;
	//必须参数
	private String id;
	private String name;
	private String age;
	
	//可选参数
	private String city;
	private String job;
	private String sex;
	
	private Person(Builder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.city= builder.city;
		this.job = builder.job;
		this.sex = builder.sex;
		this.index = builder.index;
	}

	
	public static class Builder implements IBuilder<Person>{
		private static int index = 0;
		//必须参数
		private final String id;
		private final String name;
		private final String age;
		
		//可选参数
		private String city;
		private String job;
		private String sex;
		
//		public Builder(){}
		
		// 设置必须的参数 
		public Builder(String id,String name,String age){
			this.id = id;
			this.name = name;
			this.age = age;
//			this.index++;
		}
		// 设置可选参数, 返回Builder对象可以让调用者使用级联
		public Builder setCity(String city){
			this.city = city;
			return this;
		}
		
		public Builder setJob(String job){
			this.job = job;
			return this;
		}
		
		public Builder setSex(String sex){
			this.sex = sex;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getIndex() {
		return index;
	}
	public static void main(String[] args) {
		Person person = new Person.Builder("1", "judedd", "23").setCity("黑龙江").build();
		Person person2 = new Person.Builder("2", "judedd", "23").setCity("黑龙江").build();
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getCity());
		System.out.println(person.getIndex());
		System.out.println(person2.getIndex());
	}
}
