package com.six.console;

import java.io.Console;

public class ConsoleTest {
	public static void main(String[] args) {
		Console console = System.console();
		if(console!=null){
			String user = new String(console.readLine("Enter user:"));
			String pwd  =new String(console.readLine("Enter password:"));
			console.printf("user is:"+user+"\n");
			console.printf("password is:"+pwd+"\n");
		}else{
			System.out.println("console is unavailable");
		}
	}
}
