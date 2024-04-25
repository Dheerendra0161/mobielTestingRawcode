package capabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Capabilities {

	private AndroidDriver driver;

	// Constructor to initialize the AndroidDriver instance
	public void desiredCapabilities() throws MalformedURLException {
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
	}

}
