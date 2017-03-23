package com.thread.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
/**
 * 在Java并发API的第一个版本中，你必须创建和运行应用程序中的所有线程。</p>
 * 在Java版本5中，随着执行者框架（Executor framework）的出现，对于并发任务的执行，一个新的机制被引进。</p>
 * 使用执行者框架（Executor framework），你只要实现你的任务并把它们提交给执行者。这个执行者负责执行你的任务的线程的创建和执行。</p>
 * 在内部，一个执行者使用一个阻塞队列来存储待处理任务。以任务到达执行者的顺序来存储。</p>
 * 一个可能的替代就是使用一个优先级列队来存储新的任务。</p>
 * 这样，如果一个高优先级的新任务到达执行者，它将比其他已经在等待一个线程来执行它们，且低优先级的任务先执行。</p>
 * @author maosx
 *
 */
public class Main {
	public static void main(String[] args) {
		MyExecutor executor = new MyExecutor(2, 4, 1000, 
				TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
		
		List<Future<String>> results = new ArrayList<>();
		for(int i=0;i<10;i++){
			SleepTwoSecondsTask task = new SleepTwoSecondsTask();
			Future<String> result = executor.submit(task);
			results.add(result);
		}
		
		executor.shutdown();
	}
}
