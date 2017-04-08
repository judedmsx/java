package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Socket client = null;
		BufferedReader br = null;
		BufferedReader bi = null;
		PrintWriter pw = null;
		String line = null;
		
		client = new Socket("127.0.0.1", 5454);
		//接收服务端数据
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//接收客户端输入数据
		bi = new BufferedReader(new InputStreamReader(System.in));
		//响应服务端数据
		pw = new PrintWriter(client.getOutputStream());
		
		line = bi.readLine();
		
		while(!line.equalsIgnoreCase("bye")){
			pw.println(line);
			pw.flush();
			System.out.println("Client : "+line);
			
			System.out.println("Server : "+br.readLine());
			
			line = bi.readLine();
		}
		
		br.close();
		bi.close();
		pw.close();
		client.close();
	}
}
