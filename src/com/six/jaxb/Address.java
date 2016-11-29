package com.six.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
	
	String country;
	
	String state;
	String city;
	String street;
	String zipcode; // 由于没有添加@XmlElement,所以该元素不会出现在输出的xml中

	public Address(String country, String state, String city, String street,
			String zipcode) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@XmlAttribute
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@XmlElement
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@XmlElement
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


}
