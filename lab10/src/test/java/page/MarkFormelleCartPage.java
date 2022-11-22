package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarkFormelleCartPage extends AbstractPage{
	private static final String CART_PAGE_URL = "https://markformelle.by/personal/cart/";
	private final WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_SECONDS);

	@FindBy(xpath = "//div[text()='54.79 BYN']/../..//a[@data-entity='basket-item-delete']")
	private WebElement buttonRemoveTrousers;

	@FindBy(xpath = "//div[text()='34.79 BYN']/../..//a[@data-entity='basket-item-delete']")
	private WebElement buttonRemoveSweater;

	@FindBy(xpath = "//span[@class='num']/span[text()='1']")
	private WebElement amountOfProducts;

	public MarkFormelleCartPage(WebDriver driver) {
		super(driver);
	}

	public MarkFormelleCartPage removeTrousers() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonRemoveTrousers));
		buttonRemoveTrousers.click();
		return this;
	}

	public MarkFormelleCartPage removeSweater() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonRemoveSweater));
		buttonRemoveSweater.click();
		return this;
	}

	public WebElement getAmountOfProducts() {
		webDriverWait.until(ExpectedConditions.visibilityOf(amountOfProducts));
		return amountOfProducts;
	}

	@Override
	public MarkFormelleCartPage openPage() {
		webDriver.get(CART_PAGE_URL);
		return this;
	}
}
