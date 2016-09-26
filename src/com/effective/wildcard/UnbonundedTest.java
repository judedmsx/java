package com.effective.wildcard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class UnbonundedTest {
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		// ������ͨ���,��ȷ�����߲�����ʵ�ʵ����Ͳ���
		List<?> list = new ArrayList();
		// ���뱨������֪������Ĳ�����ʲô���͵ģ����ܳ�������������йصķ���������add(), ���ǿ��Ե��������
		// �����޹صķ���������size()
		// list.add(new UnbonundedTest());
		list.size();

		// ���ܼ�ת������ unchecked conversion warnings
		List<UnbonundedTest> unList = new ArrayList();

		// fails at runtime
		/*Object[] objectArray = new Long[1];
		objectArray[0] = "i don't fit in";*/

		// can't compile
		/* List<Object> ol = new ArrayList<Long>();
		 ol.add("i don't fit in");*/

		/**
		 * ʹ�÷����޶�ArrayList����ֻ�ܴ洢�ַ������͵Ķ���
		 */
		ArrayList<String> collection2 = new ArrayList<String>();
		collection2.add("�°�����");
		// collection2.add(1);//������Ϊ������collection2ֻ�ܴ洢String��Ķ��󣬲��ܼ���Integer���͵Ķ���
		// collection2.add(1L);//������Ϊ������collection2ֻ�ܴ洢String��Ķ��󣬲��ܼ���Long���͵Ķ���
		// �����Ѿ�ָ�������д洢�����ַ������͵Ķ���������ﲻ����ǿ��ת����
		String element = collection2.get(0);

		/**
		 * �������ṩ��Javac���������ģ������޶������е��������ͣ��ñ�������סԴ�����еķǷ����룬
		 * �������������������˵���ļ���ʱ��ȥȥ���������͡���Ϣ��ʹ�������в���Ӱ�죬���ڲ������ķ������ͣ�
		 * getClass()�����ķ���ֵ��ԭʼ������ȫһ�������ڱ������ɵ��ֽ����ȥ�����͵�������Ϣ��
		 * ���ֻҪ���������������Ϳ�����ĳ�����ͼ����м����������͵����ݡ�
		 */
		ArrayList<Integer> collection3 = new ArrayList<Integer>();
		// ���ڲ������ķ������ͣ�getClass()�����ķ���ֵ��ԭʼ������ȫһ��
		System.out.println(collection3.getClass());// ���Ϊ��java.util.ArrayList
		System.out.println(collection3.getClass() == collection2.getClass());// ���Ϊtrue
		// ʹ�÷���õ����ϣ�Ȼ�����add������ԭ��ֻ�ܴ洢Integer����ļ����д洢һ��String���͵Ķ���
		collection3.getClass().getMethod("add", Object.class)
				.invoke(collection3, "abc");
		System.out.println(collection3.get(0));// ����Ľ��Ϊ��abc����֤���ַ�������ȷʵ�Ǵ洢����ԭ��ֻ�ܴ洢Integer����ļ�����
	}
}
