package com.cognizant.theDemoSite;


import java.io.FileInputStream;

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

public class CreateUserTest4DDT {

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
	public void createUser4() throws Exception {
		
		FileInputStream file = new FileInputStream("C:/Users/Admin/Desktop/AutomatedTesting/DemoSiteDDT.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow usernameRow = sheet.getRow(4);
		String username = usernameRow.getCell(0).getStringCellValue();

		XSSFRow passwordRow = sheet.getRow(4);
		String password = passwordRow.getCell(1).getStringCellValue();
		
		test = reports.startTest("Create User Test 4");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.createUser(username, password);

		try {
			String username1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")).getText();
			String password1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")).getText();

			if (username1.contains(username) && password1.contains(password)) {
				test.log(LogStatus.PASS, "It has added user");
			} else {
				test.log(LogStatus.FAIL, "It has not added user");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
		}

		file.close();
		workbook.close();

	}

}