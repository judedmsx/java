package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask类提供一个done()方法，允许你在执行者执行任务完成后执行一些代码。
 * 你可以用来做一些后处理操作，生成一个报告，通过e-mail发送结果，或释放一些资源。
 * 当执行的任务由FutureTask来控制完成，FutureTask会内部调用这个方法。
 * 这个方法在任务的结果设置和它的状态变成isDone状态之后被调用，不管任务是否已经被取消或正常完成。
 * @author maosx
 *
 */
public class FutureTaskTest {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			MyFutureTask futureTask = new MyFutureTask(new Task());
			executor.submit(futureTask);
		}
		
		executor.shutdown();
	}
	
	
	public static class MyFutureTask extends FutureTask<String>{
		public MyFutureTask(Callable<String> callable) {
			super(callable);
		}

		@Override
		protected void done() {
			try {
				System.out.println(get() +" thread done !!!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class Task implements Callable<String>{
		@Override
		public String call() throws Exception {
			SleepUtils.second(5);
			System.out.println(Thread.currentThread().getName()+" call..");
			return Thread.currentThread().getName()+" call..";
		}
	}
}
