package com.icloud.jxthibeault.moneymine;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import lib.PatPeter.SQLibrary.Database;
import lib.PatPeter.SQLibrary.SQLite;

public final class moneymine extends JavaPlugin{

	private Database sql;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("createjob")){
			sql = new SQLite(Logger.getLogger("Minecraft"), "moneymine ", this.getDataFolder().getAbsolutePath(), "moneymine", ".db");
			if (sql.open()){
				if (!(sql.isTable("jobs"))){
					try {
						sql.query("CREATE TABLE jobs(name varchar(20), owner varchar(20), wage varchar(20), description varchar(100))");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				sql.query("INSERT INTO jobs(name, owner, wage, description) values ('" &&  && "', '"");
			}
			return true;
		}
		return false;
	}
}
