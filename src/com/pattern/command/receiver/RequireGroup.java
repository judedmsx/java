package com.pattern.command.receiver;

public class RequireGroup implements IGroup {

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("添加需求");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删除需求");
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		System.out.println("修改需求");
	}

}
