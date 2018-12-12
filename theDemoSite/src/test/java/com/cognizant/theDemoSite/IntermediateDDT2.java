package com.cognizant.theDemoSite;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IntermediateDDT2 {

	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	static public void initial() {
		reports = new ExtentReports("C:/Users/admin/Desktop/AutomatedTesting/Reports/DemoSiteReport.html", true);
	}

	@AfterClass
	static public void end() {
		reports.close();
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}

	@Test
	// creates user then tries to login as created user
	public void test1() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow usernameRow = sheet.getRow(1);
		String usernameCol = usernameRow.getCell(0).getStringCellValue();

		XSSFRow passwordRow = sheet.getRow(1);
		String passwordCol = passwordRow.getCell(1).getStringCellValue();

		test = reports.startTest("Login Test 1");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password.sendKeys(passwordCol);
		Thread.sleep(500);
		password.submit();

		driver.get("http://thedemosite.co.uk/login.php");
		WebElement username1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username1.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password1.sendKeys(passwordCol);
		Thread.sleep(500);
		password1.submit();

		String success = "";

		try {
			String login = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();

			if (login.equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "It has logged in");
				success = "**Successful Login**";
			} else {
				test.log(LogStatus.FAIL, "It has not logged in");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
		}

		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(3);
		if (cell == null) {
			cell = row.createCell(3);
		}
		cell.setCellValue(success);

		FileOutputStream fileOut = new FileOutputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		file.close();

		if (!success.equals("**Successful Login**")) {
			fail();
		}
	}

	@Test
	// creates user then tries to login as created user
	public void test2() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow usernameRow = sheet.getRow(2);
		String usernameCol = usernameRow.getCell(0).getStringCellValue();

		XSSFRow passwordRow = sheet.getRow(2);
		String passwordCol = passwordRow.getCell(1).getStringCellValue();

		test = reports.startTest("Login Test 2");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password.sendKeys(passwordCol);
		Thread.sleep(500);
		password.submit();

		driver.get("http://thedemosite.co.uk/login.php");
		WebElement username1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username1.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password1.sendKeys(passwordCol);
		Thread.sleep(500);
		password1.submit();

		String success = "";

		try {
			String login = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();

			if (login.equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "It has logged in");
				success = "**Successful Login**";
			} else {
				test.log(LogStatus.FAIL, "It has not logged in");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
		}

		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(3);
		if (cell == null) {
			cell = row.createCell(3);
		}
		cell.setCellValue(success);

		FileOutputStream fileOut = new FileOutputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		file.close();

		if (!success.equals("**Successful Login**")) {
			fail();
		}
	}
	
	@Test
	// creates user then tries to login as created user
	public void test3() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow usernameRow = sheet.getRow(3);
		String usernameCol = usernameRow.getCell(0).getStringCellValue();

		XSSFRow passwordRow = sheet.getRow(3);
		String passwordCol = passwordRow.getCell(1).getStringCellValue();

		test = reports.startTest("Login Test 3");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password.sendKeys(passwordCol);
		Thread.sleep(500);
		password.submit();

		driver.get("http://thedemosite.co.uk/login.php");
		WebElement username1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username1.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password1.sendKeys(passwordCol);
		Thread.sleep(500);
		password1.submit();

		String success = "";

		try {
			String login = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();

			if (login.equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "It has logged in");
				success = "**Successful Login**";
			} else {
				test.log(LogStatus.FAIL, "It has not logged in");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
		}

		XSSFRow row = sheet.getRow(3);
		XSSFCell cell = row.getCell(3);
		if (cell == null) {
			cell = row.createCell(3);
		}
		cell.setCellValue(success);

		FileOutputStream fileOut = new FileOutputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		file.close();

		if (!success.equals("**Successful Login**")) {
			fail();
		}
	}
	
	@Test
	// creates user then tries to login as created user
	public void test4() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow usernameRow = sheet.getRow(4);
		String usernameCol = usernameRow.getCell(0).getStringCellValue();

		XSSFRow passwordRow = sheet.getRow(4);
		String passwordCol = passwordRow.getCell(1).getStringCellValue();

		test = reports.startTest("Login Test 4");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password.sendKeys(passwordCol);
		Thread.sleep(500);
		password.submit();

		driver.get("http://thedemosite.co.uk/login.php");
		WebElement username1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username1.sendKeys(usernameCol);
		Thread.sleep(500);
		WebElement password1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password1.sendKeys(passwordCol);
		Thread.sleep(500);
		password1.submit();

		String success = "";

		try {
			String login = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();

			if (login.equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "It has logged in");
				success = "**Successful Login**";
			} else {
				test.log(LogStatus.FAIL, "It has not logged in");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
		}

		XSSFRow row = sheet.getRow(4);
		XSSFCell cell = row.getCell(3);
		if (cell == null) {
			cell = row.createCell(3);
		}
		cell.setCellValue(success);

		FileOutputStream fileOut = new FileOutputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");

		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		file.close();

		if (!success.equals("**Successful Login**")) {
			fail();
		}
	}
	
}