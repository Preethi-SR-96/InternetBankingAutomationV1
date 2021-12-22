package com.internetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.internetBanking.Utilities.ReadConfig;
import com.internetBanking.Utilities.TakeSnapshot;


public class BaseClass {

	public static WebDriver driver;
	
	ReadConfig readConfig = new ReadConfig();
	
	TakeSnapshot captureScreen = new TakeSnapshot();

	public String baseURL = ReadConfig.getAppicationUrL();
	public String username = ReadConfig.getUsername();
	public String password = ReadConfig.getPassword();
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browserName) {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", ReadConfig.getChromePath());
		driver = new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
		System.setProperty("webdriver.gecko.driver", ReadConfig.getFirefoxPath());
		driver = new FirefoxDriver();	
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		logger.info("Launched the URL");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//the below method will generate random alphabets(8 characters)
	public String randomStringGenerate() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	//the below method will generate random numbers(5 characters)
	public String randomNumGenerate() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	
	//the below method will generate random alphanumeric(9 characters)
	public String randomAlphaNumGenerate() {
		String generatedString = RandomStringUtils.randomAlphanumeric(9);
		return generatedString;
	}
}
