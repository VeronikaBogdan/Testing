package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.LocatorUtil;

public class CartPage extends AbstractPage{
	private static final String CART_PAGE_URL = "https://markformelle.by/personal/cart/";
	private static final String REMOVE_PRODUCT_LOCATOR_PATTERN = "//div[text()='%s']/../..//a[@data-entity='basket-item-delete']";
	private final By amountOfProducts = By.xpath("//span[@class='num']/span[text()='1']");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public CartPage removeProduct(String price) {
		waitUntilElementToBeClickableAndClick(LocatorUtil.getLocatorByXpathPattern(REMOVE_PRODUCT_LOCATOR_PATTERN, price));
		return this;
	}

	public String getAmountOfProducts() {
		return waitForPresenceOfElement(amountOfProducts).getText();
	}

	@Override
	public CartPage openPage() {
		webDriver.get(CART_PAGE_URL);
		return this;
	}
}
