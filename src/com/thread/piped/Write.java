package com.thread.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

import com.thread.SleepUtils;

public class Write implements Runnable {
	private PipedOutputStream pos;
	
	public Write(PipedOutputStream pos){
		this.pos = pos;
	}
	
	@Override
	public void run() {
		System.out.println("Thread sleep 3 seconds. ");
		SleepUtils.second(3);
		try {
			this.pos.write("wangzhihong".getBytes());
			this.pos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(this.pos!=null)
					this.pos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
