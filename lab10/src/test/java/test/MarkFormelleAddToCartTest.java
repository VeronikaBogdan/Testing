package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MarkFormelleProductPage;


public class MarkFormelleAddToCartTest {
	private static final String AMOUNT_OF_PRODUCTS = "1";
	private static final String GO_TO_CART = "Перейти в корзину";
	private WebDriver webDriver;

	@BeforeMethod
	public void setUpBrowser() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}

	@Test
	public void testAddProductToCart() {
		Assert.assertEquals(addProductToCart().getAmountOfProducts().getText(), AMOUNT_OF_PRODUCTS);
	}

	@Test
	public void testChangeOfTheButtonGoToCart() {
		Assert.assertEquals(addProductToCart().getButtonGoToCart().getText(), GO_TO_CART);
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
		webDriver = null;
	}

	public MarkFormelleProductPage addProductToCart() {
		return new MarkFormelleProductPage(webDriver)
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
	}
}
