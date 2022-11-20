package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPage {
	protected static final Duration WAIT_SECONDS = Duration.ofSeconds(5);
	protected WebDriver webDriver;

	protected abstract AbstractPage openPage();

	protected AbstractPage(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
}
