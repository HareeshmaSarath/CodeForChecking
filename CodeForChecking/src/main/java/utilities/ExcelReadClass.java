package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadClass {
	static FileInputStream f; // class and object(refferance variable)
	static XSSFWorkbook w; // class
	static XSSFSheet s;// class

	// string data read - file not found -- such error shows when IO exception
	// throws
	public static String readStringData(int row, int col) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Credentials.xlsx");
		w = new XSSFWorkbook(f); // our excel gives to workbook
		s = w.getSheet("Sheet1"); // use getSheet method to find which sheet in an excel
		XSSFRow r = s.getRow(row); // Interface
		XSSFCell c = r.getCell(col); // Interface
		return c.getStringCellValue(); // return the string value on the excel sheet
	}

	public static String readInegerData(int row, int col) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Credentials.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet("Sheet1");
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue(); // getting double value so cast to integer
		return String.valueOf(val);
	}
	
}