package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.command.CommandSender;

import com.icloud.jxthibeault.moneymine.FileSysManager;
import com.icloud.jxthibeault.moneymine.ApSysManager;

public class JobApManager {
	public static void createApplication(CommandSender user, String job, String pay){
		File applic = new File("plugins/moneymine/applications.yml");
		boolean jobExists = ApSysManager.checkJobExists(job);
		if(jobExists == false){
			FileSysManager.appendFile(applic.toString(), job + "|" + user.getName().toString() + "|" + pay);
			user.sendMessage("Now accepting applicants for job '" + job + "'");
		} else {
			user.sendMessage("Another job with the name of '" + job + "' already exists.");
		}
	}
	
	public static void closeApplication(String job, CommandSender user){
		boolean jobExists = ApSysManager.checkJobExists(job);
		if(jobExists == false){
			user.sendMessage("No job could be found by the name of '" + job + "'");
		} else {
			String jobOwner = ApSysManager.getJobOwner(job);
			if(jobOwner != user.getName().toString()){
				user.sendMessage("Only " + jobOwner + " can close this application!");
			} else {
				//Code to close the Application
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
