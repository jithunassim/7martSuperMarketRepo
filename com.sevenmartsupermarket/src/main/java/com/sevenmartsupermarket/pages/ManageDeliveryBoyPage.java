package com.sevenmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage
{
WebDriver driver;
GeneralUtility generalutility;
PageUtility pageutility;
public ManageDeliveryBoyPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']//p")
WebElement manageDeliveyBoyElement;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
WebElement addnewElement;
@FindBy(xpath = "//form[@id='form']//div//label") 
List<WebElement> formElements;
@FindBy(xpath = "//input[@id='name']")
WebElement nameElement;
@FindBy(xpath = "//input[@id='email']")
WebElement emailElement;
@FindBy(xpath = "//input[@id='phone']")
WebElement phoneNumberElement;
@FindBy(xpath = "//textarea[@id='address']")
WebElement adressElement;
@FindBy(xpath = "//input[@id='username']")
WebElement userNameElement;
@FindBy(xpath = "//input[@id='password']")
WebElement passwordElement;

@FindBy(xpath = "//button[@type='submit']")
WebElement saveElement;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
WebElement searchElement;
//@FindBy(xpath="//table//tbody//tr//td[1]")
//List<WebElement> tableNameElement;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
List<WebElement> tableNameElement;
@FindBy(xpath="//input[@id='un']")
WebElement namesearchElement;
@FindBy(xpath="//button[@type='submit']")
WebElement searchButtonElement;
@FindBy(xpath="//input[@id='ut']")
WebElement searchEmailElement;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible'] ")
WebElement alertElement;
@FindBy(xpath = "(//table//tbody//tr//td[1])[1] ")
WebElement searchByNameElement;

public boolean clickOnManaage_DeliveryBoy()
{
	manageDeliveyBoyElement.click();
	return manageDeliveyBoyElement.isEnabled();
}
public void check_AddNewDeliveryBoy()
{
	addnewElement.click();
	List<String> names=new ArrayList<String>();
	GeneralUtility generalutility;
	generalutility=new GeneralUtility(driver);
	names=generalutility.gettextOfElements(formElements);
	System.out.println(names);
	checkEnter_Data();
}
public void checkEnter_Data()
{
	nameElement.sendKeys("jithu");
	emailElement.sendKeys("b@gmail.com");
	phoneNumberElement.sendKeys("c");
	adressElement.sendKeys("d");
	userNameElement.sendKeys("pinky");
	passwordElement.sendKeys("selenium");
}
public void checkSave_DeliveryBoy()
{
	saveElement.click();
}
public void clickonSearchDeliveryBoy()
{
	searchElement.click();
	
}
public String enterSearchName(String searchName)
{
	namesearchElement.sendKeys(searchName);
	searchButtonElement.click();
	return searchByNameElement.getText();
}
public void checkSearchBy_Email(String searchEmail)
{
	clickonSearchDeliveryBoy();
	searchEmailElement.sendKeys(searchEmail);
}
public void delete_Delivery_Boy(String nameOfDeliveryBoy)
{
	//int index=0;
	List<String> names=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	pageutility=new PageUtility(driver);
	names=generalutility.gettextOfElements(tableNameElement);
	System.out.println(names);
	int index;
	  for(index=0;index<names.size();index++) 
	  {
	  if(nameOfDeliveryBoy.equals(names.get(index))) 
	  {
		  index++; 
		  break; 
		  } 
	  }
	  WebElement delete=driver.findElement(By.xpath("//table//tbody//tr["+index+"]//td[8]//a[@class='btn btn-sm btn btn-danger btncss']"));
	  //WebElement delete=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr["+index+"]//td[8]"));
	  delete.click();
	
	  
	  //pageutility.scrollAndClick(delete);
	  //driver.switchTo().alert().accept();
	 
}
public void editUser(String editingPerson)
{
	List<String> names=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
pageutility=new PageUtility(driver);
	names=generalutility.gettextOfElements(tableNameElement);
	System.out.println(names);
	int index;
	  for(index=0;index<names.size();index++) 
	  {
	  if(editingPerson.equals(names.get(index))) 
	  {
		  index++; 
		  break; 
		  } 
	  }
	WebElement editbutton=driver.findElement(By.xpath("//table//tbody//tr["+index+"]//td[8]//a[1]"));
	editbutton.click();
}
public boolean checkPushNotificationMeessage(String message)
{
 	generalutility=new GeneralUtility(driver);
 	return generalutility.isWordPresent(alertElement, message);
}
}