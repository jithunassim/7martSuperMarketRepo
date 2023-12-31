package com.sevenmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility
{
	
	  @DataProvider(name="manageOfferCodeprovider") 
	  public Object[][] formpage1()
	 {
		  return new Object [][]
	  {{"discout offer","15%","56","Xmass offer"}}; 
	  }
	 
	@DataProvider(name="provider")
	public Object[][] formpage()//data provider method name
	{
		return new Object [][] 
				{
			{"Tvm","1000"}
			};
	}
}
