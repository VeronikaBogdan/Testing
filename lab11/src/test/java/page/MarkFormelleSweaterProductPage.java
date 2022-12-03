package page;

import org.openqa.selenium.WebDriver;

public class MarkFormelleSweaterProductPage extends MarkFormelleProductPage{
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/koftochki-longslivy/dzhempery-kombidresy/122722-74708-1050/";

	public MarkFormelleSweaterProductPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public MarkFormelleProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		return this;
	}
}
