package mobileApplicationTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import utilities.GetCenterPoint;

public class ScrollingActions {

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

		driver.findElement(By.id("com.imaginstudio.imagetools.pixellab:id/quick_edit_action")).click();
		driver.findElement(By.id("com.imaginstudio.imagetools.pixellab:id/option_ui_icon")).click();
		WebElement textbox = driver.findElement(By.id("com.imaginstudio.imagetools.pixellab:id/text_editor_dialog"));
		textbox.clear();
		textbox.sendKeys("QA Engineer");

//		WebElement element = driver.findElement(By.id("//android.widget.ImageButton[@resource-id=\"com.imaginstudio.imagetools.pixellab:id/quick_edit_action\"]"));
//		element.click();
//		// Get the center point of the element
//		GetCenterPoint cnt = new GetCenterPoint();
//		Point cntofPoint = cnt.getCenterPoint(element);
//
//		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//		Sequence sequence = new Sequence(finger1, 1)
//				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), cntofPoint))
//				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//				.addAction(new Pause(finger1, Duration.ofMillis(200)));
////				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//		driver.perform(Collections.singletonList(sequence));
	}

}
