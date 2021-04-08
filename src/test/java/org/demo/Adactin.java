package org.demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Adactin {
	public static void main(String[] args) throws IOException, InterruptedException {
		Base base = new Base();

		WebDriver driver = base.getdriver();
		base.loadurl(driver, "http://adactinhotelapp.com/");
		base.implic();
// 1st page
		WebElement sendkeys1 = driver.findElement(By.id("username"));
		base.send(sendkeys1, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 0, 1));

		WebElement sendkeys2 = driver.findElement(By.id("password"));
		base.send(sendkeys2, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 1, 1));

		WebElement bttnclick = driver.findElement(By.id("login"));
		base.btnClick(bttnclick);
//2nd page
		WebElement location = driver.findElement(By.id("location"));
		base.byValue(location, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 3, 1));

		WebElement hotel = driver.findElement(By.id("hotels"));
		base.byValue(hotel, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 4, 1));

		WebElement room = driver.findElement(By.id("room_type"));
		base.byValue(room, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 5, 1));

		WebElement roomnos = driver.findElement(By.id("room_nos"));
		base.byindex(roomnos, 2);
//		base.byValue(roomnos, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 6, 1));

		WebElement date = driver.findElement(By.id("datepick_in"));
		base.clear(date);

		WebElement sendkey3 = driver.findElement(By.id("datepick_in"));
		base.send(sendkey3, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 7, 1));

		WebElement date2 = driver.findElement(By.id("datepick_out"));
		base.clear(date2);

		WebElement sendkey4 = driver.findElement(By.id("datepick_out"));
		base.send(sendkey4, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 8, 1));

		WebElement Adultsroom = driver.findElement(By.id("adult_room"));
		base.send(Adultsroom, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 9, 1));

		WebElement Childroom = driver.findElement(By.id("child_room"));
		base.send(Childroom, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 10, 1));

		WebElement btnsearch = driver.findElement(By.id("Submit"));
		base.btnClick(btnsearch);

		WebElement btnradio = driver.findElement(By.id("radiobutton_0"));
		base.btnClick(btnradio);

		WebElement btncountinu = driver.findElement(By.id("continue"));
		base.btnClick(btncountinu);

// 3rd page

		WebElement fistname = driver.findElement(By.id("first_name"));
		base.send(fistname, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 12, 1));

		WebElement lastname = driver.findElement(By.id("last_name"));
		base.send(lastname, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 13, 1));

		WebElement address = driver.findElement(By.id("address"));
		base.send(address, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 14, 1));

		WebElement ccnum = driver.findElement(By.id("cc_num"));
		base.send(ccnum, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 15, 1));

		WebElement cctype = driver.findElement(By.id("cc_type"));
		base.byValue(cctype, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 16, 1));

		WebElement Expirydate = driver.findElement(By.id("cc_exp_month"));
		base.byValue(Expirydate, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 17, 1));

		WebElement Expiryyear = driver.findElement(By.id("cc_exp_year"));
		base.byValue(Expiryyear, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 17, 2));

		WebElement CCvnum = driver.findElement(By.id("cc_cvv"));
		base.send(CCvnum, base.Excelfromvalue("D:\\Eclipse\\Work\\execl\\booking.xlsx", "sheet1", 18, 1));

		WebElement btnbook = driver.findElement(By.id("book_now"));
		base.btnClick(btnbook);
//4th page
		WebElement ordernum = driver.findElement(By.id("order_no"));
		base.text(ordernum);

//		Thread.sleep(8000);
//		WebElement orderno = driver.findElement(By.id("order_no"));
//		String name = orderno.getAttribute("value");
//		System.out.println(name);
		
		Thread.sleep(8000);
		WebElement orderno = driver.findElement(By.id("order_no"));
		String name = orderno.getAttribute("value");
		System.out.println(name);

	}
}
