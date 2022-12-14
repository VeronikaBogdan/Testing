package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class RemoveProductsFromCartTest extends CommonConditions{
	private static final String AMOUNT_OF_PRODUCTS = "1";
	private static final String PRICE_TROUSERS = "54.79 BYN";
	private static final String PRICE_SWEATER = "34.79 BYN";

//	@Test(description = "test remove two certain products from cart")
//	public void testRemoveProductFromCart() {
//		addProductToCart(new ProductPage(webDriver));
//		addProductToCart(new SweaterProductPage(webDriver));
//		addProductToCart(new DressProductPage(webDriver));
//		String amountOfProducts = new CartPage(webDriver)
//			.openPage()
//			.removeProduct(PRICE_TROUSERS)
//			.removeProduct(PRICE_SWEATER)
//			.getAmountOfProducts();
//		assertThat(amountOfProducts,is(equalTo(AMOUNT_OF_PRODUCTS)));
//	}
//
//	public void addProductToCart(ProductPage markFormelleProductPage) {
//		markFormelleProductPage
//			.openPage()
//			.openListOfSizes()
//			.selectSize()
//			.addToCart();
//	}
}
