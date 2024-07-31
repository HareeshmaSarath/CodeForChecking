package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.PasswordResetClass;

public class LoginTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	PasswordResetClass pr;

	@Test(priority = 1)
	public void verifyTheExpectedPageIsOpenWhileHittingTheURL() {
		lp = new LoginPageClass(driver);
		String actual_result = lp.currentPageURLTextLogin();
		Assert.assertEquals(actual_result, "Login");
	}
	
	@Test(priority = 4)
	public void verifyCheckBoxRememberMeIsSelectedOrNot() {
		lp=new LoginPageClass(driver);
		boolean actual_result=lp.isCheckBoxRememberMeIsSelected();
		Assert.assertEquals(actual_result, true);
	}
	
	@Test(priority = 2)
	public void verifySuccessfullLogin() throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp=new HomePageClass(driver);
		String actual_result=hp.homePageText();
		String expected_result=lp.readStringData(1, 2);
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test(dataProviderClass = DataProviderClass.class,dataProvider = "unsuccessful",priority = 3)
	public void verifyUnsuccessfulLogin(String username,String password) throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(username,password);
		String actual_result=lp.incorrectLoginMessageText();
		Assert.assertEquals(actual_result, lp.readStringData(2, 2));
	}
	
	@Test(priority = 5)
	public void verifyTheForgetPasswordResetCliksDirectedToCorrectPageOrNot() {
		lp=new LoginPageClass(driver);
		lp.resetPasswordLinkClick();
		pr=new PasswordResetClass(driver);
		String actual_resultString=pr.getTextOnPasswordRestPage();
		Assert.assertTrue(actual_resultString.contains("Password Reset"));
	}

}