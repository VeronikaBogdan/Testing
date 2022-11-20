package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class MarkFormelleAddingToCartTest {
	private static final String EXPECTED_MOVE_TO_CART = "Перейти в корзину";
	private static final String EXPECTED_AMOUNT_OF_GOODS = "1";
	private static WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod
	public void setUpBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://markformelle.by/catalog/zhenshchinam/mf-life/bryuki-leginsy/182436-73175-1050/");
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
