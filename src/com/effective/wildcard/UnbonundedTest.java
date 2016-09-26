package com.effective.wildcard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class UnbonundedTest {
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// 无限制通配符,不确定或者不关心实际的类型参数
		List<?> list = new ArrayList();
		// 编译报错，程序不知道传入的参数是什么类型的，不能出现与参数类型有关的方法，比如add(), 但是可以调用与参数
		// 类型无关的方法，比如size()
		// list.add(new UnbonundedTest());
		list.size();

		// 非受检转换警告 unchecked conversion warnings
		List<UnbonundedTest> unList = new ArrayList();

		// fails at runtime
		/*Object[] objectArray = new Long[1];
		objectArray[0] = "i don't fit in";*/

		// can't compile
		/* List<Object> ol = new ArrayList<Long>();
		 ol.add("i don't fit in");*/

		/**
		 * 使用泛型限定ArrayList容器只能存储字符串类型的对象
		 */
		ArrayList<String> collection2 = new ArrayList<String>();
		collection2.add("孤傲苍狼");
		// collection2.add(1);//报错，因为限制了collection2只能存储String类的对象，不能加入Integer类型的对象
		// collection2.add(1L);//报错，因为限制了collection2只能存储String类的对象，不能加入Long类型的对象
		// 由于已经指明集合中存储的是字符串类型的对象，因此这里不用再强制转型了
		String element = collection2.get(0);

		/**
		 * 泛型是提供给Javac编译器看的，可以限定集合中的输入类型，让编译器挡住源程序中的非法输入，
		 * 编译器编译带参数类型说明的集合时会去去除掉“类型”信息，使程序运行不受影响，对于参数化的泛型类型，
		 * getClass()方法的返回值和原始类型完全一样，由于编译生成的字节码会去掉泛型的类型信息，
		 * 因此只要能跳过编译器，就可以往某个泛型集合中加入其他类型的数据。
		 */
		ArrayList<Integer> collection3 = new ArrayList<Integer>();
		// 对于参数化的泛型类型，getClass()方法的返回值和原始类型完全一样
		System.out.println(collection3.getClass());// 结果为：java.util.ArrayList
		System.out.println(collection3.getClass() == collection2.getClass());// 结果为true
		// 使用反射得到集合，然后调用add方法往原本只能存储Integer对象的集合中存储一个String类型的对象
		collection3.getClass().getMethod("add", Object.class)
				.invoke(collection3, "abc");
		System.out.println(collection3.get(0));// 输出的结果为：abc，这证明字符串对象确实是存储到了原本只能存储Integer对象的集合中
	}
}
