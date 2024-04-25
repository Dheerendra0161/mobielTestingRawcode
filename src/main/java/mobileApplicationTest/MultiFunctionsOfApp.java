package mobileApplicationTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import capabilities.Capabilities;
import io.appium.java_client.android.AndroidDriver;

public class MultiFunctionsOfApp {
	static AndroidDriver driver;

	public static void dialNumber() throws MalformedURLException, InterruptedException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "13"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Vivo T2x");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("app",
				"C:\\Users\\Dheerendra\\Desktop\\Appium APK file\\appium-api-demos-3-3-1.apk");

		// Adjust the URL according to the Appium server's host and port
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

		// Initialize AndroidDriver instance
		driver = new AndroidDriver(url, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		//Note:(%d for integers, %f for floats, %s for strings, etc.) you can't use any other value like %k or %t
		
		String views = "Views";
		String viewsXpath = String.format("//android.widget.TextView[@content-desc=\"%s\"]", views);
		driver.findElement(By.xpath(viewsXpath)).click();

		Thread.sleep(3000);
		String controls = "Controls";
		String controlsXpath = String.format("//android.widget.TextView[@content-desc=\"%s\"]", controls);
		driver.findElement(By.xpath(controlsXpath)).click();

		String lightTheme = "1. Light Theme";
		String lightThemeXpath = String.format("//android.widget.TextView[@content-desc=\"%s\"]", lightTheme);
		driver.findElement(By.xpath(lightThemeXpath)).click();

//		String checkboxValue = "Checkbox 1";
//		String checkboxXpath = String.format("//android.widget.CheckBox[@content-desc=\"%s\"]", checkboxValue);
//		driver.findElement(By.xpath(checkboxXpath)).click();
//		
//		Thread.sleep(3000);
//		String radioButton = "RadioButton 1";
//		String radioButtonXpath = String.format("//android.widget.CheckBox[@content-desc=\"%s\"]", radioButton);
//		driver.findElement(By.xpath(radioButtonXpath)).click();
//
//		Thread.sleep(3000);
//		driver.findElement(By.id("io.appium.android.apis:id/toggle1")).click();

	}
}