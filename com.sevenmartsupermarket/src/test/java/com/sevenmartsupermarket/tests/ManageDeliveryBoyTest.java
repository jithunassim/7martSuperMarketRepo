package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenmartsupermarket.utilities.DataProviderUtility;

//import testNgExamples.Dataprovider_assign_1_2;

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
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	}
@Test
public void verifyAddNew_deliveryBoy()
{
loginpage=new LoginPage(driver);
managedeliveryboypage=new ManageDeliveryBoyPage(driver);
loginpage.login();
managedeliveryboypage.clickOnManaage_DeliveryBoy();
managedeliveryboypage.check_AddNewDeliveryBoy();
//managedeliveryboypage.checkEnter_Data();
//managedeliveryboypage.checkSave_DeliveryBoy();
}
@Test
public void Verify_To_SaveDeliveryBoy()
{
	
	loginpage=new LoginPage(driver);
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage.login();
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	managedeliveryboypage.check_AddNewDeliveryBoy();
	managedeliveryboypage.checkSave_DeliveryBoy();
	}
@Test
public void verifySearch_ByName()
{
	managedeliveryboypage=new ManageDeliveryBoyPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	managedeliveryboypage.clickOnManaage_DeliveryBoy();
	managedeliveryboypage.clickonSearchDeliveryBoy();
	managedeliveryboypage.enterSearchName("Jithu");
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
	managedeliveryboypage.delete_Delivery_Boy("keerthi");
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
