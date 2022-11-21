package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MarkFormelleCartPage;
import page.MarkFormelleDressProductPage;
import page.MarkFormelleProductPage;
import page.MarkFormelleSweaterProductPage;

public class MarkFormelleRemoveFromCartTest {
	private static final String EXPECTED_AMOUNT_OF_PRODUCTS = "1";
	private WebDriver webDriver;

	@BeforeMethod
	public void setUpBrowser() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
	}

	@Test
	public void testRemoveProductRemoveCart() {
		new MarkFormelleProductPage(webDriver)
						.openPage()
						.openListOfSizes()
						.selectSize()
						.addToCart();
		new MarkFormelleDressProductPage(webDriver)
						.openPage()
						.openListOfSizes()
						.selectSize()
						.addToCart();
		new MarkFormelleSweaterProductPage(webDriver)
						.openPage()
						.openListOfSizes()
						.selectSize()
						.addToCart();
		WebElement amountOfProducts = new MarkFormelleCartPage(webDriver)
						.openPage()
						.removeTrousers()
						.removeSweater()
						.getAmountOfProducts();

		Assert.assertEquals(amountOfProducts.getText(), EXPECTED_AMOUNT_OF_PRODUCTS);
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
		webDriver = null;
	}
}
