package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HandleTextboxCheckboxRadiobuttonScroll {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion","13");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Driver...");
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Started Driver...");
		
		Thread.sleep(5000);
		
		// Scroll to Views element
		String MobileElementToScroll = "Views";

		// Scroll to the Views element
		WebElement viewsElement = driver.findElement(AppiumBy.androidUIAutomator(
		    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
		    ".scrollIntoView(new UiSelector().text(\"" + MobileElementToScroll + "\"))"));

		// Wait until the Views element is visible and clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement viewsButton = wait.until(ExpectedConditions.elementToBeClickable(viewsElement));

		// Click on the Views element after it is scrolled into view
		viewsButton.click();

		
		//click on Controls button
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		
		//click on Light Theme
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();
		
		//Enter text on textbox
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Sample Text");
		
		//Click on Checkbox 1
		driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
		
		//Click on Radio button 2
		driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();
		
		Thread.sleep(5000);
		
		driver.quit();

	}
	
	

}
