package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalutility;

	@FindBy(xpath = "//a[@class='d-block']")
	WebElement profile_Name;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		generalutility = new GeneralUtility(driver);
		String profileName = generalutility.get_Textof_element(profile_Name);
		System.out.println(profileName);
		return profileName;
		
	}
}
