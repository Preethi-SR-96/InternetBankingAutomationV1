package com.internetBanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetBanking.Utilities.XLUtils;
import com.internetBanking.pageObjects.LoginPage;

public class TC_LoginTest_DDT_002 extends BaseClass {
	
	@Test(dataProvider="Login")
	public void loginTest(String uname, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUsername(uname);
		logger.info("Entered username");
		lp.enterPassword(pwd);
		logger.info("Entered password");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();//close logout alert
			logger.info("Logout successfully");
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="Login")
	String[][] getData() throws IOException{
		
		String XLFileLocation = "C:\\Users\\Velu Samy\\Desktop\\Preethi_workspace\\InternetBanking_Automation1\\src\\test\\java\\com\\internetBanking\\TestData\\LoginData.xlsx";
		//String XLFileLocation = System.getProperty("user.dir") + "/src/test/java/com/internetBanking/TestData/LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(XLFileLocation,"Sheet1");
		int colCount = XLUtils.getCellCount(XLFileLocation, "Sheet1", 1);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(XLFileLocation, "Sheet1", i, j);
			}
		}
		
		return loginData;
		
	}

}
