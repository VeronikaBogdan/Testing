package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class RemoveProductsFromCartTest extends CommonConditions{
	private static final String AMOUNT_OF_PRODUCTS = "1";

	@Test(description = "test remove two certain products from cart")
	public void testRemoveProductFromCart() {
		addProductToCart(new ProductPage(webDriver));
		addProductToCart(new SweaterProductPage(webDriver));
		addProductToCart(new DressProductPage(webDriver));
		String amountOfProducts = new CartPage(webDriver)
			.openPage()
			.removeTrousers()
			.removeSweater()
			.getAmountOfProducts();
	  	Assert.assertEquals(amountOfProducts, AMOUNT_OF_PRODUCTS);
	}

	public void addProductToCart(ProductPage markFormelleProductPage) {
		markFormelleProductPage
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
	}
}
