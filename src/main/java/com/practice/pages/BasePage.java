package com.practice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.constants.FrameworkConstants;
import com.practice.driver.DriverManager;
import com.practice.enums.WaitStrategy;
import com.practice.factories.ExplicitWaitFactory;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();

	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
