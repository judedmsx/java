package com.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 这个类会在随机数字的矩阵中的特定的行里查找数字。
 * @author maosx
 *
 */
public class Searcher implements Runnable {

	private int firstRow;
	private int lastRow;
	private MatrixMock mock;
	private int number;
	private Results results;
	private final CyclicBarrier cyclicBarrier;
	
	public Searcher(int firstRow, int lastRow, MatrixMock mock, int number, Results results,
			CyclicBarrier cyclicBarrier) {
		super();
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.number = number;
		this.results = results;
		this.cyclicBarrier = cyclicBarrier;
	}


	@Override
	public void run() {
		System.out.println("Searcher : Thread of Searcher from "+firstRow+" to "+lastRow+" find "+number+" .");
		int counter;
		for(int i = firstRow;i < lastRow;i++){
			int data[] = mock.getRow(i);
			counter = 0;
			for(int j = 0;j < data.length;j++){
				if(data[j] == number){
					counter++;
					results.setData(i, counter);
				}
			}
		}
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
