package org.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public static WebDriver driver;

	public WebDriver getdriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Selenium\\Driver\\chromedriver.exe");
		return driver = new ChromeDriver();

	}

	public void implic() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void loadurl(WebDriver driver, String data) {
		driver.get(data);
	}

	public void send(WebElement element, String s) {
		element.sendKeys(s);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public void text(WebElement element) {
		element.getText();
	}

	public void getAttribute(WebElement element, String data) {
		element.getAttribute(data);
	}

	public void clear(WebElement element) {
		element.clear();

	}

	// DropDown
	public void visibletext(WebElement element, String valueString) {
		Select s = new Select(element);
		s.deselectByVisibleText(valueString);
	}

	public void deSelectVisibleText(WebElement element, String valueString) {
		Select s = new Select(element);
		s.deselectByVisibleText(valueString);
	}

	public void byValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void byindex(WebElement element, Integer valueint) {
		Select s = new Select(element);
		s.selectByIndex(valueint);
	}

	public void VisibleIndex(WebElement element, Integer value) {
		Select s = new Select(element);
		s.selectByIndex(value);
	}

	// exelsheet
	public String Excelfromvalue(String pathname, String sheetname, int rownum, int cellnum) throws IOException {
		File file = new File(pathname);
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		String value = " ";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellVale = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
			value = dateFormat.format(dateCellVale);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);

		}
		return value;

	}

	public static void WebPageToExcel(String name) {
		File file = new File("D:\\Eclipse\\Work\\execl\\new datats.xlsx");
		Workbook wk = new XSSFWorkbook();
		Sheet createSheet = wk.createSheet();
		Row createRow = createSheet.createRow(0);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(name);

	}

}
