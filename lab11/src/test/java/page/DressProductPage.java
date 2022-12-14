package page;

import org.openqa.selenium.WebDriver;

public class DressProductPage extends ProductPage {
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/platya-tuniki-yubki/platya-tuniki-dlinnyy-rukav/152549-12274-18117/";

	public DressProductPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public ProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		return this;
	}
}
