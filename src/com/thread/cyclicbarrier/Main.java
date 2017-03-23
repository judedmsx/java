package com.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
/**
 * <p>在同一个点同步任务</p>
 * CyclicBarrier 类有一个内部计数器控制到达同步点的线程数量。
 * 每次线程到达同步点，它调用 await() 方法告知 CyclicBarrier 对象到达同步点了。
 * CyclicBarrier 把线程放入睡眠状态直到全部的线程都到达他们的同步点。
 * 当全部的线程都到达他们的同步点，CyclicBarrier 对象叫醒全部正在 await() 方法中等待的线程们，
 * 然后，选择性的，为CyclicBarrier的构造函数 传递的 Runnable 对象（例子里，是 Grouper 对象）创建新的线程执行外加任务。
 * 
 * @author maosx
 *
 */
public class Main {
	public static void main(String[] args) {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int PAGE_SIZE = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Results results = new Results(ROWS);
		Grouper gouper = new Grouper(results);
		//���� CyclicBarrier ������Ϊ barrier���˶����ȴ�5���̡߳������߳̽���������ִ��ǰ�洴���� Grouper ����
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, gouper);
		
		for(int i = 0;i < PARTICIPANTS;i++){
			Thread thread = new Thread(
					new Searcher(i*PAGE_SIZE, i*PAGE_SIZE+PAGE_SIZE, mock, SEARCH, results, barrier));
			thread.start();
		}
		
		System.out.println("The main thread finished.");
	}
}
