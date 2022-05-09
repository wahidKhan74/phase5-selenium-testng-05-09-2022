package com.simplilearn.webapptest.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonHomepageTest {

	// step1: formulate a test url & driver path
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void testAmazonHomePageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void testAmazonHomeSourceUrl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}

	@Test
	void testAmazonSearchProductTest() {
		// search text
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();

		// 5. perform test
		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void testAmazonSearchProductTest2() {
		// search text
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Apple mac book");
		searchBox.submit();

		// 5. perform test
		String expected = "Amazon.in : Apple mac book";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
}
