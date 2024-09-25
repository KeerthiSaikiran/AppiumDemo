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

public class HandleScrollSwitch {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("ignoreHiddenPolicyError", true);
		capabilities.setCapability("noReset", false);
		
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Driver...");
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Starter Driver...");
		
		// Scroll to view element - views
		String MobileElementToScrollViews = "Views";
		
		WebElement viewsElement = driver.findElement(AppiumBy.androidUIAutomator(
		    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
		    ".scrollIntoView(new UiSelector().text(\"" + MobileElementToScrollViews + "\"))"));

		// Wait until the Views element is visible and clickable
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement viewsButton = wait1.until(ExpectedConditions.elementToBeClickable(viewsElement));

		// Click on the Views element after it is scrolled into view
		viewsButton.click();
		
		
		
		// Scroll to element - Switches
		
		String MobileElementToScrollSwitches = "Switches";
		
		WebElement switchesElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" + 
				".scrollIntoView(new UiSelector().text(\"" + MobileElementToScrollSwitches + "\"))"));
		
		//wait untill the Switches element is Visible and clickable
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement switchesButton = wait2.until(ExpectedConditions.elementToBeClickable(switchesElement));
		
		// Click on the Switches element after it is scrolled into view
		switchesButton.click();
		
		
		//find and click on the Switch element Monitored Switch
		WebElement switchElement = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
		
		
		//check if Monitored Switch element is selected or not. If not selected then click
		if(switchElement.isSelected()) {
			System.out.println("Already selected");
		}
		else {
			System.out.println("Monitored Switch is not selected. Selecting Monitored Switch");
			switchElement.click();
		}
		
		// close app
//		driver.closeApp();
		
		// quit driver
		driver.quit();
		
		
	}

}
