package test;

import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class AddProductToCartTest extends CommonConditions {
	private static final String AMOUNT_OF_PRODUCTS = "1";
	private static final String GO_TO_CART = "Перейти в корзину";
	private static final String TITLE_OF_PRODUCT = "Зауженные к низу брюки в черно-белую клетку виши";

	@Test
	public void testAddProductToCart() {
		ProductPage addingProductToCart = new ProductPage(webDriver)
			.openPage()
			.openListOfSizes()
			.selectSize()
			.addToCart();
		assertThat(addingProductToCart.getTitleOfProduct(), is(TITLE_OF_PRODUCT));
		assertThat(addingProductToCart.getButtonGoToCart(), is(GO_TO_CART));
		assertThat(addingProductToCart.getAmountOfProducts(), is(AMOUNT_OF_PRODUCTS));

		String amountOfProductsInCart = new CartPage(webDriver)
			.openPage()
			.getAmountOfProducts();
		assertThat(amountOfProductsInCart, is(AMOUNT_OF_PRODUCTS));
	}
}
