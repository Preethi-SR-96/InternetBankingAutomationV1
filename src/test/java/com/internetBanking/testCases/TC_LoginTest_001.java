package com.internetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internetBanking.Utilities.TakeSnapshot;
import com.internetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
	
	LoginPage lp = new LoginPage(driver);
	
	lp.enterUsername(username);
	logger.info("Entered Username");
	
	lp.enterPassword(password);
	logger.info("Entered Password");
	
	lp.clickLogin();
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		logger.info("Login Test Passed");
	}
	else {
		TakeSnapshot.TakeScreenshot(driver, "loginTest");
		Assert.assertTrue(false);
		logger.info("Login Test Failed");
	}
	}

}
