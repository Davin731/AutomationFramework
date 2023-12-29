package com.practice.test;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.practice.driver.DriverManager;

public final class HomepageTests extends BaseTest {

	private HomepageTests() {

	}
	/*
	 * 1. Validate that title contains "Google Search" 2. Validate that the title is
	 * not null and length of title is greater than 15 3. Check for links in page
	 * --> Testing mini bytes 4. Number of links displayed is exactly 10 or 15
	 */

	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("DraftKings - Youtube" + Keys.ENTER);

		String title = DriverManager.getDriver().getTitle();
		
		Assertions.assertThat(title)
			.as("Title is actually Null.").isNotNull()
			.as("Title does not contain expected text.").containsIgnoringCase("google search")
			.matches("\\w.*" + "Google Search")
			.hasSizeBetween(15, 100);
		
		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
		
		Assertions.assertThat(elements)
			.hasSize(16)
			.extracting(e -> e.getText())
			.contains("DraftKings");
		
		
	}
}
