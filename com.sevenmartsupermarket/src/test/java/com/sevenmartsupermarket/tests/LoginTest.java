package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ScreenShot;


public class LoginTest extends Base

{
	LoginPage loginpage;
	HomePage homepage;
@Test
public void verifyLogin()
{
	loginpage=new LoginPage(driver);
	homepage=new HomePage(driver);
	String expectedProfileName="Admin";
	loginpage.login();
	String actualProfileName=homepage.getProfileName();
	Assert.assertEquals(actualProfileName, expectedProfileName);
			
}
@Test
public void verify_invalidLogin_ErrorMsg()
{
	loginpage=new LoginPage(driver);
	loginpage.login("user","45");//worng username password checking
	// String printErrorMsg=loginpage.getErrorMsg();
	// System.out.println(printErrorMsg);
	boolean actualResult=loginpage.checkErrorMessage("Alert");
	//ScreenShot screenshot=new ScreenShot();
	//screenshot.takeScreenShot(driver,"jithu");
	Assert.assertTrue(actualResult);
}
@Test
public void runScreenShot()
{
//jithu	
}
}
//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