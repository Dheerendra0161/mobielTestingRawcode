package utilities;

import java.util.List;
import java.util.Random;

public class RandomValue {
	public static String getRandomString(List<String> checkboxValues) {
		Random random = new Random();
		int randomIndex = random.nextInt(checkboxValues.size());
		return checkboxValues.get(randomIndex);
	}
}
