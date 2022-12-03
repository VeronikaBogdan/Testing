package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MarkFormelleProductPage;


public class MarkFormelleAddProductToCartTest {
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
		MarkFormelleProductPage addingProductToCart = new MarkFormelleProductPage(webDriver)
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
		Assert.assertEquals(addingProductToCart.getAmountOfProducts(), AMOUNT_OF_PRODUCTS);
		Assert.assertEquals(addingProductToCart.getButtonGoToCart(), GO_TO_CART);
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}
