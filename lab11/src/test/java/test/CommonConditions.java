package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

	protected WebDriver webDriver;
//	protected static final String USER_NAME = "test-automation-user";
//	protected static final String USER_PASSWORD = "Time4Death!";

	@BeforeMethod()
	public void setUp()
	{
		webDriver = DriverSingleton.getWebDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void stopBrowser()
	{
		DriverSingleton.closeDriver();
	}
}