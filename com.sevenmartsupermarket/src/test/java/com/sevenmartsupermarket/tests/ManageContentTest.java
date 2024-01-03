package com.sevenmartsupermarket.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listerners.RetryAnalyzer;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageContentPage;

public class ManageContentTest extends Base
{
	ManageContentPage managecontentpage;
	LoginPage loginpage;
	@Test(groups="smoke",retryAnalyzer = RetryAnalyzer.class)
	public void verifyListOutDropDown()
	{
		loginpage=new LoginPage(driver);
		managecontentpage=new ManageContentPage(driver);
		loginpage.login();
		List<String> actualresult=managecontentpage.checkListOutDropDown();
		String[] expectedResult={"Manage Pages","Manage Footer Text","Manage Contact","Manage News"};
		Assert.assertEquals(actualresult, expectedResult);
	}
	@Test(groups={"smoke","regression"})
	public void verifyAddNewNews()
	{
		loginpage=new LoginPage(driver);
		managecontentpage=new ManageContentPage(driver);
		loginpage.login();
		managecontentpage.checkListOutDropDown();
		managecontentpage.enterNewNews(); 
		boolean actualResult=managecontentpage.checkPushNotificationMeessage("News Created Successfully");
		Assert.assertTrue(actualResult);
	
		
	}
}
 