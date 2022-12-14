package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage{
	private final Logger logger = LogManager.getRootLogger();
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/bryuki-leginsy/182436-73175-1050/";
	private final By buttonOpenListOfSizes = By.xpath("//div[@class='size-header closed']");
	private final By buttonSelectSize = By.xpath("//div[@class='w25per size' and text()='S']");
	private final By buttonAddToCart = By.xpath("//a[@href='javascript:void(0);']");
	private final By amountOfProducts = By.xpath("//span[@class='num' and text()='1']");
	private final By buttonGoToCart = By.xpath("//a[@data-addpickup='N' and @href='/personal/cart/']");
	private final By titleOfProduct = By.xpath("//h1");

	public ProductPage(WebDriver driver) {
		super(driver);
	}

//	public ProductPage openListOfSizes() {
//		waitUntilElementToBeClickableAndClick(buttonOpenListOfSizes);
//		return this;
//	}

	public ProductPage selectSize() {
//		waitForPresenceOfElement(buttonOpenListOfSizes).click();
		waitUntilElementToBeClickableAndClick(buttonOpenListOfSizes);
		waitUntilElementToBeClickableAndClick(buttonSelectSize);
		return this;
	}

	public ProductPage addToCart() {
		waitUntilElementToBeClickableAndClick(buttonAddToCart);
		return this;
	}

	public String getAmountOfProducts() {
		return waitForPresenceOfElement(amountOfProducts)
			.getText();
	}

	public String getButtonGoToCart() {
		return waitForPresenceOfElement(buttonGoToCart)
			.getText();
	}

	public String getTitleOfProduct() {
		return waitForPresenceOfElement(titleOfProduct)
			.getText();
	}

	@Override
	public ProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		logger.info("Product Page opened");
		return this;
	}
}
