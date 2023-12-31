package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage 
{
WebDriver driver;
GeneralUtility generalutility;
Properties properties=new Properties();
FileInputStream ip;

@FindBy(xpath = "//input[@id='title']")
WebElement tileField;
@FindBy(xpath = "//input[@id='description']")
WebElement descriptionField;
@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
WebElement sendButton;
@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
WebElement resetButton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'] ")
WebElement alertElement;
@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications'])[1] ")
WebElement pushNotificationElement;

public PushNotificationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void enterTitle(String title)
{
	tileField.sendKeys(title);
}
public void enterDescription(String description)
{
	descriptionField.sendKeys(description);
}
public void clickSend()
{
	sendButton.click();
}
public void sendTitleAndDescription(String title,String description)
{
	enterTitle(title);
	enterDescription(description);
	clickSend();
}


public void clickReset()
{
	resetButton.click();
}
public boolean checkPushNotificationMeessage(String message)
{
 	generalutility=new GeneralUtility(driver);
 	return generalutility.isWordPresent(alertElement, message);
}
public void clickOnPushNotification()
{
	pushNotificationElement.click();
}
}
