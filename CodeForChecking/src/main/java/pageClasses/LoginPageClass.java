package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities glu=new GeneralUtilities();
	ExplicitWaitClass wait=new ExplicitWaitClass();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginform-rememberme")
	WebElement rememberCheck;
	
	@FindBy(xpath = "//div[@style='color:#999;margin:1em 0']//child::a")
	WebElement resetPasswordLink;
	
	@FindBy(id="loginform-username")
	WebElement usernameTextBox;
	
	@FindBy(id="loginform-password")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//h1[text()='Login']")
	WebElement loginTextOnTop;
	
	@FindBy(xpath = "//p[contains(text(),'Incorrect')]")
	WebElement inCorrectMessage;
	
	public String currentPageURLTextLogin() {
		return glu.getTextOfElement(loginTextOnTop);
	}
	
	public boolean isCheckBoxRememberMeIsSelected() {
		return glu.isElementSelected(rememberCheck);
	}
	
	public void loginToSite(String username,String password) {
		glu.typeOnElement(usernameTextBox, username);
		glu.typeOnElement(passwordTextBox, password);
		wait.elementToBeClickableWait(driver, loginButton);
		glu.clickOnElement(loginButton);
	}
	
	public String incorrectLoginMessageText() {
		wait.visibilityOfElementLocatedXpath(driver, "//p[contains(text(),'Incorrect')]");
		return glu.getTextOfElement(inCorrectMessage);
	}
	
	public void resetPasswordLinkClick() {
		glu.clickOnElement(resetPasswordLink);
	}
	
	//Excel Read Portion
	public String readStringData(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}
	
	public String readIntegerData(int row,int col) throws IOException {
		return ExcelReadClass.readInegerData(row, col);
	}
}