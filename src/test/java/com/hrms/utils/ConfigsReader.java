package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	public static Properties prop;
	/* This method  will read properties files
	 * 
	 */
	public static void readProperties(String filePath) {
		try {
			FileInputStream fis= new FileInputStream(filePath);
			prop= new Properties();
			try {
				prop.load(fis);
				fis.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * This method will return value of specified key
	 * @param Key
	 * @return
	 */
	
	public static String getProperty(String Key) {
		return prop.getProperty(Key);
	}

}
