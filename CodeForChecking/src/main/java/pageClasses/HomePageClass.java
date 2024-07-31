package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='col-lg-12 col-sm-12']//child::p)[1]")
	WebElement welcomeMessage;
	
	@FindBy(xpath = "//ul[@id='w1']//child::li[5]")
	WebElement menuItemDeduction;
	
	@FindBy(xpath = "//ul[@id='w1']//child::li[3]")
	WebElement menuItemClient;
	
	public String homePageText() {
		wait.visibilityOfElementLocatedXpath(driver, "(//div[@class='col-lg-12 col-sm-12']//child::p)[1]");
		return glu.getTextOfElement(welcomeMessage);
	}
	
	public void clickOnDeduction() {
		wait.visibilityOfElementLocatedXpath(driver, "//ul[@id='w1']//child::li[5]");
		glu.clickOnElement(menuItemDeduction);
	}
	
	public void clickOnClients() {
		wait.visibilityOfElementLocatedXpath(driver, "//ul[@id='w1']//child::li[3]");
		glu.clickOnElement(menuItemClient);
	}

}