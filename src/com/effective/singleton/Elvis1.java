package com.effective.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举单例模式
 * @author Administrator
 *
 */
public enum Elvis1 {
	INSTANCE;
	
	private String name;
	
	private Elvis1(){
		name = "test";
		System.out.println("constructor start");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException, ClassNotFoundException {
		
		//解决反射机制攻击问题,enum类型不能反射
		/*for(Constructor cons : Elvis1.INSTANCE.getClass().getDeclaredConstructors()){
			cons.setAccessible(true);
			Elvis1 elvis11 = (Elvis1)cons.newInstance();
			System.out.println(elvis11 == Elvis1.INSTANCE);
		}*/
		
		//解决反序列化问题,多次序列化 是同一个对象
		 FileOutputStream fout=new FileOutputStream("student.txt");
		 ObjectOutputStream oos  =new ObjectOutputStream(fout);
		 oos.writeObject(Elvis1.INSTANCE);
		 oos.close();
		 FileInputStream fis = new FileInputStream("student.txt");
		 ObjectInputStream ois = new ObjectInputStream(fis);
		 Elvis1 elvis = (Elvis1)ois.readObject();
		 System.out.println(elvis == Elvis1.INSTANCE);
		 ois.close();
		 
		 System.out.println(elvis.getName());
		 System.out.println(Elvis1.INSTANCE.getName());
		 
		 FileInputStream fis1 = new FileInputStream("student.txt");
		 ObjectInputStream ois1 = new ObjectInputStream(fis1);
		 Elvis1 elvis1 = (Elvis1)ois1.readObject();
		 System.out.println(elvis1 == Elvis1.INSTANCE);
		 ois1.close();
	}
}
