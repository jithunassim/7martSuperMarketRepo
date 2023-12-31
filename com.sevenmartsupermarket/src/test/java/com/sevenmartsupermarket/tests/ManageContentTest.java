package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageContentPage;

public class ManageContentTest extends Base
{
	ManageContentPage managecontentpage;
	LoginPage loginpage;
	@Test
	public void verifyListOutDropDown()
	{
		loginpage=new LoginPage(driver);
		managecontentpage=new ManageContentPage(driver);
		loginpage.login();
		managecontentpage.checkListOutDropDown();
	}
	@Test
	public void verifyAddNewNews()
	{
		loginpage=new LoginPage(driver);
		managecontentpage=new ManageContentPage(driver);
		loginpage.login();
		managecontentpage.checkListOutDropDown();
		managecontentpage.enterNewNews();
		
	}
}
 