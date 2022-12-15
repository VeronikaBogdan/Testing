package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.LocatorUtil;

public class CartPage extends AbstractPage{
	private final Logger logger = LogManager.getRootLogger();
	protected static final String CART_PAGE_URL = "https://markformelle.by/personal/cart/";
	private static final String REMOVE_PRODUCT_LOCATOR_PATTERN = "//div[text()='%s']/../..//a[@data-entity='basket-item-delete']";
	private final By amountOfProducts = By.xpath("//span[@class='num']/span[text()='1']");
	private final By buttonClearCart = By.xpath("//div[contains(text(), 'Очистить')]");
	private final By emptyCartText = By.xpath("//div[@class='bx-sbb-empty-cart-text']");
	private final By titleOfProduct = By.xpath("//a[contains(@class, 'info-item product-title-desktop')]");
	private final By priceDeliveryFromWarehouse = By.xpath("//div[@class='pink-text']");
	private final By totalPrice = By.xpath("//div[@class='basket-total__price']");
	private final By priceDelivery = By.xpath("//li[@class='basket-total__info']/div[contains(text(), '4')]");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CartPage removeProduct(String price) {
		waitUntilElementToBeClickableAndClick(LocatorUtil.getLocatorByXpathPattern(REMOVE_PRODUCT_LOCATOR_PATTERN, price));
		logger.info("Product with price " + price + " is removed");
		return this;
	}

	public CartPage clearCart() {
		waitForPresenceOfElement(buttonClearCart).click();
		logger.info("Cart is cleared");
		return this;
	}

	public String getTotalPrice() {
		return waitForPresenceOfElement(totalPrice)
			.getText();
	}

	public String getPriceDeliveryFromWarehouse() {
		return waitForPresenceOfElement(priceDeliveryFromWarehouse)
			.getText();
	}

	public String getPriceDelivery() {
		return waitForPresenceOfElement(priceDelivery)
			.getText();
	}

	public String getTitleOfProduct() {
		return waitForPresenceOfElement(titleOfProduct)
			.getText();
	}

	public String getAmountOfProducts() {
		return waitForPresenceOfElement(amountOfProducts)
			.getText();
	}

	public String getEmptyCartText() {
		return waitForPresenceOfElement(emptyCartText)
			.getText();
	}

	@Override
	public CartPage openPage() {
		webDriver.get(CART_PAGE_URL);
		logger.info("Cart Page opened");
		return this;
	}
}
