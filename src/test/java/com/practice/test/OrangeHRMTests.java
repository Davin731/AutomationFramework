package com.practice.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.constants.FrameworkConstants;
import com.practice.driver.DriverManager;
import com.practice.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}

	@Test(dataProvider="loginTestDataProvider")
	public void LoginLogoutTest(String username, String password) {
		
		String title = new OrangeHRMLoginPage()
				.enterUsername("Admin1").enterPassword("admin123").submitButton()
				.clickWelcome().clickLogout()
				.getTitle();
		
		Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");

	}
	
	@DataProvider(name="loginTestDataProvider", parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"Admin", "admin123"}
//			{"Admin2", "admin456"},
//			{"Admin", "admin123"},
//			{"Admin2", "admin456"}
		};
	
	}
	
	@Test(description="Screenshot Testing", enabled = false)
	public void myTest() throws IOException, InterruptedException {	
		
		JavascriptExecutor jscriptExec = (JavascriptExecutor) DriverManager.getDriver();
		
		new OrangeHRMLoginPage().enterUsername("Admin").enterPassword("admin123");
		
		jscriptExec.executeScript("arguments[0].click();" , DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")));
		
		TakesScreenshot myShot = (TakesScreenshot) DriverManager.getDriver();
		
		Thread.sleep(5000);
		File source = myShot.getScreenshotAs(OutputType.FILE);
		File target = new File(FrameworkConstants.screenshotsPath() + "/myPhoto.png");
		FileUtils.copyFile(source, target);
	}
}
