package com.sevenmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "manageOfferCodeprovider")
	public Object[][] formpage1() {
		return new Object[][] { { "discout offer", "15%", "56", "Xmass offer" } };
	}

	@DataProvider(name = "provider")
	public Object[][] formpage()// data provider method name
	{
		return new Object[][] { { "Tvm", "1000" } };
	}

	@DataProvider(name = "LoginData")
	public Object[][] userLogin() {
		return new Object[][] { { "hema", "hema", "Hema" }, { "suresh", "suresh", "Suresh" },
				{ "gopi", "gopi", "Gopi" } };
	}

	@DataProvider(name = "LoginData2")
	public Object[][] userLogin2() {
		excelreader.setExcelFile("PushNotification", "LoginData");
		Object data[][] = excelreader.getMultidimentionalData(3, 3);//here3,3 means matrix size
		return data;
	}
} 