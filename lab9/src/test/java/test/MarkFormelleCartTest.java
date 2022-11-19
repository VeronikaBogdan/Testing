package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MarkFormelleCartTest {
	private static final String EXPECTED_MOVE_TO_CART = "Перейти в корзину";
	private static final String EXPECTED_AMOUNT_OF_GOODS = "1";
	private static final String EXPECTED_SIZE = "Выбран размер S";
	private static WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod
	public void setUpBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://markformelle.by/catalog/zhenshchinam/mf-life/bryuki-leginsy/182436-73175-1050/");
	}

	@Test
	public void testAddItemToCart() throws InterruptedException {
		WebElement buttonOpenListOfSizes = driver.findElement(By.xpath("//div[@class='size-arrow']"));
		Thread.sleep(2000);
		buttonOpenListOfSizes.click();

		WebElement buttonItemSize = driver.findElement(By.xpath("//div[@data-offer-id='484144']"));
		buttonItemSize.click();

		WebElement buttonAddToCart = driver.findElement(By.xpath("//a[@href='javascript:void(0);']"));
		buttonAddToCart.click();

		WebElement amountOfGoods = driver.findElement(By.xpath("//span[@class='num']"));
//		WebElement buttonMoveToCart = driver.findElement(By.xpath("//a[text()='Перейти в корзину']"));
//		Assert.assertEquals(buttonMoveToCart.getText(),EXPECTED_MOVE_TO_CART);
		Assert.assertEquals(amountOfGoods.getText(),EXPECTED_AMOUNT_OF_GOODS);
	}

	@Test
	public void testTitleNewsComparison() {
		new WebDriverWait(driver, Duration.ofSeconds(20))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='size-header closed']")));
		WebElement buttonOpenListOfSizes = driver.findElement(By.xpath("//div[@class='size-header closed']"));
		buttonOpenListOfSizes.click();

		WebElement buttonItemSize;
		buttonItemSize = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-offer-id='484144']")));
		buttonItemSize.click();

		WebElement buttonAddToCart = (new WebDriverWait(driver, Duration.ofSeconds(5)))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='javascript:void(0);']")));
		buttonAddToCart.click();

		WebElement amountOfGoods = driver.findElement(By.xpath("//span[@class='num']"));
		Assert.assertEquals(amountOfGoods.getText(),EXPECTED_AMOUNT_OF_GOODS);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
