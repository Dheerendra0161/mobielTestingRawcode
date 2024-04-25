package mobileApplicationTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import capabilities.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import utilities.LongPress;

public class DiallerNativeAppActivity {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "13"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Vivo T2x");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");

		// TO get the appPackage and appActivity run certain command
		// adb devices , adb shell and dumpsys window displays | grep -E 'mCurrentFocus'
		desiredCapabilities.setCapability("appPackage", "com.google.android.dialer");
		desiredCapabilities.setCapability("appActivity",
				"com.google.android.dialer.extensions.GoogleDialtactsActivity");
		// String packageName = driver.getCurrentPackage();

		// Adjust the URL according to the Appium server's host and port
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

		// android.widget.ImageButton[@content-desc="key pad"] and also can use single
		// quote // android.widget.ImageButton[@content-desc='key pad']

		String contentDesc = "key pad";
		String xpath = String.format("//android.widget.ImageButton[@content-desc=\"%s\"]", contentDesc);
		driver.findElement(By.xpath(xpath)).click();

		// By using the single quotes in xPath

		int[] array = { 8, 7, 5, 0, 1, 7, 0, 7, 6, 3 };
		for (int i = 0; i < array.length; i++) {
			int digit = array[i];
			String numbersXpath = "//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='"
					+ digit + "']";
			driver.findElement(By.xpath(numbersXpath)).click();
		}

//		String numbersXpath="//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='"+digit+"']";
//		driver.findElement(By.xpath(numbersXpath)).click();
		// String.format() is used to construct the XPath dynamically by replacing %s
		// with the value of textValue.

		WebElement ele = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'backspace\']"));
		LongPress.longpress(driver, ele);
	}

}
