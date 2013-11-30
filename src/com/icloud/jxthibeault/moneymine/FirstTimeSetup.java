//All Rights Reserved for Joshua Thibeault unless otherwise explicitly stated.

package com.icloud.jxthibeault.moneymine;

import java.io.File;

import com.icloud.jxthibeault.moneymine.UniformManager;
import com.icloud.jxthibeault.moneymine.JobManager;

public class FirstTimeSetup{
	public static void setup(){
		File mmdb = new File("plugins/moneymine/moneymine.db");
		mmdb.delete();
		UniformManager.createTable();
		JobManager.createTable();
	}
}