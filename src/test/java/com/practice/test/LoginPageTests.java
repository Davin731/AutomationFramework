package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.practice.driver.Driver;
import com.practice.driver.DriverManager;

public final class LoginPageTests extends BaseTest {

	private LoginPageTests() {

	}

	@Test
	public void test1() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation" + Keys.ENTER);
	}

	@Test
	public void test2() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation" + Keys.ENTER);
	}
}
