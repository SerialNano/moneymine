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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.bukkit.plugin.java.JavaPlugin;

public class JobManager{
	
	public static void createTable(){
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:plugins/moneymine/moneymine.db");
			stmt = c.createStatement();
			String sql = "CREATE TABLE jobs " + "(job TEXT PRIMARY KEY," + " player TEXT," + " employee TEXT," + " wageAmount TEXT," + " wageCurrency TEXT);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			getLogger().info(e);
		}
	}
	
	public static void createNewJob(String job, String player, String wageAmount, String wageCurrency){
		//Add checking for job already existing
		
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:plugins/moneymine/moneymine.db");
			c.setAutoCommit(false);
			
			stmt = c.createStatement();
			String sql = "INSERT INTO uniforms (job, hat, shirt, pants, shoes) "
					+ "VALUES (" + job + " , 'null', 'null', 'null', 'null' );";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO jobs (job, player, employee, wageAmount, wageCurrency) "
					+ "VALUES ('" + job + "', '" + player + "', 'null', '" + wageAmount + "', '" + wageCurrency + "' );";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
			
			
		} catch(Exception e){
			getLogger().info(e);
		}
	}
	
}
