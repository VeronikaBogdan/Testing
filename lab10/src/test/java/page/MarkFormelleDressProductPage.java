package page;

import org.openqa.selenium.WebDriver;

public class MarkFormelleDressProductPage extends MarkFormelleProductPage{
	private static final String PRODUCT_PAGE_URL = "https://markformelle.by/catalog/collections/autumnvibes/plate-khudi-kofeynogo-tsveta-v-sportivnom-stile-s-aktsentnym-printom-/";

	public MarkFormelleDressProductPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public MarkFormelleProductPage openPage() {
		webDriver.get(PRODUCT_PAGE_URL);
		return this;
	}
}
