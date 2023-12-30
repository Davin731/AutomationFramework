package com.practice.pages;

import org.openqa.selenium.By;

import com.practice.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {
	
	private final By welcomeLink = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome()
	{
		click(welcomeLink, WaitStrategy.CLICKABLE);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout()
	{
		click(linkLogout, WaitStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}

}
