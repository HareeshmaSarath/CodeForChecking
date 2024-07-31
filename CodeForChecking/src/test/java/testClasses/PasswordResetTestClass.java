package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.LoginPageClass;
import pageClasses.PasswordResetClass;

public class PasswordResetTestClass extends BaseClass{

	PasswordResetClass pr;
	LoginPageClass lp;

	@Test(priority = 1)
	public void verifyIncorrectMailIdSubmitShowsThereIsNoUserWithThisEmail() throws IOException {
		lp=new LoginPageClass(driver);
		lp.resetPasswordLinkClick();
		pr=new PasswordResetClass(driver);
		String actual_result=pr.emailIsNotAValidEmailAddress(pr.readStringData(2, 4));
		Assert.assertTrue(actual_result.contains(pr.readStringData(3, 3)));
	}
	
	@Test(priority = 2)
	public void verifyEmailCannotBeBlankMessageShowsWhenClikngSendButton() throws IOException {
		lp=new LoginPageClass(driver);
		lp.resetPasswordLinkClick();
		pr=new PasswordResetClass(driver);
		String actual_error_result=pr.emailCannotBeBlank();
		Assert.assertTrue(actual_error_result.contains(pr.readStringData(1, 3)));
	}
	
	@Test(priority = 3)
	public void verifyEmailIsNotAValidEmailAddress() throws IOException {
		lp=new LoginPageClass(driver);
		lp.resetPasswordLinkClick();
		pr=new PasswordResetClass(driver);
		String actual_result=pr.invalidMailIdFormate(pr.readStringData(1, 4));
		Assert.assertEquals(actual_result, pr.readStringData(2, 3));
	}
	
	@Test(priority = 4)
	public void verifyCancelButtonClickRedirectToLoginPageOrNot() {
		lp=new LoginPageClass(driver);
		lp.resetPasswordLinkClick();
		pr=new PasswordResetClass(driver);
		pr.cancelButtonClick();
		String actual_result=lp.currentPageURLTextLogin();
		Assert.assertEquals(actual_result, "Login");
	}
}