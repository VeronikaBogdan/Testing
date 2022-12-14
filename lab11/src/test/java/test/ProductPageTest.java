package test;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.PersonalPage;
import page.SweaterProductPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductPageTest extends CommonConditions {
	private final Logger logger = LogManager.getRootLogger();

	@Test
	public void testLogin() {
		User testUser = UserCreator.withCredentialsFromProperty();
		new SweaterProductPage(webDriver)
			.openPage()
			.login(testUser);
		logger.info("user is logged in (Test)");
		String loggedInUserEmail = new PersonalPage(webDriver)
			.openPage()
			.getEmail();
		logger.info("Get email in Test");
		assertThat(loggedInUserEmail, is(equalTo(testUser.getEmail())));
	}
}
