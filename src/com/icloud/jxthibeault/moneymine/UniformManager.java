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
import java.sql.ResultSet;
import java.sql.Statement;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.icloud.jxthibeault.moneymine.armorID;

public class UniformManager{
	
	public static void createTable(){
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:plugins/moneymine/moneymine.db");
			stmt = c.createStatement();
			String sql = "CREATE TABLE uniforms " + "(job TEXT PRIMARY KEY," + " hat TEXT," + " shirt TEXT," + " pants TEXT," + " shoes TEXT);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {}
	}
	
	public static void updateUniform(String job, String hat, String shirt, String pants, String shoes){
		Connection c = null;
		Statement stmt = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:plugins/moneymine/moneymine.db");
			c.setAutoCommit(false);
			
			stmt = c.createStatement();
			String sql = "UPDATE uniforms set hat = " + hat + " where job=" + job +";";
			stmt.executeUpdate(sql);
			c.commit();
			
			sql = "UPDATE uniforms set shirt = " + shirt + " where job=" + job +";";
			stmt.executeUpdate(sql);
			c.commit();
			
			sql = "UPDATE uniforms set pants = " + pants + " where job=" + job +";";
			stmt.executeUpdate(sql);
			c.commit();
			
			sql = "UPDATE uniforms set shoes = " + shoes + " where job=" + job +";";
			stmt.executeUpdate(sql);
			c.commit();
			
			c.close();
			stmt.close();
		} catch (Exception E){}
	}
	
	@SuppressWarnings({ "deprecation" })
	public static void giveUniform(Player p, String job){
		PlayerInventory pi = p.getInventory();
		
		String hat = null;
		String shirt = null;
		String pants = null;
		String shoes = null;
		
		String jobRead = null;
		
		Connection c = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:plugins/moneymine/moneymine.db");
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM uniforms;");
			while ( rs.next() ){
				jobRead = rs.getString("job");
				hat = rs.getString("hat");
				shirt = rs.getString("shirt");
				pants = rs.getString("pants");
				shoes = rs.getString("shoes");

				if(jobRead == job){
					ItemStack hatItem = new ItemStack(armorID.helmet(hat), 0);
					ItemStack shirtItem = new ItemStack(armorID.chestplate(shirt), 0);
					ItemStack pantsItem = new ItemStack(armorID.leggings(pants), 0);
					ItemStack shoesItem = new ItemStack(armorID.boots(shoes), 0);
					
					pi.setHelmet(hatItem);
					pi.setChestplate(shirtItem);
					pi.setLeggings(pantsItem);
					pi.setBoots(shoesItem);
				}
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception E){}
	}
	
}