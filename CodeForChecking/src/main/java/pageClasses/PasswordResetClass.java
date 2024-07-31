package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class PasswordResetClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();

	public PasswordResetClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-sm-4 form-area inner']//child::h1")
	WebElement passwordResetText;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailIDTextBox;

	@FindBy(xpath = "//button[text()='Send']")
	WebElement sendButton;

	@FindBy(xpath = "//div[@class='form-group']//child::a")
	WebElement cancelButton;

	@FindBy(xpath = "//form[@id='request-password-reset-form']//child::p")
	WebElement errorMessage;

	public String getTextOnPasswordRestPage() {
		wait.visibilityOfElementLocatedXpath(driver, "//div[@class='col-sm-4 form-area inner']//child::h1");
		return glu.getTextOfElement(passwordResetText);
	}

	public String emailCannotBeBlank() {
		sendButton.click();
		wait.visibilityOfElementLocatedXpath(driver, "//form[@id='request-password-reset-form']//child::p");
		return glu.getTextOfElement(errorMessage);
	}

	public String emailIsNotAValidEmailAddress(String email) {
		glu.typeOnElement(emailIDTextBox, email);
		sendButton.click();
		wait.visibilityOfElementLocatedXpath(driver, "//form[@id='request-password-reset-form']//child::p");
		return glu.getTextOfElement(errorMessage);
	}

	public String invalidMailIdFormate(String email) {
		glu.typeOnElement(emailIDTextBox, email);
		sendButton.click();
		wait.visibilityOfElementLocatedXpath(driver, "//form[@id='request-password-reset-form']//child::p");
		return glu.getTextOfElement(errorMessage);
	}
	
	public void cancelButtonClick() {
		glu.clickOnElement(cancelButton);
	}

	// Excel Read Portion
	public String readStringData(int row, int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}

	public String readIntegerData(int row, int col) throws IOException {
		return ExcelReadClass.readInegerData(row, col);
	}
}
