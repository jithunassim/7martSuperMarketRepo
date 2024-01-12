package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class ManageLocationPage 
{
WebDriver driver;
GeneralUtility generalutility;
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
@FindBy(xpath = "//h1[contains(text(),'List Locations')]")
WebElement assertHeadingElement;
@FindBy(xpath = "//button[@type='submit']")
WebElement saveButtonElement;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'] ")
WebElement alertElement;

public String clikOnManageLocation()
{
	manageLocationElement.click();
	return assertHeadingElement.getText();
	
}
public void checkCreateNew_Location(String a,String b)
{
	manageLocationElement.click();
	newElement.click();
	locationElement.sendKeys(a);
	deliveryChargeElement.sendKeys(b);
	saveButtonElement.click();
}
public boolean checkAlertMeessage(String message)
{
 	generalutility=new GeneralUtility(driver);
 	return generalutility.isWordPresent(alertElement, message);
}
}
