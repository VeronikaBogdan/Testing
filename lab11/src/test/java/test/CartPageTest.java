package test;

import org.testng.annotations.Test;
import page.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartPageTest extends CommonConditions {
	private static final String DRESS_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/platya-tuniki-yubki/platya-tuniki-dlinnyy-rukav/152532-75491-1050/";
	private static final String SWEATER_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/koftochki-longslivy/dzhempery-kombidresy/122722-74708-1050/";
	private static final String TROUSERS_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/bryuki-leginsy/182436-73175-1050/";

	private static final String AMOUNT_OF_PRODUCTS = "1";
	private static final String GO_TO_CART = "Перейти в корзину";
	private static final String EMPTY_CART_TEXT = "Ваша корзина пуста";
	private static final String PRICE_TROUSERS = "44.99 BYN";
	private static final String PRICE_SWEATER = "34.79 BYN";

	@Test
	public void testAddProductToCart() {
		ProductPage addingProductToCart = addProductToCart(new ProductPage(webDriver), TROUSERS_PAGE_URL);
		String titleOfProduct = addingProductToCart.getTitleOfProduct();
		String amountOfProducts = addingProductToCart.getAmountOfProducts();
		String buttonGoToCart = addingProductToCart.getButtonGoToCart();

		String amountOfProductsInCart = new CartPage(webDriver)
			.openPage()
			.getAmountOfProducts();
		String titleOfProductInCart = new CartPage(webDriver)
			.openPage()
			.getTitleOfProduct();

		assertThat(buttonGoToCart, is(equalTo(GO_TO_CART)));
		assertThat(amountOfProducts, is(equalTo(amountOfProductsInCart)));
		assertThat(titleOfProduct, is(equalTo(titleOfProductInCart)));
	}

	@Test
	public void testTotalSumIsCalculatedCorrectly() {
		addProductToCart(new ProductPage(webDriver), SWEATER_PAGE_URL);
		CartPage cartPage = new CartPage(webDriver)
			.openPage();

		double priceDeliveryFromWarehouse = Double.parseDouble(cartPage.getPriceDeliveryFromWarehouse().substring(0,5));
		double priceDelivery = Double.parseDouble(cartPage.getPriceDelivery().substring(0,1));
		double totalPrice = Double.parseDouble(cartPage.getTotalPrice().substring(0,5));

		assertThat(Math.round(priceDeliveryFromWarehouse + priceDelivery), is(equalTo(Math.round(totalPrice))));
	}

	@Test
	public void testClearCart() {
		addProductToCart(new ProductPage(webDriver), TROUSERS_PAGE_URL);
		String emptyCartText = new CartPage(webDriver)
			.openPage()
			.clearCart()
			.getEmptyCartText();
		assertThat(emptyCartText, is(equalTo(EMPTY_CART_TEXT)));
	}

	@Test
	public void testRemoveProductsFromCart() {
		addProductToCart(new ProductPage(webDriver),TROUSERS_PAGE_URL);
		addProductToCart(new ProductPage(webDriver), SWEATER_PAGE_URL);
		addProductToCart(new ProductPage(webDriver), DRESS_PAGE_URL);
		String amountOfProducts = new CartPage(webDriver)
			.openPage()
			.removeProduct(PRICE_TROUSERS)
			.removeProduct(PRICE_SWEATER)
			.getAmountOfProducts();
		assertThat(amountOfProducts,is(equalTo(AMOUNT_OF_PRODUCTS)));
	}

	public ProductPage addProductToCart(ProductPage productPage, String url) {
		return productPage
			.openPage(url)
			.selectSize()
			.addToCart();
	}
}
