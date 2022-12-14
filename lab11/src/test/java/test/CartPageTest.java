package test;

import org.testng.annotations.Test;
import page.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartPageTest extends CommonConditions {
	private static final String AMOUNT_OF_PRODUCTS = "1";
	private static final String GO_TO_CART = "Перейти в корзину";
	private static final String TITLE_OF_PRODUCT = "Зауженные к низу брюки в черно-белую клетку виши";
	private static final String EMPTY_CART_TEXT = "Ваша корзина пуста";
	private static final String PRICE_TROUSERS = "54.79 BYN";
	private static final String PRICE_SWEATER = "34.79 BYN";

//	@Test
//	public void testAddProductToCart() {
//		ProductPage addingProductToCart = addProductToCart(new ProductPage(webDriver));
//		assertThat(addingProductToCart.getTitleOfProduct(), is(equalTo(TITLE_OF_PRODUCT)));
////		assertThat(addingProductToCart.getButtonGoToCart(), is(equalTo(GO_TO_CART)));
//		assertThat(addingProductToCart.getAmountOfProducts(), is(equalTo(AMOUNT_OF_PRODUCTS)));
//
//		String amountOfProductsInCart = new CartPage(webDriver)
//			.openPage()
//			.getAmountOfProducts();
//		assertThat(amountOfProductsInCart, is(equalTo(AMOUNT_OF_PRODUCTS)));
//	}
//
//	@Test
//	public void testClearCart() {
//		addProductToCart(new ProductPage(webDriver));
//		String emptyCartText = new CartPage(webDriver)
//			.openPage()
//			.clearCart()
//			.getEmptyCartText();
////		new CartPage(webDriver)
////			.openPage()
////			.clearCart();
////		String emptyCartText = new EmptyCartPage(webDriver).openPage().getEmptyCartText();
//		assertThat(emptyCartText, is(equalTo(EMPTY_CART_TEXT)));
//	}
//
//	@Test(description = "test remove two certain products from cart")
//	public void testRemoveProductsFromCart() {
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
//	public ProductPage addProductToCart(ProductPage productPage) {
//		return productPage
//			.openPage()
//			.selectSize()
//			.addToCart();
//	}
}
