package com.sevenmartsupermarket.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageOfferCodePage 
{
WebDriver driver;
PageUtility pageutility;
GeneralUtility generalutility;

public ManageOfferCodePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(xpath = "(//a[@class='small-box-footer']//i[@class='fas fa-arrow-circle-right'])[6]")
WebElement moreInfoElement;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
WebElement newElement;
@FindBy(xpath = "//input[@id='offer_code']")
WebElement enterOffercodeElement;
@FindBy(xpath = "//input[@id='offer_per']")
WebElement enterPercentageElement;
@FindBy(xpath = "//input[@id='offer_price']")
WebElement enteramountElement;
@FindBy(xpath = "//div[@class='note-editable card-block']")
WebElement enterdescriptionElement;
@FindBy(xpath = "//input[@id='main_img']")
WebElement chooseFileElement;
@FindBy(xpath = "//button[@type='submit']")
WebElement saveElement;
@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
WebElement alertElement;



public boolean clickOnManageOfferCode()
{
	moreInfoElement.click();
	//newElement.click();
	return moreInfoElement.isEnabled();
	
}
public void addNewOfferCode(String offerCode,String percentage,String amount,String description)
{
	moreInfoElement.click();
	newElement.click();
	enterOffercodeElement.sendKeys(offerCode);
	enterPercentageElement.sendKeys(percentage);
	enteramountElement.sendKeys(amount);
	enterdescriptionElement.sendKeys(description);
}
public void imageUpload() throws InterruptedException
{
	pageutility=new PageUtility(driver);
	File file=new File(Constants.IMAGE_FILE_PATH);
	chooseFileElement.sendKeys(file.getAbsolutePath());
	pageutility.scrollAndClick(saveElement);
	//Thread.sleep(3000);
	//saveElement.click();
}
public boolean checkNotificationMeessage(String message)
{
 	generalutility=new GeneralUtility(driver);
 	return generalutility.isWordPresent(alertElement, message);
}
}
