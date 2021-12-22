package com.internetBanking.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeSnapshot {
	
	public static void TakeScreenshot(WebDriver driver, String tName) throws IOException {

		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tName + ".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");

	}
	
}
