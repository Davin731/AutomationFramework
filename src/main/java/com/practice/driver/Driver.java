package com.practice.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.constants.FrameworkConstants;
import com.practice.enums.ConfigProperties;
import com.practice.utils.JsonUtils;
import com.practice.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(){

		if (Objects.isNull(DriverManager.getDriver())) {

			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());

			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
