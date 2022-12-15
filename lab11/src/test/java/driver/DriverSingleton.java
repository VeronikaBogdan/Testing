package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
	private static WebDriver webDriver;

	private DriverSingleton(){}

	public static WebDriver getWebDriver(){
		if (null == webDriver){
			switch (System.getProperty("browser")){
				case "chrome": {
					WebDriverManager.chromedriver().setup();
					webDriver = new ChromeDriver();
				}
			}
			webDriver.manage().window().maximize();
		}
		return webDriver;
	}

	public static void closeDriver(){
		webDriver.quit();
		webDriver = null;
	}
}
