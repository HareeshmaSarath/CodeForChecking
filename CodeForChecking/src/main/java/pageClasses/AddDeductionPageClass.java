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

public class AddDeductionPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();

	public AddDeductionPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@role='tree']//child::li")
	List<WebElement> workSelectionFeild;

	@FindBy(xpath = "//span[@role='presentation']")
	WebElement workerComboBox;

	@FindBy(id = "deduction-type")
	WebElement typeSelect;

	@FindBy(id = "deduction-amount")
	WebElement deductionAmount;

	@FindBy(xpath = "//input[@id='deduction-effective_from']")
	WebElement datePickerTextBox;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//span[@title='Clear field']")
	WebElement clearFeild;
	
	@FindBy(xpath = "//ul[@role='tree']")
	WebElement ulElement;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchInput;
	

	public void addNewDedduction(String workText, String typeText, int amount, String date) {
		glu.scrollToAnElement(driver, workerComboBox);
		glu.clickOnElement(workerComboBox);
		glu.scrollToAnElement(driver, searchInput);
		glu.typeOnElement(searchInput, workText);
		glu.pressEnterKey(driver);
		glu.selectFromDropDownByVisibleText(typeSelect, typeText);
		glu.typeOnElementInt(deductionAmount, amount);
		glu.clickOnElement(clearFeild);
		glu.clickOnElement(datePickerTextBox);
		glu.typeOnElement(datePickerTextBox, date);
		glu.pressEnterKey(driver);
		wait.elementToBeClickableWait(driver, saveButton);
		glu.clickOnElement(saveButton);
	}

	// Excel Read Portion
	public String readStringData(int row, int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}

	public String readIntegerData(int row, int col) throws IOException {
		return ExcelReadClass.readInegerData(row, col);
	}
}