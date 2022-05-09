package com.simplilearn.webapptest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertionDemo {

	// Hard assert : Hard Assert throws an AssertException immediately when an
	// assert statement fails and test suite continues with next @Test method
	@Test(description="Hard Assert method Test")
	public void hardAssertionTest() {
		System.out.println("--- Hard assert method is started ---");
		// assertEquals(true, false);
		assertEquals(true, true);
		System.out.println("--- Hard assert method is completed ---");
	}
	
	// Soft assert :- Soft Assert collects errors during @Test.
	// Soft Assert does not throw an exception when an assert fails
	@Test(description="Soft Assert method Test")
	public void softAssertTest() {
		SoftAssert softAssert  = new SoftAssert();
		System.out.println("--- Soft assert method is started ---");
		softAssert.assertEquals("Hello", "Hi");
		softAssert.assertEquals(true, false);
		softAssert.assertTrue(true);
		System.out.println("--- Soft assert method is completed ---");
	}
}
