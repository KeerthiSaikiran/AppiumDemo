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

public class HandleDropDown {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("paltformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("ignoreHiddenPolicyError", true);
		
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Driver...");
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Started Driver...");
		
		
		// Scroll to Views button and click
		
		String MobileElementToScrollViews = "Views";
		
		WebElement viewsElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" + 
				".scrollIntoView(new UiSelector().text(\"" + MobileElementToScrollViews + "\"))"));
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement viewsButton = wait1.until(ExpectedConditions.elementToBeClickable(viewsElement));
		
		viewsButton.click();
		
		
		// Click on Controls Button
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		
		// Click on Light Theme
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();
		
		// Click on Mercury Button (DropDown)
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"io.appium.android.apis:id/spinner1\"]")).click();
		
		// Click on Jupiter Button
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Jupiter\"]")).click();
		
		
		Thread.sleep(5000);
		
		// Close Session
		driver.quit();
		

	}

}
