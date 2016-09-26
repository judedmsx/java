package com.pattern.command.invoker;

import com.pattern.command.command.ICommand;

public class ProjectManager {
	private ICommand command;

	public ProjectManager() {
	}
	
	public ProjectManager(ICommand command) {
		super();
		this.command = command;
	}
	
	public void execute(){
		command.execute();
	}

	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}
}
