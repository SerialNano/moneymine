package com.icloud.jxthibeault.moneymine;

import java.io.File;
import java.io.FileNotFoundException;
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
		FileWriter appender = null;
		try {
			appender = new FileWriter(filepath, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			appender.write(dataText);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			appender.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
