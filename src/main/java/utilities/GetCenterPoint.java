package utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;

public class GetCenterPoint {
	static WebDriver driver;

	public static PointerInput getCenterPoint() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		// Do something with finger1 if needed
		return finger1;
	}
}
