package com.icloud.jxthibeault.moneymine;

import java.io.File;
import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

//onEnable, check for plugins/moneymine
//On job creation, create row for job in uniforms table

public final class Moneymine extends JavaPlugin {
	
	@Override
	public void onEnable(){
		File mmFolder = new File("plugins/moneymine");
		File trdFolder = new File("plugins/moneymine/trd");
		File radFile = new File("plugins/moneymine/rad.mny");
		File yisFile = new File("plugins/moneymine/yis.mny");
		
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
		}
	}
	
}