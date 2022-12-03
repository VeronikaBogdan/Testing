package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarkFormelleCartPage extends AbstractPage{
	private static final String CART_PAGE_URL = "https://markformelle.by/personal/cart/";
	private static final String PRICE_TROUSERS = "54.79 BYN";
	private static final String PRICE_SWEATER = "34.79 BYN";
	private final WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_SECONDS);
	private final By amountOfProducts = By.xpath("//span[@class='num']/span[text()='1']");

	public MarkFormelleCartPage(WebDriver driver) {
		super(driver);
	}

	public MarkFormelleCartPage removeTrousers() {
		webDriverWait
			.until(ExpectedConditions.elementToBeClickable(By.xpath(getRemoveButton(PRICE_TROUSERS))))
			.click();
		return this;
	}

	public MarkFormelleCartPage removeSweater() {
		webDriverWait
			.until(ExpectedConditions.elementToBeClickable(By.xpath(getRemoveButton(PRICE_SWEATER))))
			.click();
		return this;
	}

	public String getAmountOfProducts() {
		return webDriverWait
			.until(ExpectedConditions.presenceOfElementLocated(amountOfProducts))
			.getText();
	}

	private String getRemoveButton(String price){
		return String.format("//div[text()='%s']/../..//a[@data-entity='basket-item-delete']",price);
	}

	@Override
	public MarkFormelleCartPage openPage() {
		webDriver.get(CART_PAGE_URL);
		return this;
	}
}
