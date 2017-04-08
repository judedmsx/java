package com.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket client = new Socket("127.0.0.1", 6666);
		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Thread.sleep(3000);	
		dos.writeUTF("Hello server!");
		dos.flush();
		dos.close();
		client.close();
	}
}
