package org.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Basic {
	public static WebDriver driver;

	public WebDriver getdriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Selenium\\Driver\\chromedriver.exe");
		return driver = new ChromeDriver();

	}

	// WebElement methods
	public void send(WebElement E, String s) {
		E.sendKeys(s);
	}

	public void text(WebElement E) {
		E.getText();
	}

	void attri(WebElement E, String data) {
		E.getAttribute(data);
	}

	public void size(WebElement element, Integer data) {
		element.getSize();
	}

	public void gets(WebDriver E, String data) {
		E.get(data);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public void row(Sheet S, Integer data) {
		S.getRow(data);
	}

	public void cell(Row S, Integer data) {
		S.getCell(data);
	}

	// File methods
	public void mk(File F) {
		F.mkdir();
	}

	public void mks(File F) {
		F.mkdirs();
	}

	public void delete(File F) {
		F.delete();

	}

	// Action
	public void dragdrop(WebElement sourceElement, WebElement desElement) {

		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, desElement);
	}

	public void contextclick(WebElement element, WebElement contextElement) {
		Actions action = new Actions(driver);
		action.contextClick(contextElement);
	}

	public void doubleclick(WebElement element, WebElement doubleclickElement) {
		Actions a = new Actions(driver);
		a.doubleClick(doubleclickElement);
	}

	// robot
	public void keypress(WebElement element, Robot keydownRobot) throws AWTException {
		Robot r = new Robot();
		r.keyPress(0);
	}

	public void keyrelease(WebElement element, Robot keyupRobot) throws AWTException {
		Robot r = new Robot();
		r.keyRelease(0);
	}

	public void mousemove(WebElement element, Robot mouseRobot) throws AWTException {
		Robot r = new Robot();
		r.mouseMove(0, 0);
	}

	public void mousepress(WebElement element, Robot mouseRobot) throws AWTException {
		Robot r = new Robot();
		r.mousePress(0);
	}

	public void mouserelase(WebElement element, Robot mouseRobot) throws AWTException {
		Robot r = new Robot();
		r.mouseRelease(0);
	}

//Alert method
	public void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void conformAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void promptAlert(String stvalueString) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(stvalueString);
	}

//TakeScreenShot 
	public void screenshot(String data, String data1, String data2) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(System.setProperty(data1, data2));
	}

//DropDown
	public void visibletext(WebElement element, String valueString) {
		Select s = new Select(element);
		s.deselectByVisibleText(valueString);
	}

	public void deSelectVisibleText(WebElement element, String valueString) {
		Select s = new Select(element);
		s.deselectByVisibleText(valueString);
	}

	public void VisibleIndex(WebElement element, Integer value) {
		Select s = new Select(element);
		s.selectByIndex(value);
	}

	public void byindex(WebElement element, Integer valueint) {
		Select s = new Select(element);
		s.selectByIndex(valueint);
	}

	public void close() {
		driver.switchTo();
	}

	public void quit() {
		driver.quit();
	}

//frmae
	public void frame(WebElement element, Integer valString) {
		driver.switchTo().frame(0);
	}

	public void switchto() {
		driver.switchTo();
	}

	public void to(WebElement element) {
		driver.toString();
	}

//navition methid
	public void back() {
		driver.navigate().back();
	}

	public void to(String valString) {
		driver.navigate().to(valString);
	}

	public void refersh() {
		driver.navigate().refresh();
	}

	public void celltype(Cell c) {
		c.getCellType();
	}

	public void numericalcellvalue(Cell c) {
		c.getNumericCellValue();
	}

	public void valueof(String s, Double valeDouble) {
		String.valueOf(valeDouble);
	}

	public void Stringcellvalue(Cell c) {
		c.getStringCellValue();
	}

	public void createcell(Row r, Integer vaInteger) {
		r.createCell(vaInteger);
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
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
			value = dateFormat.format(dateCellVale);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);

		}
		return value;

	}

}
