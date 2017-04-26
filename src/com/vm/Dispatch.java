package com.vm;

public class Dispatch {
	static class QQ{}
	
	static class _360{}
	
	public static class Father{
		public void hardChoice(QQ arg){
			System.out.println("father choose qq");
		}
		
		public void hardChoice(_360 arg){
			System.out.println("father choose 360");
		}
	}
	
	
	public static class Son extends Father{
		public void hardChoice(QQ arg){
			System.out.println("son choose qq");
		}
		
		public void hardChoice(_360 arg){
			System.out.println("son choose 360");
		}
	}
	//编译阶段 静态多分派  运行阶段 动态单分派
	public static void main(String[] args) {
		Father father = new Father();
		Father son = new Son();
		father.hardChoice(new _360());
		son.hardChoice(new QQ());
	}
}
