package com.thread.collections.notblocklist;

import java.util.concurrent.ConcurrentLinkedDeque;
/**
 * 
 * getFirst()和getLast()：这些方法将分别返回列表的第一个和最后一个元素。它们不会从列表删除返回的元素。如果列表为空，这些方法将抛出NoSuchElementExcpetion异常。</p>
 * peek()、peekFirst()和peekLast()：这些方法将分别返回列表的第一个和最后一个元素。它们不会从列表删除返回的元素。如果列表为空，这些方法将返回null值。</p>
 * remove()、removeFirst()、 removeLast()：这些方法将分别返回列表的第一个和最后一个元素。它们将从列表删除返回的元素。如果列表为空，这些方法将抛出NoSuchElementExcpetion异常。</p>
 * @author maosx
 *
 */
public class ConcurrentLinkedDequeMain {
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>();
		Thread thread[] = new Thread[100];
		for(int i=0;i<100;i++){
			thread[i] = new Thread(new AddTask(list));
			thread[i].start();
		}
		System.out.println("AddTask threads have benn launched");
		
		try {
			for(int i=0;i<thread.length;i++){
				thread[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Size of the list: "+list.size());
		
		for(int i=0;i<thread.length;i++){
			thread[i] = new Thread(new PollTask(list));
			thread[i].start();
		}
		try {
			for(int i=0;i<thread.length;i++){
				thread[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Size of the list: "+list.size());
	}
}
