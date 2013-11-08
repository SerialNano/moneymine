package com.icloud.jxthibeault.moneymine;

import java.io.File;

import com.icloud.jxthibeault.moneymine.FileSysManager;

public class JobApManager {
	public void createApplication(String user, String job, String pay, String requirement){
		File applic = new File("plugins/moneymine/applications.yml");
		boolean applic_file_exists = applic.exists();
		if(applic_file_exists == false){
			FileSysManager.createFile(applic.toString());
		}
		FileSysManager.appendFile(applic.toString(), job + "|" + user + "|" + pay + "|" + requirement);
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
