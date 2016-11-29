package com.six.jaxb;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Person {
	Calendar birthDay; //birthday将作为person的子元素
	String name; //name将作为person的的一个属性
	Address address;
	Gender gender;
	String job;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(Calendar birthDay, String name, Address address,
			Gender gender, String job) {
		super();
		this.birthDay = birthDay;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.job = job;
	}
	@XmlElement
	public Calendar getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@XmlElement
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@XmlElement
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
