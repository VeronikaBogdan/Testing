package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class MarkFormelleRemoveTwoProductsFromCartTest extends CommonConditions{
	private static final String AMOUNT_OF_PRODUCTS = "1";

	@Test(description = "test remove two certain products from cart")
	public void testRemoveProductFromCart() {
		addProductToCart(new MarkFormelleProductPage(webDriver));
		addProductToCart(new MarkFormelleSweaterProductPage(webDriver));
		addProductToCart(new MarkFormelleDressProductPage(webDriver));
		String amountOfProducts = new MarkFormelleCartPage(webDriver)
			.openPage()
			.removeTrousers()
			.removeSweater()
			.getAmountOfProducts();
	  	Assert.assertEquals(amountOfProducts, AMOUNT_OF_PRODUCTS);
	}

	public void addProductToCart(MarkFormelleProductPage markFormelleProductPage) {
		markFormelleProductPage
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
	}
}
