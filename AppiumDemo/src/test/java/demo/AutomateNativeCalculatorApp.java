package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateNativeCalculatorApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "realme RMX3851");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "14");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("automationName", "uiautomator2");
		
		capabilities.setCapability("appPackage", "com.coloros.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Staring Driver...");
		Thread.sleep(5000);
		
		WebElement digit8 = driver.findElement(By.id("com.coloros.calculator:id/digit_8"));
		digit8.click();
		
		WebElement signplus = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		signplus.click();
		
		WebElement digit2 = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
		digit2.click();
		
		WebElement equalto = driver.findElement(By.id("com.coloros.calculator:id/eq"));
		equalto.click();
		
		WebElement result = driver.findElement(By.id("com.coloros.calculator:id/result"));
		String resulttext = result.getText();
		
		if(resulttext.equals("100")){
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
