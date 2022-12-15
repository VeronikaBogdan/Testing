package test;

import model.User;
import org.testng.annotations.Test;
import page.CertificatePage;
import page.SweaterProductPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CertificatePageTest extends CommonConditions{
	private static final String CERTIFICATE_SUM = "30";
	@Test
	public void testPreviewCertificateMessage() {
		User sender = UserCreator.withCredentialsFromPropertyToCertificate();
		CertificatePage preview = new CertificatePage(webDriver)
			.openPage()
			.closeModalViewEnter()
			.fillFormForCertificate(sender);
		String nameOfBuyer = preview.getNameOfBuyerFromPreview();
		String certificateSum = preview.getCertificateSumFromPreview();

		assertThat(nameOfBuyer, is(equalTo(sender.getName())));
		assertThat(certificateSum, is(equalTo(CERTIFICATE_SUM)));
	}
}
