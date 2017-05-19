package com.thread.collections.blocklist;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import com.thread.SleepUtils;
/**
 * takeFirst() 和takeLast()：这些方法分别返回列表的第一个和最后一个元素。它们从列表删除返回的元素。如果列表为空，这些方法将阻塞线程，直到列表有元素。</p>
 * getFirst() 和getLast()：这些方法分别返回列表的第一个和最后一个元素。它们不会从列表删除返回的元素。如果列表为空，这些方法将抛出NoSuchElementExcpetion异常。</p>
 * peek()、peekFirst(),和peekLast()：这些方法分别返回列表的第一个和最后一个元素。它们不会从列表删除返回的元素。如果列表为空，这些方法将返回null值。</p>
 * poll()、pollFirst()和 pollLast()：这些方法分别返回列表的第一个和最后一个元素。它们从列表删除返回的元素。如果列表为空，这些方法将返回null值。</p>
 * add()、 addFirst()、addLast()：这些方法分别在第一个位置和最后一个位置上添加元素。如果列表已满（你已使用固定大小创建它），这些方法将抛出IllegalStateException异常。</p>
 * @author maosx
 *
 */
public class Main {
	public static void main(String[] args) {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
		
		/*Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		
		try {
			for(int i=0;i<3;i++){
				for(int j=0;j<5;j++){
					String request = list.take();
					System.out.println("Main : Request: "+request+" at "+new Date()+" size"+list.size());
				}
				TimeUnit.MILLISECONDS.sleep(300);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		boolean full = false;
		try {
			list.add("1");
			list.add("2");
			list.add("3");
			full = list.add("4");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(full);
	}
}
