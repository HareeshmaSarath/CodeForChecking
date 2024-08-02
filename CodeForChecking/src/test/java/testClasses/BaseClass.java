package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.TakingScreenshot;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	TakingScreenshot ts;
	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		property.load(f);
	}

	@BeforeMethod(groups = { "Launch" })
	@Parameters({ "browser" })
	public void beforeMethod(String browserValue) throws IOException {

		readProperty();

		if (browserValue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserValue.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	}

	@AfterMethod(groups = { "Close" })
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			ts = new TakingScreenshot();
			ts.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}