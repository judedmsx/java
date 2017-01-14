package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;


public class TestNIO {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
		System.out.println(URLDecoder.decode("%20ZK%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6%E8%AF%A6%E8%A7%A3", "UTF-8"));
	}
	
	public static void demo1(){
		try {
			FileInputStream fromFile = new FileInputStream("/Users/maosx/Downloads/fromFile.txt");
			FileChannel fromChannel = fromFile.getChannel();
			
			FileOutputStream toFile = new FileOutputStream("/Users/maosx/Downloads/toFile.txt");
			FileChannel toChannel = toFile.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(10);
			
			while(true){
				buffer.clear();
				int r = fromChannel.read(buffer);
				if(r==-1)
					break;
				buffer.flip();
				toChannel.write(buffer);
			}
			fromFile.close();
			toFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void demo2(){
		try {
			FileInputStream fromFile = new FileInputStream("/Users/maosx/Downloads/fromFile.txt");
			FileChannel fromChannel = fromFile.getChannel();
			
			FileOutputStream toFile = new FileOutputStream("/Users/maosx/Downloads/toFile.txt");
			FileChannel toChannel = toFile.getChannel();
			
			fromChannel.transferTo(0, fromChannel.size(), toChannel);
			fromFile.close();
			toFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void demo3(){
		try {
			RandomAccessFile fromFile = new RandomAccessFile("/Users/maosx/Downloads/fromFile.txt", "rw");
			FileChannel fromChannel = fromFile.getChannel();
			
			RandomAccessFile toFile = new RandomAccessFile("/Users/maosx/Downloads/toFile.txt", "rw");
			FileChannel toChannel = toFile.getChannel();
			
			long position = 0;
			long count = fromChannel.size();
			
			fromChannel.transferTo(position, count, toChannel);
			
			fromChannel.close();
			toChannel.close();
			fromFile.close();
			toFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void demo4(){
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("http://jenkov.com/", 80));
			
			RandomAccessFile toFile = new RandomAccessFile("/Users/maosx/Downloads/toFile.txt", "rw");
			FileChannel toChannel = toFile.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(10);
			
			
			while(true){
				buffer.clear();
				int r = socketChannel.read(buffer);
				System.out.println(r);
				if(r==-1)
					break;
				buffer.flip();
//				toChannel.write(buffer);
			}
			
			
			socketChannel.close();
			toChannel.close();
			toFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
