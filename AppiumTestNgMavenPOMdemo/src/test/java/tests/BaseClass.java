package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends ExtentReportsDemo{

	public static AndroidDriver driver;
	  
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();


		capabilities.setCapability("deviceName","realme RMX3851");
		capabilities.setCapability("udid", "b4e03da8");
		capabilities.setCapability("platformname", "Android");     
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("platformversion", "14");

		/*The number of seconds the Appium server should wait for clients 
		 * to send commands before deciding 
		 * that the client has gone away and the session 
		 * should shut down*/

		capabilities.setCapability("appium:newCommandTimeout", 60);

		//capabilities.setCapability("app", "completePathOfApkFile");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\SaikiranKeerthi\\eclipse-workspace\\AppiumTestNgMavenPOMdemo\\drivers\\chromedriver.exe");


		//	capabilities.setCapability("appPackage","com.oneplus.calculator");
		//	capabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");



		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		driver = new AndroidDriver(url, capabilities);
		
		
	}
	
	

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}