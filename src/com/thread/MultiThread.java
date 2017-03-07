package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;

public class MultiThread {
	public static void main(String[] args) throws InterruptedException {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo []threadInfos = threadMXBean.dumpAllThreads(false, false);
		for(ThreadInfo threadInfo:threadInfos){
			System.out.println(threadInfo.getThreadId()+"---"+threadInfo.getThreadName());
		}
		TimeUnit.SECONDS.sleep(60);
	}
}
