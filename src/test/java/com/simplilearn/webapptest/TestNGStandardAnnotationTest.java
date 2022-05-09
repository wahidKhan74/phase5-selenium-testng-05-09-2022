package com.simplilearn.webapptest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGStandardAnnotationTest {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("--- Before Test Suite  ---");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("--- After Test Suite ---");
	}
	
	@BeforeClass	
	public void beforeClass() {
		System.out.println("--- Before Class ---");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("--- After Class ---");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("--- Before Test Method ---");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("--- After Test Method ---");
	}
	
	@Test
	public void testOne() {
		System.out.println(" --- Test One is exicuted ---");
	}
	
	@Test
	public void testTwo() {
		System.out.println(" --- Test Two is exicuted ---");
	}
	
	@Test
	public void testThree() {
		System.out.println(" --- Test three is exicuted ---");
	}
}
