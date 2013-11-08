package com.icloud.jxthibeault.moneymine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileSysManager {
	public static void createFile(String filepath){					//Class for creating a new file
		PrintWriter creator = null;
		try {
			creator = new PrintWriter(filepath, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		creator.close();
	}
	
	public static void deleteFile(String filepath){					//Class for deleting an existing file
		File target = new File(filepath);
		target.delete();
	}
	
	public static void appendFile(String filepath, String dataText){	//Class for appending to an existing file
		BufferedWriter appender = null;
		try {
			appender = new BufferedWriter(new FileWriter(filepath, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			appender.write(dataText);
			appender.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			appender.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
		String jobOwner =  null;
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("plugins/moneymine/applications.yml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean jobFound = false;
		String line = null;
		String jobRead = null;
		int endOfJob = 0;
		
		while(jobFound == false){
			try {
				line = fileReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(line == null){
				jobFound = true;
				jobOwner = "null";
			}
			
			endOfJob = ((line.indexOf("|")) - 1);
			jobRead = line.substring(0, endOfJob);
			String lineNew = line.substring(endOfJob + 1);
			
			if(jobRead == job){
				jobFound = true;
				int endOfUser = 0;
				endOfUser = ((lineNew.indexOf("|")) - 1);
				jobOwner = lineNew.substring(0, endOfUser);
			}
			
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jobOwner;
	}
}
