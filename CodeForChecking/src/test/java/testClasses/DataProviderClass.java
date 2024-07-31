package testClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReadClass;

public class DataProviderClass {
	
	@DataProvider(name="unsuccessful")
	public Object[][] dp() throws IOException {
		return new Object[][] { 
			new Object[] { ExcelReadClass.readStringData(2, 0), ExcelReadClass.readStringData(2, 1) }, 
			new Object[] { ExcelReadClass.readStringData(3, 0), ExcelReadClass.readStringData(3, 1) }, 
			new Object[] { ExcelReadClass.readStringData(4, 0), ExcelReadClass.readStringData(4, 1) }, 
		};
	}
}