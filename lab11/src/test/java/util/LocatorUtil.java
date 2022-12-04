package util;

import org.openqa.selenium.By;

public class LocatorUtil {
	private LocatorUtil() {}

	public static By getLocatorByXpathPattern(String pattern, Object...values) {
		String resultLocator = String.format(pattern, values);
		return By.xpath(resultLocator);
	}
}
