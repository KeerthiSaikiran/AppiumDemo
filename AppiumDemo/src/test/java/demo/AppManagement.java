package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppManagement {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("adbExecTimeout", 60000);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("ignoreHiddenPolicyErrors", true);
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL();
		
		Thread.sleep(5000);
		
		System.out.println("Starting Android Driver...");
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		
		System.out.println("Android Driver started successfully..");
		
		Thread.sleep(2000);
		
		String packageName = "com.google.android.calculator";
		
		// install app if not installed
		if(driver.isAppInstalled(packageName)) {
			System.out.println("App installed already...");
		}
		
		else {
			System.out.println("Installing APK file...");
			//To Install app - provide the apk file location
			driver.installApp("C:\\Software\\apk\\Calculator_8.6.1 (625857114)_APKPure.apk");
			
			System.out.println("APK file installed (App installed Successfully)..");
		}
		
		Thread.sleep(5000);
		
		// Activate the app (open the app)
		driver.activateApp(packageName);
		System.out.println("Opening the App...");
		
		Thread.sleep(5000);
		
		//Termiante the app (close the app if it already opened.
		//This also removes app from background)
		driver.terminateApp(packageName);
		System.out.println("Closed the App...");
		
		
		Thread.sleep(2000);
		
		
		//Remove App (This will uninstall the App)
		driver.removeApp(packageName);
		System.out.println("Uninstalled the App...");
		
		Thread.sleep(5000);
		
		// Close the session
		driver.quit();
		
	}

}
