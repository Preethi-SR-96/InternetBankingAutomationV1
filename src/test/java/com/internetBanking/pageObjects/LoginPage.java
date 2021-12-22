package com.internetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement txt_Username;

	@FindBy(name="password")
	@CacheLookup
	WebElement txt_Password;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btn_Login;
	
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement Link_Logout;

	public void enterUsername(String uName) {
		txt_Username.sendKeys(uName);
	}

	public void enterPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}

	public void clickLogin() {
		btn_Login.click();
	}
	
	public void clickLogout() {
		Link_Logout.click();
	}
}
