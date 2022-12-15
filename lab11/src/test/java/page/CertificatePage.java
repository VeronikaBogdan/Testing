package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificatePage extends AbstractPage{
	private final Logger logger = LogManager.getRootLogger();
	protected static final String CERTIFICATION_PAGE_URL = "https://markformelle.by/electronic-gift-card/";
	private final By nameOfBuyer = By.xpath("//input[@id='field_NAME']");
	private final By nameOfRecipient = By.xpath("//input[@id='field_TO_NAME']");
	private final By emailOfRecipient = By.xpath("//input[@id='field_TO_EMAIL']");
	private final By nominalValue = By.xpath("//span[contains(text(), '30')]");
	private final By previewNameOfBuyer = By.xpath("//span[contains(@class, 'source-name-output')]");
	private final By certificateSum = By.xpath("//span[contains(@class, 'value-output')]");
	private final By modalViewEnter = By.xpath("//button[@title='Close (Esc)']");

	public CertificatePage(WebDriver driver) {
		super(driver);
	}

	public CertificatePage fillFormForCertificate(User user) {
		waitUntilElementToBeClickableAndClick(nominalValue);
		waitForPresenceOfElement(nameOfBuyer).sendKeys(user.getName());
		waitForPresenceOfElement(nameOfRecipient).sendKeys(user.getSurname());
		waitForPresenceOfElement(emailOfRecipient).sendKeys(user.getEmail());
		logger.info("Certificate data performed");
		return this;
	}

	public CertificatePage closeModalViewEnter() {
		waitForPresenceOfElement(modalViewEnter).click();
		return this;
	}

	public String getNameOfBuyerFromPreview() {
		return waitForPresenceOfElement(previewNameOfBuyer)
			.getText();
	}

	public String getCertificateSumFromPreview() {
		return waitForPresenceOfElement(certificateSum)
			.getText()
			.substring(0,2);
	}

	@Override
	public CertificatePage openPage() {
		webDriver.get(CERTIFICATION_PAGE_URL);
		logger.info("Certificate Page is opened");
		return this;
	}
}
