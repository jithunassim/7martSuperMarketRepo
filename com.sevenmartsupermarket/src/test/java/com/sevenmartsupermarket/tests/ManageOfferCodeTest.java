package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageOfferCodePage;
import com.sevenmartsupermarket.utilities.DataProviderUtility;

public class ManageOfferCodeTest extends Base
{
	ManageOfferCodePage manageoffercodepage;
	LoginPage loginpage;

@Test
public void verify_clickOnManageOfferCode()
{
	manageoffercodepage=new ManageOfferCodePage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageoffercodepage.clickOnManageOfferCode();
	
}
@Test(dataProvider="manageOfferCodeprovider",dataProviderClass =DataProviderUtility.class)
public void verifyAdd_NewOfferCode(String a,String b,String c,String d) throws InterruptedException
{
	manageoffercodepage=new ManageOfferCodePage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageoffercodepage.clickOnManageOfferCode();
	manageoffercodepage.addNewOfferCode(a,b,c,d);
	manageoffercodepage.imageUpload();
	
}
}