package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.DeductionPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class DeductionTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	DeductionPageClass dp;
	
	@Test(priority = 1)
	public void verifyViewButtonClickOpensProfileViewPage() throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp=new HomePageClass(driver);
		hp.clickOnDeduction();
		dp=new DeductionPageClass(driver);
		dp.clickOnViewIconOnTheRIghtSideDeductionListView();
	}
	
	@Test(priority = 2)
	public void searchAWorkerIsVisibleOrNotInTheList() throws IOException {
		lp=new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp=new HomePageClass(driver);
		hp.clickOnDeduction();
		dp=new DeductionPageClass(driver);
		boolean actual_result=dp.searchAWorkerFromTable(lp.readStringData(7, 0));
		Assert.assertEquals(actual_result, true);
	}
}