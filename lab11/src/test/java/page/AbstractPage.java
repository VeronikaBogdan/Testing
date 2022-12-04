package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
	protected static final int WAIT_SECONDS = 10;
//	protected static final Duration WAIT_SECONDS = Duration.ofSeconds(15);
	protected WebDriver webDriver;

	protected abstract AbstractPage openPage();

	protected AbstractPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(webDriver, WAIT_SECONDS);
		PageFactory.initElements(factory, this);
	}

	protected WebElement waitForPresenceOfElement(By locator) {
		return new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_SECONDS))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected void waitUntilElementToBeClickableAndClick(By locator) {
		new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_SECONDS))
			.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
}
