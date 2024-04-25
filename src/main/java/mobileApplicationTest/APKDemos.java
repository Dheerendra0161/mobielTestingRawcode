package mobileApplicationTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import utilities.GetCenterPoint;

public class APKDemos {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "13"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Vivo T2x");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("app",
				"C:\\Users\\Dheerendra\\Desktop\\Appium APK file\\appium-api-demos-3-3-1.apk");

		// Adjust the URL according to the Appium server's host and port
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
		
		
		List<WebElement> list = driver.findElements(By.id("android:id/text1"));
		list.get(11).click();
		
		
		

		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1);

		// Move finger1 to the start position
		sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		// Press down finger1
		sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(new Pause(finger1, Duration.ofMillis(200)));

		// Move finger1 a little upwards to simulate scrolling
		sequence.addAction(
				finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY));
		// Release finger1
		sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		// Perform the sequence
		driver.perform(Collections.singleton(sequence));

		// Use finger1 and sequence as needed
	}
}
