package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandleLongPress {
	
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("ignoreHiddenPolicyError", true);
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Driver...");
		
		driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Started Driver...");
		
		String packageName = "com.google.android.dialer";
		
		// Open Call Dailer App
		System.out.println("Opening Call Dailer App...");
		driver.activateApp(packageName);
		
		Thread.sleep(5000);
		// Open Call Dialer
		System.out.println("Opening Call Dailer...");
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"key pad\"]")).click();
		
		// Click on Digit 8
		System.out.println("Clicking on Digit 8...");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"8,TUV\"]")).click();
		
		//Click on Digit 9
		System.out.println("Clicking on Digit 9...");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"9,WXYZ\"]")).click();
		
		// Click on Digit 5
		System.out.println("Clicking on Digit 5...");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"5,JKL\"]")).click();
		
		//Click on Digit 1
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"1,\"]")).click();
		
		//Click on Digit 0
		System.out.println("Clicking on Digit 0...");
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"0\"]")).click();
		
		//find the delete element
		System.out.println("Finding Delete Element...");
		WebElement clearElement = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"backspace\"]"));
		
		
		//normal click
		System.out.println("Clicking normal click on the clear button...");
		clearElement.click();
		
		System.out.println("Longpressing on clear element...");
		LongePressAction(clearElement);
		
		System.out.println("Closing the App...");
		driver.terminateApp(packageName);
		
		System.out.println("Closing the session...");
		driver.quit();
		
	}
	
	static void LongePressAction(WebElement el) {
		
		//longpress click
		Point location = el.getLocation();
		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		
		Sequence longpress = new Sequence(finger, 1);
		
		longpress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.x, location.y));
		
		longpress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		longpress.addAction(finger.createPointerMove(Duration.ofMillis(3000), PointerInput.Origin.viewport(), location.x, location.y));
		
		longpress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(longpress));

	}

}
