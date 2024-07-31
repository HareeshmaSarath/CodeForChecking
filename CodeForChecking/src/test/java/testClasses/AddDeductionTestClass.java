package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.AddDeductionPageClass;
import pageClasses.AddDeductionViewPageClass;
import pageClasses.DeductionPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class AddDeductionTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	DeductionPageClass dp;
	AddDeductionPageClass adp;
	AddDeductionViewPageClass advp;

	@Test(priority = 1)
	public void addDeductionSuccesfuly() throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginToSite(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp = new HomePageClass(driver);
		hp.clickOnDeduction();

		dp = new DeductionPageClass(driver);
		dp.clickOnAddDuductionMenu();

		adp = new AddDeductionPageClass(driver);
		int amt = Integer.parseInt(lp.readIntegerData(7, 3));
		adp.addNewDedduction(lp.readStringData(9, 3), lp.readStringData(8, 3), amt, lp.readStringData(10, 3));

		advp = new AddDeductionViewPageClass(driver);
		String Actual_result = advp.getTextFromDeductionAddedViewPage();
		String Expected_Worker_Name = lp.readStringData(9, 3);
		Expected_Worker_Name = Expected_Worker_Name.replaceAll("\\s.*", "");
		//System.out.println(Actual_result + " " + Expected_Worker_Name);

		Assert.assertTrue(Actual_result.contains(Expected_Worker_Name));
	}
}