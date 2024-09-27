package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "realme RMX3851");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14");
		
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("ignoreHiddenPoliyErro", true);
		
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\SaikiranKeerthi\\git\\repository\\AppiumDemo\\chromedriver\\chromedriver.exe");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Driver...");
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Started Driver...");
		
		
		// go to google website
		System.out.println("open google website...");
		driver.get("https://www.google.com");
		
		Thread.sleep(5000);
		
		//find search bar
		System.out.println("finding the search bar element...");
		WebElement searchBox = driver.findElement(By.name("q"));
		
		//enter taj mahal in the search bar
		System.out.println("Entering taj mahal in search box...");
		searchBox.sendKeys("taj mahal");
		
		//click on enter or search button to send
		System.out.println("Clicking on Search...");
		searchBox.sendKeys(Keys.ENTER);
//		searchBox.sendKeys(Keys.RETURN);
		
		System.out.println("Search done...");
		
		
		Thread.sleep(5000);
		
		// Close Session
		System.out.println("Closing the Session...");
		driver.quit();
	}

}
