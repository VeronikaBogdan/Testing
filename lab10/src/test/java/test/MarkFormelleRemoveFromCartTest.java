package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class MarkFormelleRemoveFromCartTest {
	private static final String AMOUNT_OF_PRODUCTS = "1";
	private WebDriver webDriver;

	@BeforeMethod
	public void setUpBrowser() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	  	addProductToCart(new MarkFormelleProductPage(webDriver));
	  	addProductToCart(new MarkFormelleSweaterProductPage(webDriver));
	  	addProductToCart(new MarkFormelleDressProductPage(webDriver));
	}

	@Test
	public void testRemoveProductFromCart() {
		WebElement amountOfProducts = new MarkFormelleCartPage(webDriver)
			.openPage()
			.removeTrousers()
			.removeSweater()
			.getAmountOfProducts();
	  	Assert.assertEquals(amountOfProducts.getText(), AMOUNT_OF_PRODUCTS);
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
		webDriver = null;
	}

	public void addProductToCart(MarkFormelleProductPage markFormelleProductPage) {
		markFormelleProductPage
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
	}
}
