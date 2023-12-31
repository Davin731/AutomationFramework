package com.practice.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.practice.driver.DriverManager;

import io.qameta.allure.Attachment;

public class ListenerClass implements ITestListener{
	
	@Attachment(value= "Page Screenshot", type="image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = DriverManager.getDriver();
		
		if(driver instanceof WebDriver) {
			System.out.println("Screenshot Captured");
			saveScreenshotPNG(driver);
		}
		
	}
	
}
