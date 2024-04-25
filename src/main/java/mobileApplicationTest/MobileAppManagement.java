package mobileApplicationTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MobileAppManagement {
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "13"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Vivo T2x");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("app", "C:\\Users\\Dheerendra\\Desktop\\Appium APK file\\pixellab-2-1-3.apk");

		// Adjust the URL according to the Appium server's host and port
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
		String packageName = driver.getCurrentPackage();
		System.out.println("appPackage name is:" + packageName);
		System.out.println("appA name is:" + packageName);
		
		
		

		// To Remove(Un-install) the apk file if already installed on the device. here pixellab-2-1-3.apk.

		//		if (driver.isAppInstalled(packageName)) {
//			driver.removeApp(packageName);
//		}
		
		
		
		

		// To check the app is installed or not, if not then install
//		if (!driver.isAppInstalled(packageName)) {
//			driver.installApp(packageName);
//			System.out.println("App installed successfully");
//
//		} else
//			System.out.println("Not installed");

		// To terminate the open app
		driver.terminateApp(packageName);

	}

}
