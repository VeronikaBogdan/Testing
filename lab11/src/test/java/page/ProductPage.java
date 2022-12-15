package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.LocatorUtil;

public class ProductPage extends AbstractPage{
	private final Logger logger = LogManager.getRootLogger();
	private final By buttonOpenListOfSizes = By.xpath("//div[@class='size-header closed']");
	private final By buttonSelectSize = By.xpath("//div[@class='w25per size' and text()='S']");
	private final By buttonAddToCart = By.xpath("//a[@href='javascript:void(0);']");
	private final By amountOfProducts = By.xpath("//span[@class='num' and text()='1']");
	private final By buttonGoToCart = By.xpath("//a[@data-addpickup='N' and @href='/personal/cart/']");
	private final By titleOfProduct = By.xpath("//h1");
	private final By buttonProfile = By.xpath("//a[contains(@class, 'header-profile')]");
	private final By inputLogin = By.xpath("//input[@name='USER_LOGIN']");
	private final By inputPassword = By.xpath("//input[@type='password']");
	private final By buttonSubmit = By.xpath("//input[@name='Login']");
	private static final String INPUT_EMAIL_LOCATOR_PATTERN = "//div[contains(@class,'desktop')]//input[@type='%s']";
	private static final String EMAIL_MESSAGE_LOCATOR_PATTERN = "//div[contains(@class,'desktop')]//div[@class='%s']";

	@Override
	protected AbstractPage openPage() {
		return null;
	}

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public ProductPage login(User user) {
		waitUntilElementToBeClickableAndClick(buttonProfile);
		waitForPresenceOfElement(inputLogin).sendKeys(user.getEmail());
		waitForPresenceOfElement(inputPassword).sendKeys(user.getPassword());
		waitForPresenceOfElement(buttonSubmit).click();
		logger.info("Login performed");
		return this;
	}

	public ProductPage subscribe(User user) {
		waitForPresenceOfElement(LocatorUtil.getLocatorByXpathPattern(INPUT_EMAIL_LOCATOR_PATTERN,"email"))
			.sendKeys(user.getEmail());
		waitUntilElementToBeClickableAndClick(LocatorUtil.getLocatorByXpathPattern(INPUT_EMAIL_LOCATOR_PATTERN,"submit"));
		return this;
	}

	public ProductPage selectSize() {
		waitUntilElementToBeClickableAndClick(buttonOpenListOfSizes);
		waitUntilElementToBeClickableAndClick(buttonSelectSize);
		logger.info("Size is chosen");
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

	public String getWrongEmailMessage() {
		return waitForPresenceOfElement(LocatorUtil.getLocatorByXpathPattern(EMAIL_MESSAGE_LOCATOR_PATTERN,"wrong-email"))
			.getText();
	}

	public String getEmptyEmailMessage() {
		return waitForPresenceOfElement(LocatorUtil.getLocatorByXpathPattern(EMAIL_MESSAGE_LOCATOR_PATTERN,"empty-field"))
			.getText();
	}

	public ProductPage openPage(String url) {
		webDriver.get(url);
		logger.info("Product Page opened");
		return this;
	}
}
