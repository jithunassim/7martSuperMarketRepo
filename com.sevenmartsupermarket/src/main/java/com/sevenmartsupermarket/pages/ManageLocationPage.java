package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageLocationPage 
{
WebDriver driver;
public ManageLocationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
WebElement manageLocationElement;
@FindBy(xpath = "(//div[@class='col-sm-12'])[1]//a[1]")
WebElement newElement;
@FindBy(xpath = "//input[@id='location']")
WebElement locationElement;
@FindBy(xpath = "//input[@id='delivery']")
WebElement deliveryChargeElement;



//form[@id='form']//div//input[@class='form-control']
public void clikOnManageLocation()
{
	manageLocationElement.click();
	
}
public void checkCreateNew_Location(String a,String b)
{
	clikOnManageLocation();
	newElement.click();
	locationElement.sendKeys(a);
	deliveryChargeElement.sendKeys(b);
}
}
