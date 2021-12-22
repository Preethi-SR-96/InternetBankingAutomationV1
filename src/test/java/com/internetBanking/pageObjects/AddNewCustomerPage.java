package com.internetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	public AddNewCustomerPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement Link_NewCustomer;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='name']")
	WebElement txt_customerName;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='rad1' and @value='m']")
	WebElement btn_Gender_Male;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	WebElement btn_Gender_Female;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='dob']")
	WebElement txt_Date;
	
	@CacheLookup
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txt_Address;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='city']")
	WebElement txt_City;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='state']")
	WebElement txt_State;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txt_PIN;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txt_mobileNumber;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='emailid']")
	WebElement txt_Email;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_Password;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='sub']")
	WebElement btn_Submit;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='res']")
	WebElement btn_Reset;
	
	public void clickNewCustomerLink() {
		Link_NewCustomer.click();
	}
	
	public void enterCustomerName(String cName) {
		txt_customerName.sendKeys(cName);
	}

	public void SelectGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) 
		{
		btn_Gender_Male.click();
		}
		else 
		{
		btn_Gender_Female.click();
		}
	}
	
	public void enterCustomerDOB(String mm, String dd, String yyyy) {
		txt_Date.sendKeys(mm);
		txt_Date.sendKeys(dd);
		txt_Date.sendKeys(yyyy);
	}
	
	public void enterCustomerAddress(String address) {
		txt_Address.sendKeys(address);
	}
	
	public void enterCustomerCity(String city) {
		txt_City.sendKeys(city);
	}
	
	public void enterCustomerState(String state) {
		txt_State.sendKeys(state);
	}
	
	public void enterCustomerPincode(String pin) {
		txt_PIN.sendKeys(pin);
	}
	
	public void enterCustomerMobileNo(String mobile) {
		txt_mobileNumber.sendKeys(mobile);
	}
	
	public void enterCustomerEmail(String email) {
		txt_Email.sendKeys(email);
	}
	
	public void enterCustomerPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}

	public void clickSubmit() {
		btn_Submit.click();
	}
	
	public void clickReset() {
		btn_Reset.click();
	}
}
