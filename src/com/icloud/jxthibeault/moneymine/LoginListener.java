package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.icloud.jxthibeault.moneymine.FileSysManager;

public final class LoginListener implements Listener{
	public LoginListener(Moneymine plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event){
		String user = event.getPlayer().toString();
		File userFile = new File("users/" + user + ".yml");
		boolean userExists = userFile.exists();
		if(userExists == false){
			FileSysManager.createFile(userFile.toString());
		}
	}
}