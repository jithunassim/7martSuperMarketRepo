package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.utilities.DataProviderUtility;


public class ManageDeliveryBoyTest extends Base 
{
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
@Test
	public void verifyClickOn_ManageDeliveryBoy()
	{
	loginpage=new LoginPage(driver);
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage.login();
	boolean isEnabled=managedeliveryboypage.clickOnManaage_DeliveryBoy();
	Assert.assertTrue(isEnabled);
	System.out.println("TestCase Passed");
	}
@Test
public void verifyAddNew_deliveryBoy()
{
loginpage=new LoginPage(driver);
managedeliveryboypage=new ManageDeliveryBoyPage(driver);
loginpage.login();
managedeliveryboypage.clickOnManaage_DeliveryBoy();
managedeliveryboypage.check_AddNewDeliveryBoy();
managedeliveryboypage.checkSave_DeliveryBoy();
boolean actualResult=managedeliveryboypage.checkPushNotificationMeessage("Delivery Boy Details Created Successfully");
Assert.assertTrue(actualResult);
}

@Test
public void verifySearch_ByName()
{
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	managedeliveryboypage.clickonSearchDeliveryBoy();
	String actualResult=managedeliveryboypage.enterSearchName("Jithu");
	String expectedResult="jithu";
	Assert.assertEquals(actualResult, expectedResult);
}
@Test
public void verifySearch_ByEmail()
{
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	managedeliveryboypage.checkSearchBy_Email("	b@gmail.com");
}
@Test
public void verify_Delete_Delivery_Boy()
{
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	managedeliveryboypage.delete_Delivery_Boy("jithu");
	
}
@Test
public void verifyToEdit_deliveryBoy()
{
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	managedeliveryboypage.editUser("Anju");
}
}
