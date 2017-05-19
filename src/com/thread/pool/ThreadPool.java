package com.thread.pool;

public interface ThreadPool<Job extends Runnable> {
	public void execute(Job job);
	public void addWorkers(int num);
	public void removeWorkers(int num);
	public void shutdown();
	public int getJobSize();
}
