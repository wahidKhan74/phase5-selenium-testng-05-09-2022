package com.simplilearn.webapptest.group;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserBasedGroupTest {

	String amazonUrl = "https://www.amazon.in/";
	String facebookUrl = "https://www.facebook.com/";

	String chromePath = "drivers/linux/chromedriver";
	String firefoxPath = "drivers/linux/geckodriver";

	WebDriver driverOne;
	WebDriver driverTwo;

	// step 1: test group chrome only
	@Test(groups = "ChromeOnly")
	public void launchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driverOne = new ChromeDriver();
		driverOne.get(amazonUrl);
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "launchChromeTest", priority = 1)
	public void testAmazonHomePageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driverOne.getTitle();
		assertEquals(expected, actual);
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "launchChromeTest", priority = 2)
	void testAmazonHomeSourceUrl() {
		assertEquals(amazonUrl, driverOne.getCurrentUrl());
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "launchChromeTest", priority = 3)
	void testAmazonSearchProductTest() {
		// search text
		WebElement searchBox = driverOne.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();

		// 5. perform test
		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driverOne.getTitle();
		assertEquals(expected, actual);
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "launchChromeTest", priority = 4)
	public void afterMethod() {
		driverOne.close();
	}

	// step 2: test group firefox
	@Test(groups = "FirefoxOnly")
	public void launchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driverTwo = new FirefoxDriver();
		driverTwo.get(facebookUrl);
	}
	

	@Test(groups = "FirefoxOnly", dependsOnMethods="launchFireFoxTest", priority=1)
	public void testFaceBookHomePage() {
		String expected = "Facebook - log in or sign up";
		assertEquals(driverTwo.getTitle(), expected);
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods="launchFireFoxTest", priority=2)
	public void testFieldsLogin() {
		 WebElement email = driverTwo.findElement(By.id("email"));
		 WebElement password  = driverTwo.findElement(By.id("pass"));
		 WebElement submit = driverTwo.findElement(By.name("login"));
		 
		 assertEquals(true, email.isDisplayed());
		 assertEquals(true, password.isDisplayed());
		 assertEquals(true, submit.isDisplayed());
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods="launchFireFoxTest", priority=3)
	public void testFailureLogin() {
		 WebElement email = driverTwo.findElement(By.id("email"));
		 WebElement password  = driverTwo.findElement(By.id("pass"));
		 WebElement login = driverTwo.findElement(By.name("login"));
		 
		 email.sendKeys("abc@gmail.com");
		 password.sendKeys("abc@gmail.com");
		 login.submit();
	}
	
	@Test(dependsOnGroups="FirefoxOnly")
	public void closeFireFox() {
		driverTwo.close();
	}
	
}
