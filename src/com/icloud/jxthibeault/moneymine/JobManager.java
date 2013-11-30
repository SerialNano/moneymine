package com.icloud.jxthibeault.moneymine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
		} catch (Exception e) {}
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
			
			
		} catch(Exception e){}
	}
	
}