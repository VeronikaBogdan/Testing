package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DressProductPage extends ProductPage {
	private final Logger logger = LogManager.getRootLogger();
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/platya-tuniki-yubki/platya-tuniki-dlinnyy-rukav/152532-75491-1050/";

	public DressProductPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public ProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		logger.info("Dress page opened");
		return this;
	}
}
