package com.icloud.jxthibeault.moneymine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApSysManager {
	public static boolean checkJobExists(String job){					//Class for checking if a job exists
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("plugins/moneymine/applications.yml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line;
		try {
			while((line = fileReader.readLine()) != null){
				if(line.contains(job) == true){
					return true;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static String getJobOwner(String job){					//Class for retrieving the creator of a job
		String jobOwner = "null";
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("plugins/moneymine/applications.yml"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String line;
		try {
			while((line = fileReader.readLine()) != null){
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jobOwner;
	}
}
