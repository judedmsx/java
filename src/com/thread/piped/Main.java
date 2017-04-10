package com.thread.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
	public static void main(String[] args) throws IOException {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);
		
		Thread read = new Thread(new Read(pis));
		Thread write = new Thread(new Write(pos));
		
		write.start();
		read.start();
	}
}
