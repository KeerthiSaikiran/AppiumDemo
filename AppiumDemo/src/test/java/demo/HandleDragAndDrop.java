package demo;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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
		
//		// Drag and Drop using Touch Class - Not working
//		TouchAction action = new TouchAction(driver);
//		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
	
		// find the center of the source and destination web elment
		
		Point sourceElementCenter = getCenter(source);
		
		Point destinationElementCenter = getCenter(destination);
		
		//PointerInput class to create a sequence of actions 
		//that move the pointer to the center of the element, 
		//press down on the element, and then release the element.
		
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		
		//Sequence object, which is a list of actions that will be performed on the device
		
		Sequence sequence = new Sequence(finger1, 1)
				
				// move finger to the starting position
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
				
				// finger coming down to contact with the screen
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT .asArg()))
				
				.addAction(new Pause(finger1, Duration.ofMillis(588)))
				
				//move finger to the end position
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), destinationElementCenter))
				
				// move the finger up
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
				//perform sequence of actions
				//driver.perform(Collections.singletonList(sequence));
		
				driver.perform(Arrays.asList(sequence));
				Thread.sleep(5000);
				
				
				// close session
				driver.quit();
	}
	
	private static Point getCenter(WebElement element) {
		
		//get location of the element
		Point location = element.getLocation();
		
		//get position of the element
		Dimension size = element.getSize();
		
		//center point
		Point center = new Point(location.x + size.width/2, location.y + size.height/2);
		
		return center;
	}		
}
