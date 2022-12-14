package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.LocatorUtil;

public class CartPage extends AbstractPage{
	protected static final String CART_PAGE_URL = "https://markformelle.by/personal/cart/";
	private static final String REMOVE_PRODUCT_LOCATOR_PATTERN = "//div[text()='%s']/../..//a[@data-entity='basket-item-delete']";
	private final By amountOfProducts = By.xpath("//span[@class='num']/span[text()='1']");
	private final By buttonClearCart = By.xpath("//div[contains(text(), 'Очистить')]");
//	private final By emptyCartText = By.xpath("//div[@class='bx-sbb-empty-cart-text']");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CartPage removeProduct(String price) {
		waitUntilElementToBeClickableAndClick(LocatorUtil.getLocatorByXpathPattern(REMOVE_PRODUCT_LOCATOR_PATTERN, price));
		return this;
	}

	public CartPage clearCart() {
		waitForPresenceOfElement(buttonClearCart).click();
//		waitUntilElementToBeClickableAndClick(buttonClearCart);
		return this;
	}

	public String getAmountOfProducts() {
		return waitForPresenceOfElement(amountOfProducts)
			.getText();
	}

	public String getEmptyCartText() {
		return waitForPresenceOfElement(By.xpath("//div[@class='bx-sbb-empty-cart-text']"))
			.getText();
	}

	@Override
	public CartPage openPage() {
		webDriver.get(CART_PAGE_URL);
		return this;
	}
}
