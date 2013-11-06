package com.icloud.jxthibeault.moneymine;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.icloud.jxthibeault.moneymine.FileSysManager;

public final class LoginListener implements Listener{
	public LoginListener(Moneymine plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event){
		String user = event.getPlayer().getDisplayName().toLowerCase().toString();
		File userFile = new File("plugins/moneymine/users/" + user + ".yml");
		boolean userExists = userFile.exists();
		if(userExists == false){
			FileSysManager.createFile(userFile.toString());
		}
	}
}