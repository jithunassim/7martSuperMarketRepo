package com.sevenmartsupermarket.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageOfferCodePage 
{
//private static final String File = null;
WebDriver driver;
PageUtility pageutility;
//Properties properties=new Properties();//properties is a java class to use to read properties file
//FileInputStream ip;



public ManageOfferCodePage(WebDriver driver) {
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

public void clickOnManageOfferCode()
{
	moreInfoElement.click();
	newElement.click();
}
public void addNewOfferCode(String offerCode,String percentage,String amount,String description)
{
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
}
