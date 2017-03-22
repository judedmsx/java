package com.thread.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * 使用线程安全的导航地图(非阻塞列表)
 * @author maosx
 *
 */
public class Main {
	public static void main(String[] args) {
		demo2();
	}
	
	public static void demo1(){
		ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();
		Thread threads[] = new Thread[25];
		int counter = 0;
		
		for(char i = 'A';i < 'Z';i++){
			Task task = new Task(map, String.valueOf(i));
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		
		try {
			for(int i=0;i<25;i++){
				threads[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.printf("Main: Size of the map: %d\n",map.size());
		
		Map.Entry<String, Contact> element;
		Contact contact;
		element=map.firstEntry();
		contact=element.getValue();
		System.out.printf("Main: First Entry: %s: %s\n",contact.getName(),contact.getPhone());
		
		element=map.lastEntry();
		contact=element.getValue();
		System.out.printf("Main: Last Entry: %s: %s\n",contact.getName(),contact.getPhone());

		System.out.printf("Main: Submap from A1996 to B1002: \n");
		ConcurrentNavigableMap<String, Contact> submap=map.subMap("A1996", "B1002");
		do {
			element=submap.pollFirstEntry();
			if (element!=null) {
				contact=element.getValue();
				System.out.printf("%s: %s\n",contact.getName(),contact.getPhone());
			}
		} while (element!=null);
	}
	
	public static void demo2(){
		final int THREADS = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(100);
		
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer = new Decrementer(vector);
		Thread threadIncrementer[]=new Thread[THREADS];
		Thread threadDecrementer[]=new Thread[THREADS];
		
		for(int i=0;i<THREADS;i++){
			threadIncrementer[i] = new Thread(incrementer);
			threadDecrementer[i] = new Thread(decrementer);
			
			threadIncrementer[i].start();
			threadDecrementer[i].start();
		}
		
		try {
			for(int i=0;i<THREADS;i++){
				threadIncrementer[i].join();
				threadDecrementer[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<vector.length();i++){
//			if(vector.get(i)!=0)
				System.out.println(vector.get(i));
		}
	}
}
