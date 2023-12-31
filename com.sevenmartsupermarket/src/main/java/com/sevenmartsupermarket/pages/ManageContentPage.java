package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;

//import utilities.UtilityClass;

public class ManageContentPage
{
WebDriver driver;
Properties properties=new Properties();
FileInputStream ip;

@FindBy(xpath = "//li[@class='nav-item has-treeview']//p[contains(text(),'Manage Content')]")
WebElement manageContentClick;

@FindBy(xpath = "(//li[@class='nav-item has-treeview menu-open'])[1]//ul") 
List<WebElement> manageContentdropDown;
@FindBy(xpath = "//a[@class='nav-link']//p[contains(text(),'Manage News')]")
WebElement manageNewsElement;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
WebElement NewElement;
@FindBy(xpath = "//textarea[@id='news']")
WebElement enterNews;

public ManageContentPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
try 
{
	ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
	
	
	properties.load(ip);//read cheyan load cheythu kodukkum
} catch (Exception e)
{
	e.printStackTrace();
}
}

public void checkListOutDropDown()
{
	manageContentClick.click();
	List<String> names=new ArrayList<String>();
	GeneralUtility generalutility;
	generalutility=new GeneralUtility(driver);
	names=generalutility.gettextOfElements(manageContentdropDown);
	System.out.println(names);
	
}


public void clickOnManageNews(String newNews)
{
	manageNewsElement.click();
	NewElement.click();
	enterNews.sendKeys(newNews);
	
}
public void enterNewNews()
{
	String news=properties.getProperty("news");
	clickOnManageNews(news);
}
}
