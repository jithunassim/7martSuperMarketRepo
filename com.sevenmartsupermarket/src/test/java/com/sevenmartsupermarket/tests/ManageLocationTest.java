package com.sevenmartsupermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageLocationPage;
import com.sevenmartsupermarket.utilities.DataProviderUtility;

//import testNgExamples.Dataprovider_assign_1_2;

public class ManageLocationTest extends Base
{
	
	ManageLocationPage managelocationpage;
	LoginPage loginpage;
	@Test
	public void verifyClick_On_ManageLocation()
	{
		loginpage=new LoginPage(driver);
		managelocationpage=new ManageLocationPage(driver);
		loginpage.login();
		managelocationpage.clikOnManageLocation();
	}
	@Test(dataProvider="provider",dataProviderClass =DataProviderUtility.class)
	public void verifyCreate_NewLocation(String a,String b)
	{
		loginpage=new LoginPage(driver);
		managelocationpage=new ManageLocationPage(driver);
		loginpage.login();
		managelocationpage.checkCreateNew_Location(a,b);
		
	}
}
