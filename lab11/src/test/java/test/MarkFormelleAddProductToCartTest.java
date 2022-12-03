package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MarkFormelleProductPage;


public class MarkFormelleAddProductToCartTest extends CommonConditions {
	private static final String AMOUNT_OF_PRODUCTS = "1";
	private static final String GO_TO_CART = "Перейти в корзину";

	@Test
	public void testAddProductToCart() {
		MarkFormelleProductPage addingProductToCart = new MarkFormelleProductPage(webDriver)
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
		Assert.assertEquals(addingProductToCart.getAmountOfProducts(), AMOUNT_OF_PRODUCTS);
//		Assert.assertEquals(addingProductToCart.getButtonGoToCart(), GO_TO_CART);
	}
}
