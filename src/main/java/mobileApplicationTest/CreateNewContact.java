package mobileApplicationTest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CreateNewContact {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "13"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Vivo T2x");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.dialer");
		desiredCapabilities.setCapability("appActivity",
				"com.google.android.dialer.extensions.GoogleDialtactsActivity");
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

		String contentDesc = "key pad";
		String xpath = String.format("//android.widget.ImageButton[@content-desc=\"%s\"]", contentDesc);
		driver.findElement(By.xpath(xpath)).click();

		int[] array = { 8, 7, 5, 0, 1, 7, 0, 7, 6, 3 };
		for (int i = 0; i < array.length; i++) {
			int digit = array[i];
			String numbersXpath = "//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='"
					+ digit + "']";
			driver.findElement(By.xpath(numbersXpath)).click();
		}

		// Click on Create New Contacts
		driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id=\'com.google.android.dialer:id/search_action_text\' and @text=\'Create new contact\']"))
				.click();

		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.xpath("//android.widget.EditText[@text=\'First name\']"));
		firstName.sendKeys("Dheerendra");

		Thread.sleep(2000);
		WebElement lastName = driver.findElement(By.xpath("//android.widget.EditText[@text=\'Last name\']"));
		lastName.sendKeys("Vishwakarma");
		Thread.sleep(2000);

		WebElement dropDownMenu = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Show dropdown menu']"));
		dropDownMenu.click();

	
		
		Thread.sleep(2000);
		
		// Find the coordinate from the Appium Inspector Tap/Swipe by Coordinate option
		int x = 155;
        int y = 220;

        // Create TouchAction instance
        TouchAction touchAction = new TouchAction(driver);

        // Move finger to the element
        touchAction.tap(PointOption.point(x, y)).perform();
        
		Thread.sleep(5000);
		WebElement saveButton = driver.findElement(
				By.xpath("//android.widget.Button[@resource-id=\'com.google.android.contacts:id/save_button\']"));
		saveButton.click();
		
		
	
		
		
		
		//android.widget.FrameLayout[@content-desc="Contacts"]
		
		
		

	}
}