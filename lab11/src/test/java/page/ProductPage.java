package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage{
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/bryuki-leginsy/182436-73175-1050/";
	private final WebDriverWait webDriverWait = new WebDriverWait(webDriver, WAIT_SECONDS);
	private final By buttonOpenListOfSizes = By.xpath("//div[@class='size-header closed']");
	private final By buttonSelectSize = By.xpath("//div[@class='w25per size' and text()='S']");
	private final By buttonAddToCart = By.xpath("//a[@href='javascript:void(0);']");
	private final By amountOfProducts = By.xpath("//span[@class='num' and text()='1']");
	private final By buttonGoToCart = By.xpath("//a[@data-addpickup='N' and @href='/personal/cart/']");
	private final By titleOfProduct = By.xpath("//h1");

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public ProductPage openListOfSizes() {
		webDriverWait
			.until(ExpectedConditions.presenceOfElementLocated(buttonOpenListOfSizes));
		webDriverWait
			.until(ExpectedConditions.elementToBeClickable(buttonOpenListOfSizes))
			.click();
		return this;
	}

	public ProductPage selectSize() {
		webDriverWait
			.until(ExpectedConditions.elementToBeClickable(buttonSelectSize))
			.click();
		return this;
	}

	public ProductPage addToCart() {
		webDriverWait
			.until(ExpectedConditions.elementToBeClickable(buttonAddToCart))
			.click();
		return this;
	}

	public String getAmountOfProducts() {
		return webDriverWait
			.until(ExpectedConditions.presenceOfElementLocated(amountOfProducts))
			.getText();
	}

	public String getButtonGoToCart() {
		return webDriverWait
			.until(ExpectedConditions.presenceOfElementLocated(buttonGoToCart))
			.getText();
	}

	public String getTitleOfProduct() {
		return webDriverWait
			.until(ExpectedConditions.presenceOfElementLocated(titleOfProduct))
			.getText();
	}

	@Override
	public ProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		return this;
	}
}
