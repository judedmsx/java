package com.pattern.command.command;

import com.pattern.command.receiver.RequireGroup;


public class RequireCommand implements ICommand {
	private RequireGroup group = new RequireGroup();
	
	@Override
	public void execute() {
		group.add();
		group.edit();
	}
}
