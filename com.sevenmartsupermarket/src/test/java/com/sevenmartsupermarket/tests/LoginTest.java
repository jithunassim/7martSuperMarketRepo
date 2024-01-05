package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listerners.RetryAnalyzer;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.DataProviderUtility;
import com.sevenmartsupermarket.utilities.ScreenShot;
public class LoginTest extends Base
{
	LoginPage loginpage;
	HomePage homepage;
	
	
@Test(groups="smoke")
public void verifyLogin()
{
	loginpage=new LoginPage(driver);
	homepage=new HomePage(driver);
	String expectedProfileName="Admin";
	loginpage.login();
	String actualProfileName=homepage.getProfileName();
	Assert.assertEquals(actualProfileName, expectedProfileName);
}

@Test(groups="regression")
public void verify_invalidLogin_ErrorMsg()
{
	loginpage=new LoginPage(driver);
	loginpage.login("user","45");
	boolean actualResult=loginpage.checkErrorMessage("Alert");
	Assert.assertTrue(actualResult);
}
@Test(dataProvider="LoginData2",dataProviderClass =DataProviderUtility.class)
public void verifyMultipleLogin(String userName,String password,String expectedProfileName)
{
	loginpage=new LoginPage(driver);
	homepage=new HomePage(driver);
	loginpage.login(userName,password);
	//String actualResult=loginpage.multipleLogin(userName, password, profileName);
	//String expectedResult=profileName;
	System.out.println(userName);
	System.out.println(password);
	
	String actualProfileName=homepage.getProfileName();
	Assert.assertEquals(actualProfileName, expectedProfileName);
}

@Test
public void runScreenShot()
{
//jithu	//C:\JenkinsWorkspace\com.sevenmartsupermarket\pom.xml
}
}
