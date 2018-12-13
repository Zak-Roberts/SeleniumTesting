package com.cognizant.theDemoSite;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginUserTest4DDT {

	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	static public void initial() {
		reports = new ExtentReports("C:/Users/admin/Desktop/AutomatedTesting/Reports/DemoSiteRemakeReport.html", false);
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
	public void loginUser4() throws Exception {
		
		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow usernameRow = sheet.getRow(4);
		String username = usernameRow.getCell(0).getStringCellValue();

		XSSFRow passwordRow = sheet.getRow(4);
		String password = passwordRow.getCell(1).getStringCellValue();
		
		test = reports.startTest("Login User Test 4");
		driver.get("http://thedemosite.co.uk/login.php");
		LoginUserPage loginUserPage = PageFactory.initElements(driver, LoginUserPage.class);
		loginUserPage.enterUser(username, password);
		
		String success = "**Failed Login**";

		try {
			String login = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();

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
		workbook.close();
	
		if (!success.equals("**Successful Login**")) {
			fail();
		}
	}
	
}