package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public final class Moneymine extends JavaPlugin{
	
	Stringw[] users = new String[]{};
	File userDirectory = new File("plugins/moneymine/users");
	
	public void onEnable(){
		getLogger().info("Loading users from file...");
		File[] users = userDirectory.listFiles();
	}
	
}