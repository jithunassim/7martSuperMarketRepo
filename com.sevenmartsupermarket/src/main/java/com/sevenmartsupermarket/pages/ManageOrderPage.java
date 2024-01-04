package com.sevenmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageOrderPage 
{
WebDriver driver;
GeneralUtility generalutility;
PageUtility pageutility;

public ManageOrderPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this); 
}

@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order'])[1]")
WebElement manageOrderElement;
@FindBy(xpath = "//table//tbody//tr//td[1]")
List <WebElement>tableIdElement;
//@FindBy(xpath = "(//select[@class='form-control'])[1]")
//WebElement alertElement;
//@FindBy(xpath = "(//button[@name='Update_st'])[1]")
//WebElement updateElement;

public void checkClickOn_ManageOrder()
{
	manageOrderElement.click();	
}
public void checkChangeStatus(String orderId)
{
	//int index=0;
	List<String> names=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	names=generalutility.gettextOfElements(tableIdElement);
	System.out.println(names);
	int index;
	  for(index=0;index<names.size();index++) 
	  {
	  if(orderId.equals(names.get(index))) 
	  {
		  index++; 
		  break; 
		  } 
	  }
	  WebElement status=driver.findElement(By.xpath("//table//tbody//tr["+index+"]//td[6]//a[contains(text(),'Change Status')]"));
	status.click();
	WebElement getDropDown=driver.findElement(By.xpath("(//select[@id='status'])["+index+"]"));
	getDropDown.click();
	Select select=new Select(getDropDown);
	select.selectByIndex(3);
	WebElement updateElement=driver.findElement(By.xpath("(//form//button[@name='Update_st'])["+(index+2)+"]"));
	updateElement.click();
	
	//getDropDown.sendKeys("Paid");
	
	//    (//select[@id='status'])[3]
	
	//alertElement.sendKeys("Paid");
	
}

}
