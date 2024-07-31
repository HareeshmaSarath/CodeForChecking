package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ClientPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class ClientTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ClientPageClass cp;

	@Test(priority = 1)
	public void verifyResetButtonIsWorkingOrNot() throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp=new HomePageClass(driver);
		hp.clickOnClients();
		cp=new ClientPageClass(driver);
		boolean actual_result=cp.resetButtonClick();
		System.out.println(actual_result);
		Assert.assertEquals(actual_result, true);
	}
	
	@Test(priority = 3)
	public void verifySuccessfullSearchUsingClientId() throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp=new HomePageClass(driver);
		hp.clickOnClients();
		cp=new ClientPageClass(driver);
		int search_value=Integer.parseInt(lp.readIntegerData(12, 1));
		boolean actual_result=cp.searchButtonClickForSuccessfullSearch(search_value);
		Assert.assertEquals(actual_result, true);
	}
	
	@Test(priority = 2)
	public void verifyUnSuccessfullSearchUsingClentId() throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp=new HomePageClass(driver);
		hp.clickOnClients();
		cp=new ClientPageClass(driver);
		int search_value=Integer.parseInt(lp.readIntegerData(12, 0));
		String actual_result=cp.searchButtonClickForUnSuccessfullSearch(search_value);
		Assert.assertEquals(actual_result, "No results found.");
	}
	
}