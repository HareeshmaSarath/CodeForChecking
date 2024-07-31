package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void typeOnElement(WebElement element, String input) {
		element.sendKeys(input);
	}
	
	public void typeOnElementInt(WebElement element, int input) {
		element.sendKeys(input+"");
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public String getCurrentUrlOfPage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getAttributeOfElement(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public void scrollToAnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void clickToAnElementJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void selectFromDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectFromDropDownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void aleretAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dragAndDrop(WebElement element1, WebElement element2, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).build().perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void addSleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void clickAnElementUsingSendKeys(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ENTER).build().perform();
	}

	public void pressEnterKey(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void pressTabKey(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
	}
}