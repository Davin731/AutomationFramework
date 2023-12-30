package com.practice.pages;

import org.openqa.selenium.By;

import com.practice.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {

	private final By textboxUsername = By.xpath("//input[@name='username']");
	private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
	private final By btnLogin = By.xpath("//button[@type='submit']");

	public OrangeHRMLoginPage enterUsername(String username)
	{
		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password)
	{
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMHomePage submitButton()
	{
		click(btnLogin, WaitStrategy.CLICKABLE);
		return new OrangeHRMHomePage();
	}
	
	public String getTitle()
	{
		return getPageTitle();
	}
}
