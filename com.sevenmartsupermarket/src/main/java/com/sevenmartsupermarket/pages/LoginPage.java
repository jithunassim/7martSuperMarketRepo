package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtility generalutility;
	Properties properties=new Properties();
	FileInputStream ip;
	
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement userNameField;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement passWordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try 
		{
			ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			
			
			properties.load(ip);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		passWordField.sendKeys(password);
	}
	public void clickSignIn()
	{
		signIn.click();
	}
	public void login()
	{
		String userName=properties.getProperty("username");
		String passWord=properties.getProperty("password");
		login(userName,passWord);//method overloading eg
				
	}
	public void login(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickSignIn();
		
	}
	public boolean checkErrorMessage(String expectedErrorMessage) {
		generalutility = new GeneralUtility(driver);
		return generalutility.isWordPresent(alert, expectedErrorMessage);
	
	}
}
