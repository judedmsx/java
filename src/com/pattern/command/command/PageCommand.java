package com.pattern.command.command;

import com.pattern.command.receiver.PageGroup;

public class PageCommand implements ICommand{
	private PageGroup group = new PageGroup();
	
	@Override
	public void execute() {
		group.add();
		group.edit();
	}

}
