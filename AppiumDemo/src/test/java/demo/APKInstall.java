package demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class APKInstall {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("deviceName", "AndroidEmulator");
        capabilities.setCapability("deviceName", "realme RMX3851");
        capabilities.setCapability("platformName", "Android"); // Correct casing of 'platformName'
        capabilities.setCapability("automationName", "uiautomator2"); // Corrected the typo
        capabilities.setCapability("app", "C:\\Software\\Calculator_8.6.1 (625857114)_APKPure.apk");
//        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("adbExecTimeout", 60000); // Optional timeout for adb exec

        // Use HTTP instead of HTTPS unless your Appium server is configured for HTTPS
        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        Thread.sleep(5000);
        
        System.out.println("Starting...");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        Thread.sleep(30000);
        driver.quit();
    }
}
