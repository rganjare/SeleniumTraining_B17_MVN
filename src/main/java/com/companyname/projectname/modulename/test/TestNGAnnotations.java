package com.companyname.projectname.modulename.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeClass // P1
	public void beforeClass() {
		System.out.println("I am Inside @BeforeClass method/function");	
	}
	
	@AfterClass // P5
	public void afterClass() {
		System.out.println("I am Inside @AfterClass method/function");	
	}
	
	@BeforeMethod //P2
	public void launchBrowser() {
		System.out.println("I am Inside launchBrowser @BeforeMethod");	
	}
	
	@Test // Test Case  // P3 
	public void testCase1() {
		System.out.println("I am learning TestNG");
		System.out.println("I am Inside testCase1");
		System.out.println("Business logic for testCase1");
		
	}
	
	@Test // Test Case // P3
	public void testCase2() {
		System.out.println("I am learning TestNG");
		System.out.println("I am Inside testCase2");
		System.out.println("Business logic for testCase2");
		
	}
	
	@AfterMethod // P4
	public void closeBrowser() {
		System.out.println("I am Inside closeBrowser @AfterMethod");
		System.out.println("################################");
	}
	
}
