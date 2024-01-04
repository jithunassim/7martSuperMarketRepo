package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageOrderPage;

public class ManageOrderTest extends Base
{
	ManageOrderPage manageorderpage;
	LoginPage loginpage;
	@Test
	public void verifyClickOn_manageOrder()
	{
		loginpage=new LoginPage(driver);
		manageorderpage=new ManageOrderPage(driver);
		
		loginpage.login();
		manageorderpage.checkClickOn_ManageOrder();
		
	}
	@Test
	public void verify_ChangeStatus()
	{
		loginpage=new LoginPage(driver);
		manageorderpage=new ManageOrderPage(driver);
		loginpage.login();
		manageorderpage.checkClickOn_ManageOrder();
		manageorderpage.checkChangeStatus("177");
	}
}
