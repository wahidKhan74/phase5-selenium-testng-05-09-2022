package com.simplilearn.webapptest.facebook;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class FacebookLoginTest {

	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	// explicit wait
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception"
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get(siteUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void testFieldsLogin() {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		assertEquals(true, email.isDisplayed());
		assertEquals(true, password.isDisplayed());
		assertEquals(true, submit.isDisplayed());
	}
	
	@Test
	public void testFailureLogin() {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		
		email.sendKeys("abc@gmail.com");
		password.sendKeys("abc@123");
		submit.submit();
		
		// Conditional timeouts
		// WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", error.getText());
		
		// WebElement error2 = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		WebElement error2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div:nth-child(2)")));
		assertEquals("Invalid username or password", error2.getText());
	
	}
}
