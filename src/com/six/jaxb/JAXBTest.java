package com.six.jaxb;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBTest {
	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Marshaller m = context.createMarshaller();
		
		Address address = new Address("China","Beijing","Beijing","ShangDi West","100080");
		Person p = new Person(Calendar.getInstance(),"JAXB2",address,Gender.MALE,"SW");
		FileWriter fw = new FileWriter("person.xml");
		m.marshal(p, fw);
		
		FileReader fr = new FileReader("person.xml");
		Unmarshaller um = context.createUnmarshaller();
		Person person = (Person)um.unmarshal(fr);
		System.out.println(person.getAddress().getCountry());
	}
}
