package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.LocatorUtil;

public class PersonalPage extends AbstractPage {
	private final Logger logger = LogManager.getRootLogger();
	private static final String PERSONAL_PAGE_URL = "https://markformelle.by/personal/";
	private static final String INPUT_LOCATOR_PATTERN = "//input[@name='%s']";

	public PersonalPage(WebDriver webDriver) {
		super(webDriver);
	}

	public String getName() {
		logger.info("Get name from input's attribute");
		return waitForPresenceOfElement(LocatorUtil.getLocatorByXpathPattern(INPUT_LOCATOR_PATTERN,"NAME"))
			.getAttribute("value");
	}

	public String getSurname() {
		logger.info("Get surname from input's attribute");
		return waitForPresenceOfElement(LocatorUtil.getLocatorByXpathPattern(INPUT_LOCATOR_PATTERN,"LAST_NAME"))
			.getAttribute("value");
	}
	public String getEmail() {
		logger.info("Get email from input's attribute");
		return waitForPresenceOfElement(LocatorUtil.getLocatorByXpathPattern(INPUT_LOCATOR_PATTERN,"EMAIL"))
			.getAttribute("value");
	}

	@Override
	public PersonalPage openPage() {
		webDriver.get(PERSONAL_PAGE_URL);
		logger.info("Personal page opened");
		return this;
	}
}
