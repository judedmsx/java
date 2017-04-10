package com.thread.piped;

import java.io.IOException;
import java.io.PipedInputStream;

public class Read implements Runnable{
	private PipedInputStream pis;
	
	public Read(PipedInputStream pis){
		this.pis = pis;
	}
	@Override
	public void run() {
		byte []buf = new byte[1024];
		try {
			this.pis.read(buf);
			System.out.println(new String(buf));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pis!=null)
					pis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
