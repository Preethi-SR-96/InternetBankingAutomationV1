package com.internetBanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.internetBanking.Utilities.ReadConfig;
import com.internetBanking.Utilities.TakeSnapshot;
import com.internetBanking.pageObjects.AddNewCustomerPage;
import com.internetBanking.pageObjects.LoginPage;


public class TC_AddNewCustomerTest extends BaseClass{
	
	@Test	
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUsername(username);
		logger.info("Entered Username");
		
		lp.enterPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		
		AddNewCustomerPage nc = new AddNewCustomerPage(driver);
		
		nc.clickNewCustomerLink();
		nc.enterCustomerName(ReadConfig.getCustomername());
		nc.SelectGender(ReadConfig.getGender());	
		nc.enterCustomerDOB(ReadConfig.getMonth(),ReadConfig.getDate(),ReadConfig.getYear());
		
		Thread.sleep(3000);
		
		nc.enterCustomerAddress(ReadConfig.getAddress());
		nc.enterCustomerCity(ReadConfig.getCity());
		nc.enterCustomerState(ReadConfig.getState());
		nc.enterCustomerPincode(ReadConfig.getPin());
		nc.enterCustomerMobileNo(ReadConfig.getMobileNo());
		
		Thread.sleep(3000);
		
		String email = randomStringGenerate()+"@gmail.com";
		nc.enterCustomerEmail(email);
		nc.enterCustomerPassword(ReadConfig.getCusPassword());
		
		nc.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true) {
			Assert.assertTrue(true);
		}
		else {
			TakeSnapshot.TakeScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
