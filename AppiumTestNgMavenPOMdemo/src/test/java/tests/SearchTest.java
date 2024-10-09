package tests;

import java.net.URI;
import java.net.URL;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.GoogleSearchPage;

public class SearchTest extends BaseClass {
	
	@Test
	public void test1() throws InterruptedException {
		
		ExtentTest test1 = extent.createTest("Test1", "This is Demo Test case 1");
		
		test1.log(Status.INFO, "Test 1 has started");
		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		
		String testUrl = "https://www.google.com/";
		
		driver.get(testUrl);
		test1.log(Status.PASS, "Url is opened.");
		
		googleSearchPage.EnterSearchData("Taj Mahal");
		test1.log(Status.PASS, "Search Data is entered");
		
		Thread.sleep(2000);
		
		googleSearchPage.PressEnterKeyOnSearchBox();
		test1.log(Status.PASS, "Enter Key in Search box is clicked.");
		
	    Thread.sleep(5000);
		
	}
	
	@Test
	public void test2() throws InterruptedException{
		
		ExtentTest test2 = extent.createTest("Test 1", "This is Demo Test Case 2");
		
		test2.log(Status.INFO, "Test 2 has started.");
		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		
		String testUrl = "https://www.google.com/";
		
		driver.get(testUrl);
		test2.log(Status.PASS, "Url is opened.");
		
		googleSearchPage.EnterSearchData("Kutub Minar");
		test2.log(Status.PASS, "Search Data is entered.");
		
		Thread.sleep(2000);
		
		googleSearchPage.PressEnterKeyOnSearchBox();
		test2.log(Status.PASS, "Enter Key in Search box is clicked.");
		
		Thread.sleep(5000);
		
	}
}
