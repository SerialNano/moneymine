package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.icloud.jxthibeault.moneymine.FileSysManager;
import com.icloud.jxthibeault.moneymine.JobApManager;

public final class Moneymine extends JavaPlugin{
	
	File userDirectory = new File("plugins/moneymine/users");
	
	public void onEnable(){
		boolean userDirExists = userDirectory.exists();
		if(userDirExists == false){
			userDirectory.mkdir();
		}
		new LoginListener(this);
	}
	
	
}