package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.command.CommandSender;

import com.icloud.jxthibeault.moneymine.FileSysManager;

public class JobApManager {
	public static void createApplication(CommandSender user, String job, String pay, String requirement){
		File applic = new File("plugins/moneymine/applications.yml");
		boolean jobExists = FileSysManager.checkJobExists(job);
		if(jobExists == false){
			FileSysManager.appendFile(applic.toString(), job + "|" + user.getName().toLowerCase().toString() + "|" + pay + "|" + requirement);
			user.sendMessage("Now accepting applicants for job '" + job + "'");
		} else {
			user.sendMessage("Another job with the name of '" + job + "' already exists.");
		}
	}
	
	public static void closeApplication(String job, CommandSender user){
		File applic = new File("plugins/moneymine/applications.yml");
		boolean jobExists = FileSysManager.checkJobExists(job);
		if(jobExists == false){
			user.sendMessage("No job could be found by the name of '" + job + "'");
		} else {
			String jobOwner = FileSysManager.getJobOwner(job);
			if(jobOwner != user.getName().toLowerCase().toString()){
				user.sendMessage("You are not the manager of this job!");
			} else {
				//close the application
			}
		}
	}
	
	public void applyForApplication(String user, String job){
		
	}
	
	public void revokeApplication(String user, String job){
		
	}
	
	public void acceptApplication(String user, String master){
		
	}
	
	public void denyApplication(String user, String master){
		
	}
	
	public void checkApplications(String master){
		
	}
}
