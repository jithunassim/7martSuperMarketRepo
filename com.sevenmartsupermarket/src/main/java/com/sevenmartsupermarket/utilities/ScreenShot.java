package com.sevenmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.sevenmartsupermarket.constants.Constants;

public class ScreenShot {
	TakesScreenshot takescreenshot;// TakesScreenshot is an interphase used to capture screenshot

	public void takeScreenShot(WebDriver driver, String image_name) {
		try {
			takescreenshot = (TakesScreenshot) driver;
			File file = takescreenshot.getScreenshotAs(OutputType.FILE);// this line excuted for take
																		// screenshot(captured screenshot)
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// to get currrent date
																								// and time
			String path = Constants.SCREENSHOT_FILE_PATH + image_name + "_" + timeStamp + ".png";
			File destination = new File(path);// (to store screenshot)
			FileHandler.copy(file, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
