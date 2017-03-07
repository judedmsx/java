package com.thread;

public class Daemon {
	static class DaemonRunner implements Runnable{
		
		public static void main(String[] args) {
			Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
			thread.setDaemon(true);
			thread.start();
		}

		@Override
		public void run() {
			try {
				SleepUtils.second(10);
			}finally{
				System.out.println("daemonthread finally run.");
			}
		}
		
	}
}
