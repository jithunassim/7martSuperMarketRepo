package com.sevenmartsupermarket.base;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.model.ITest;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.ScreenShot;
import com.sevenmartsupermarket.utilities.UtilityWait;

//import freemarker.template.utility.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();// properties is a java class to use to read properties file
	FileInputStream ip;
ScreenShot screenshot=new ScreenShot();
	// FileInputStream ip;
	// initializing config file
	public Base() {
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);

			properties.load(ip);// read cheyan load cheythu kodukkum
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initialisation browser **/
	public void initialise(String browser, String url) {

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		driver.navigate().to(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityWait.IMPLICIT_WAIT));

	}

	@BeforeMethod
	public void launch_Browser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");// to read url from config file
		initialise(browser, url);
	}
	@AfterMethod
	public void terminatesession(ITestResult itestresult)
	{
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			screenshot.takeScreenShot(driver,itestresult.getName());
		}
	}
}
