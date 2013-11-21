package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.icloud.jxthibeault.moneymine.JobApManager;

public final class Moneymine extends JavaPlugin{
	
	File userTopDirectory = new File("plugins/moneymine");
	File userDirectory = new File("plugins/moneymine/users");
	
	public void onEnable(){
		boolean userTopDirExists = userTopDirectory.exists();
		if(userTopDirExists == false){
			userTopDirectory.mkdir();
		}
		
		boolean userDirExists = userDirectory.exists();
		if(userDirExists == false){
			userDirectory.mkdir();
		}
		
		File applic = new File("plugins/moneymine/applications.yml");
		boolean applic_file_exists = applic.exists();
		if(applic_file_exists == false){
			FileSysManager.createFile(applic.toString());
		}
		
		new LoginListener(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("openapp")){
			if(args[0] == null){
				sender.sendMessage("usage: /openapp [jobname] [pay]");
			} else if (args[1] == null){
				sender.sendMessage("usage: /openapp [jobname] [pay]");
			} else {
				JobApManager.createApplication(sender, args[0], args[1]);
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("closeapp")){
			if(args[0] == null){
				sender.sendMessage("usage: /closeapp [job]");
			} else {
				JobApManager.closeApplication(args[0], sender);
			}
			return true;
		}
		
		return false;
	}
	
}