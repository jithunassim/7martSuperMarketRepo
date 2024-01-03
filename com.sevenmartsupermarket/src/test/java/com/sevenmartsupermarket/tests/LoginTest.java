package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listerners.RetryAnalyzer;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
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

@Test
public void runScreenShot()
{
//jithu	
}
}
