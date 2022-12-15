package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private static final String PERSONAL_PAGE_URL = "https://markformelle.by/personal/";
	private final By name = By.xpath("//input[@name='NAME']");
	private final By surname = By.xpath("//input[@name='LAST_NAME']");
	private final By email = By.xpath("//input[@name='EMAIL']");

	public PersonalPage(WebDriver webDriver) {
		super(webDriver);
	}

	public String getName() {
		logger.info("Get name from input's attribute");
		return waitForPresenceOfElement(name).getAttribute("value");
	}

	public String getSurname() {
		logger.info("Get surname from input's attribute");
		return waitForPresenceOfElement(surname).getAttribute("value");
	}
	public String getEmail() {
		logger.info("Get email from input's attribute");
		return waitForPresenceOfElement(email).getAttribute("value");
	}

	@Override
	public PersonalPage openPage() {
		webDriver.get(PERSONAL_PAGE_URL);
		logger.info("Personal page opened");
		return this;
	}
}
