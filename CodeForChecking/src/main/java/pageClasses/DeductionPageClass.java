package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class DeductionPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();

	public DeductionPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']//tr[2]//td[7]//a)[1]")
	WebElement viewIcon;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody/tr")
	List<WebElement> aWorkerRow;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody/tr[1]//td")
	List<WebElement> aWorkerCol;
	
	@FindBy(xpath = "//a[text()='Add Deduction']")
	WebElement addDuductionMenu;

	public void clickOnViewIconOnTheRIghtSideDeductionListView() {
		wait.visibilityOfElementLocatedXpath(driver,
				"(//table[@class='table table-striped table-bordered']//tr[2]//td[7]//a)[1]");
		glu.clickOnElement(viewIcon);
	}

	public boolean searchAWorkerFromTable(String workerName) {
		int rowCount = aWorkerRow.size();
		int colCount = aWorkerCol.size();
		boolean flag = false;
		for (int row = 1; row < rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				wait.visibilityOfElementLocatedXpath(driver, "//table[@class='table table-striped table-bordered']//tbody//tr[" + (row + 1) + "]//td[" + col + "]");
				WebElement textValue = driver
						.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr[" + (row + 1) + "]//td[" + col + "]"));
				String workker=glu.getTextOfElement(textValue);
				if (workker.equals(workerName)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	public void clickOnAddDuductionMenu() {
		glu.clickOnElement(addDuductionMenu);
	}

	// Excel Read Portion
	public String readStringData(int row, int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}

	public String readIntegerData(int row, int col) throws IOException {
		return ExcelReadClass.readInegerData(row, col);
	}

}