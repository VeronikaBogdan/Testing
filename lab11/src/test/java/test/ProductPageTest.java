package test;

import model.User;
import org.testng.annotations.Test;
import page.PersonalPage;
import page.ProductPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductPageTest extends CommonConditions {
	private static final String SWEATER_PAGE_URL = "https://markformelle.by/catalog/zhenshchinam/mf-life/koftochki-longslivy/dzhempery-kombidresy/122722-74708-1050/";
	private static final String WRONG_EMAIL_MESSAGE = "Кажется, в адресе ошибка";
	private static final String EMPTY_EMPTY_MESSAGE = "Нужен E-mail, чтобы подписаться";

	@Test
	public void testLogin() {
		User testUser = UserCreator.withCredentialsFromProperty();
		new ProductPage(webDriver)
			.openPage(SWEATER_PAGE_URL)
			.login(testUser);
		String loggedInUserEmail = new PersonalPage(webDriver)
			.openPage()
			.getEmail();
		assertThat(loggedInUserEmail, is(equalTo(testUser.getEmail())));
	}

	@Test
	public void testInvalidFillingInSubscriptionForm() {
		User user = UserCreator.withCredentialsFromPropertyWrongEmail();
		String wrongEmailMessage = subscribeUser(user).getWrongEmailMessage();

		user = UserCreator.withCredentialsFromPropertyEmptyEmail();
		String emptyEmailMessage = subscribeUser(user).getEmptyEmailMessage();

		assertThat(wrongEmailMessage, is(equalTo(WRONG_EMAIL_MESSAGE)));
		assertThat(emptyEmailMessage, is(equalTo(EMPTY_EMPTY_MESSAGE)));
	}

	public ProductPage subscribeUser(User user) {
		return new ProductPage(webDriver)
			.openPage(SWEATER_PAGE_URL)
			.subscribe(user);
	}
}
