package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarkFormelleProductPage extends AbstractPage{
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/bryuki-leginsy/182436-73175-1050/";
	private final WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_SECONDS);

	@FindBy(xpath = "//div[@class='size-header closed']")
	private WebElement buttonOpenListOfSizes;

	@FindBy(xpath = "//div[@class='w25per size' and text()='S']")
	private WebElement buttonSelectSize;

	@FindBy(xpath = "//a[@href='javascript:void(0);']")
	private WebElement buttonAddToCart;

	@FindBy(xpath = "//span[@class='num' and text()='1']")
	private WebElement amountOfProducts;

	@FindBy(xpath = "//a[@data-addpickup='N' and @href='/personal/cart/']")
	private WebElement buttonGoToCart;

	public MarkFormelleProductPage(WebDriver driver) {
		super(driver);
	}

	public MarkFormelleProductPage openListOfSizes() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonOpenListOfSizes));
		buttonOpenListOfSizes.click();
		return this;
	}

	public MarkFormelleProductPage selectSize() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSelectSize));
		buttonSelectSize.click();
		return this;
	}

	public MarkFormelleProductPage addToCart() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonAddToCart));
		buttonAddToCart.click();
		return this;
	}

	public WebElement getAmountOfProducts() {
		webDriverWait.until(ExpectedConditions.visibilityOf(amountOfProducts));
		return amountOfProducts;
	}

	public WebElement getButtonGoToCart() {
		webDriverWait.until(ExpectedConditions.visibilityOf(buttonGoToCart));
		return buttonGoToCart;
	}

	@Override
	public MarkFormelleProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		return this;
	}
}
