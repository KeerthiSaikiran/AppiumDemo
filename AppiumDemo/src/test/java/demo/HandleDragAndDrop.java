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
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;

public class HandleDragAndDrop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appPackage", "io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("ignoreHandleApiPolicyError", true);
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Driver..");
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Started Driver..");
		
		// Scroll to Views button and click
		String MobileElementToScrollViews = "Views";
		
		WebElement viewsElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" + 
				".scrollIntoView(new UiSelector().text(\"" + MobileElementToScrollViews + "\"))"));
		
		//wait untill element is visible and then click
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement viewsButton = wait1.until(ExpectedConditions.elementToBeClickable(viewsElement));
		
		viewsButton.click();
		
		
		// Click on DragandDrop button
		WebElement dragAndDropBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Drag and Drop\']"));
		dragAndDropBtn.click();
		
		// Drag Dot 1
		WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id=\'io.appium.android.apis:id/drag_dot_1\']"));
		
		//Drag Dot 2
		WebElement destination = driver.findElement(By.xpath("//android.view.View[@resource-id=\'io.appium.android.apis:id/drag_dot_2\']"));
		
		// Drag and Drop using Touch Class - Not working
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		
		// close app
		driver.close();
		
		//quit driver
		driver.quit();
		
		
		
	}

}
