package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
/**
 * 线程间交换数据
 * @author maosx
 *
 */
public class ExchangerTest {
	public static void main(String[] args) {
		Exchanger<List<Integer>> exchanger = new Exchanger<>();  
        new Consumer(exchanger).start();  
        new Producer(exchanger).start();  
	}
	
	public static class Producer extends Thread{
		private Exchanger<List<Integer>> exchanger;
		private List<Integer> list;
		
		public Producer(Exchanger<List<Integer>> exchanger) {
			super();
			this.exchanger = exchanger;
			this.list = new ArrayList<Integer>();
		}

		@Override
		public void run() {
			Random r = new Random();
			for(int i = 0;i < 10;i++){
				list.clear();
				list.add(r.nextInt(10000));
				list.add(r.nextInt(10000));
				list.add(r.nextInt(10000));
				list.add(r.nextInt(10000));
				list.add(r.nextInt(10000));
				try {
					list = this.exchanger.exchange(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static class Consumer extends Thread{
		
		private Exchanger<List<Integer>> exchanger;
		private List<Integer> list = new ArrayList<Integer>();
		
		public Consumer(Exchanger<List<Integer>> exchanger) {
			super();
			this.exchanger = exchanger;
		}

		@Override
		public void run() {
			try {
				list = this.exchanger.exchange(list);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i:list){
				System.out.println(i);
			}
		}
	}
}
