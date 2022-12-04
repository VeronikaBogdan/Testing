package page;

import org.openqa.selenium.WebDriver;

public class DressProductPage extends ProductPage {
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/collections/autumnvibes/plate-khudi-kofeynogo-tsveta-v-sportivnom-stile-s-aktsentnym-printom-/";

	public DressProductPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public ProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		return this;
	}
}
