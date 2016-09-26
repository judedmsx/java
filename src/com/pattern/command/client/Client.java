package com.pattern.command.client;

import com.pattern.command.command.ICommand;
import com.pattern.command.command.PageCommand;
import com.pattern.command.command.RequireCommand;
import com.pattern.command.invoker.ProjectManager;

public class Client {
	public static void main(String[] args) {
		ProjectManager manager = new ProjectManager();
		
		ICommand pageCommand = new PageCommand();
		ICommand requireCommand = new RequireCommand();
		
		manager.setCommand(pageCommand);
		manager.execute();
		
		manager.setCommand(requireCommand);
		manager.execute();
	}
}
