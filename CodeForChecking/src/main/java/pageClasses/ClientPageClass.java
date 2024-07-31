package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ClientPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();

	public ClientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='clientsearch-id']")
	WebElement clientIdTextBox;

	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientNameTextBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@type='reset']")
	WebElement resetButton;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td//div")
	WebElement noResultFoundText;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td[1]")
	WebElement idFeildInTheSearchResult;

	public boolean resetButtonClick() {
		glu.typeOnElement(clientNameTextBox, "nim");
		glu.typeOnElement(clientIdTextBox, "12");
		glu.clickOnElement(resetButton);
		String nameFeildValue = glu.getTextOfElement(clientNameTextBox);
		String idFeildValue = glu.getTextOfElement(clientIdTextBox);
		System.out.println(nameFeildValue);
		if (nameFeildValue.equals("") && idFeildValue.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public String searchButtonClickForUnSuccessfullSearch(int searchValue) {
		glu.typeOnElementInt(clientIdTextBox, searchValue);
		glu.clickOnElement(searchButton);
		wait.visibilityOfElementLocatedXpath(driver, "//table[@class='table table-striped table-bordered']//tbody//tr//td//div");
		return glu.getTextOfElement(noResultFoundText);
	}

	public boolean searchButtonClickForSuccessfullSearch(int searchValue) {
		glu.typeOnElementInt(clientIdTextBox, searchValue);
		glu.clickOnElement(searchButton);
		return glu.isElementDisplayed(idFeildInTheSearchResult);
	}

}