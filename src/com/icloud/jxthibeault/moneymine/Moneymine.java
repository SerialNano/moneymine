/*
 * Copyright 2013 Joshua Thibeault. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

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
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		    MetricsGraphs.bugsGraph(this);
		} catch (IOException e) {
		    // Failed to submit the stats :-(
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