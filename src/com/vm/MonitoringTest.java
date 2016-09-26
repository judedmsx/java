package com.vm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * -Xms100M -Xmx100M -XX:+UseSerialGC
 */
public class MonitoringTest {
	static class OOMObject{
		public byte[] placeholder = new byte[64*1024];//�ڴ�ռλ����64KB
	}
	
	public static void fillHeap(int num) throws InterruptedException{
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(int i = 0;i < num;i++){
			//������ʱ����������ߵı仯��������
			Thread.sleep(50);
			list.add(new OOMObject());
		}
	}
	
	/**
	 * �߳���ѭ����ʾ
	 */
	public static void createBusyThread(){
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true);
			}
		},"testBusyThread");
		thread.start();
	}
	
	/**
	 * 
	 * �߳����ȴ���ʾ           .<br>
	 *
	 * @param lock  void
	 */
	public static void createLockThread(final Object lock){
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		},"testLockThread");
		thread.start();
	}
	
	/**
	 * �߳������ȴ���ʾ
	 */
	static class SynAddRunnable implements Runnable{
		int a,b;
		public SynAddRunnable(int a, int b){
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		fillHeap(1000);
		System.gc();
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		createBusyThread();
		br.readLine();
		Object object = new Object();
		createLockThread(object);*/
		
		/*for(int i = 0;i < 100;i++){
			new Thread(new SynAddRunnable(1, 2)).start();
			new Thread(new SynAddRunnable(2, 1)).start();
		}*/
	}
}

