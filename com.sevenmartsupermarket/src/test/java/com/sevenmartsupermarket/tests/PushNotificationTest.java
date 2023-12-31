package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationPage;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base
{
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	ExcelReader excelread=new ExcelReader();
	@Test
public void verifyExcelData()
{
		excelread.setExcelFile("PushNotification", "NotificationCredential");
		String data=excelread.getCellData(0, 0);
		System.out.println(data);
	
	
}
	@Test
	public void verifypushNotificationAlertMessage() throws InterruptedException
	{
		pushnotificationpage=new PushNotificationPage(driver);
		loginpage=new LoginPage(driver);
			excelread.setExcelFile("PushNotification", "NotificationCredential");
			String title=excelread.getCellData(1,0);
			String description=excelread.getCellData(1,1);
			
			loginpage.login();
			pushnotificationpage.clickOnPushNotification();
			//Thread.sleep(5000);
			pushnotificationpage.sendTitleAndDescription(title,description);
			System.out.println(title);
			System.out.println(description);
			boolean actualResult=pushnotificationpage.checkPushNotificationMeessage("Message send successfully");
			Assert.assertTrue(actualResult);
		
		
	}
}
