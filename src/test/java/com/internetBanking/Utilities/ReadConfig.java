package com.internetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	static Properties properties;
	
	public ReadConfig() {
		File src = new File("./Configurations\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);		
		}
		catch(Exception e){
			System.out.println("Exception is " + e.getMessage());
			}
		}
	
	public static String getAppicationUrL() {
		String URL = properties.getProperty("baseURL");
		return URL;
	}
	
	public static String getUsername() {
		String uName = properties.getProperty("username");
		return uName;
	}
	
	public static String getPassword() {
		String pwd = properties.getProperty("password");
		return pwd;
	}
	
	public static String getChromePath() {
		String chromePath = properties.getProperty("Chrome_Driver_Path");
		return chromePath;
	}
	
	public static String getFirefoxPath() {
		String firefoxPath = properties.getProperty("Firefox_Driver_Path");
		return firefoxPath;
	}
	
	public static String getCustomername() {
		String cName = properties.getProperty("customerName");
		return cName;
	}
	
	public static String getGender() {
		String gender = properties.getProperty("Gender");
		return gender;
	}
	
	public static String getDate() {
		String dd = properties.getProperty("Date");
		return dd;
	}
	
	public static String getMonth() {
		String mm = properties.getProperty("Month");
		return mm;
	}
	
	public static String getYear() {
		String yyyy = properties.getProperty("Year");
		return yyyy;
	}
	
	public static String getAddress() {
		String address = properties.getProperty("Address");
		return address;
	}
	
	public static String getCity() {
		String city = properties.getProperty("City");
		return city;
	}
	
	public static String getState() {
		String state = properties.getProperty("State");
		return state;
	}
	
	public static String getPin() {
		String pin = properties.getProperty("Pin");
		return pin;
	}
	
	public static String getMobileNo() {
		String mobile = properties.getProperty("MobileNo");
		return mobile;
	}
	
	/*
	 * public static String getEmail() { String email =
	 * properties.getProperty("Email"); return email; }
	 */
	
	public static String getCusPassword() {
		String cpwd = properties.getProperty("CusPassword");
		return cpwd;
	}

}
