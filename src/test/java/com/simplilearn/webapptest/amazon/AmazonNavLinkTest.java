package com.simplilearn.webapptest.amazon;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonNavLinkTest {

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
		public void testBestSellerNavLink() {
			// locate mobile nav link on webpage
			WebElement bestLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
			bestLink.click();
			String expected = "Amazon.in Bestsellers: The most popular items on Amazon";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		}
		
		@Test
		public void testBestSellerNavLink2() {
			// locate todays deals nav link on webpage
			WebElement todayLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));
			todayLink.click();
			String expected = "Help - Amazon Customer Service";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		}

		@Test
		public void testTodaysDealNavLink3() {
			// locate todays deals nav link on webpage
			WebElement custLink = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]"));
			custLink.click();
			String expected = "Amazon.in - Today's Deals";
			String actual = driver.getTitle();
			assertEquals(expected, actual);
		}


}
