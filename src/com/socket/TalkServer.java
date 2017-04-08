package com.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket server = null;
		Socket client = null;
		BufferedReader br = null;
		BufferedReader bi = null;
		PrintWriter pw = null;
		String line = null;
		
		server = new ServerSocket(5454);
		client = server.accept();
		//接收客户端数据
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		//接收服务端输入数据
		bi = new BufferedReader(new InputStreamReader(System.in));
		//响应客户端数据
		pw = new PrintWriter(client.getOutputStream());
		
		line = bi.readLine();
		
		while(!line.equalsIgnoreCase("bye")){
			pw.println(line);
			pw.flush();
			
			System.out.println("Server : "+line);
			System.out.println("Client : "+br.readLine());
			
			line = bi.readLine();
		}
		
		br.close();
		bi.close();
		pw.close();
		client.close();
		server.close();
	}
}
