package com.icloud.jxthibeault.moneymine;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.icloud.jxthibeault.moneymine.FirstTimeSetup;

public final class Moneymine extends JavaPlugin {
	
	@Override
	public void onEnable(){
		File mmFolder = new File("plugins/moneymine");
		File trdFolder = new File("plugins/moneymine/trd");
		File radFile = new File("plugins/moneymine/trd/rad.mny");
		File yisFile = new File("plugins/moneymine//trd/yis.mny");
		
		boolean mmExists = mmFolder.exists();
		if(mmExists == false){
			mmFolder.mkdir();
		}
		
		boolean trdExists = trdFolder.exists();
		if(trdExists == false){
			trdFolder.mkdir();
			try {
				radFile.createNewFile();
				yisFile.createNewFile();
			} catch (IOException e) {}
			FirstTimeSetup.setup();
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("createjob")){
			if(args[0] == null){} else if (args[1] == null) {} else if (args[2] == null) {} else {
				//Check to make sure job of same name doesnt already exist
				JobManager.createNewJob(args[0], sender.toString().toLowerCase(), args[1], args[2]);
				sender.sendMessage("[Moneymine] Successfully created job '" + args[0] + "'");
			}
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("setuniform")){
			if(args[0] == null){} else if (args[1] == null){} else if (args[2] == null){} else if (args[3] == null){} else if (args[4] == null){} else{
				//Check to make sure job exists
				//Check to make sure sender is owner of job
				UniformManager.updateUniform(args[0], args[1], args[2], args[3], args[4]);
				sender.sendMessage("[Moneymine] Successfully updated uniform for " + args[0]);
			}
		}
		
		return false;
	}
	
}