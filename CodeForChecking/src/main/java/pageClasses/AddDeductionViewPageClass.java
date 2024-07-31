package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class AddDeductionViewPageClass {
	
	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	//FluentWaitClass wait = new FluentWaitClass();
	ExplicitWaitClass wait=new ExplicitWaitClass();

	public AddDeductionViewPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//table[@id='w0']//tbody//tr//td[1])[1]")
	WebElement workerNameHeading;
	
	public String getTextFromDeductionAddedViewPage() {
		//wait.visibilityOfWait(driver, workerNameHeading);
		wait.visibilityOfElementLocatedXpath(driver, "(//table[@id='w0']//tbody//tr//td[1])[1]");
		return glu.getTextOfElement(workerNameHeading);
	}
}