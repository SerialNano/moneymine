package com.icloud.jxthibeault.moneymine;

import java.io.File;

import com.icloud.jxthibeault.moneymine.UniformManager;

public class FirstTimeSetup{
	public static void setup(){
		File mmdb = new File("plugins/moneymine/moneymine.db");
		mmdb.delete();
		UniformManager.createTable();
	}
}