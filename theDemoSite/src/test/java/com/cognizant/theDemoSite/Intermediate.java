package com.cognizant.theDemoSite;

import static org.junit.Assert.fail;

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

public class Intermediate {

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
	public void createLoginUser() throws InterruptedException {
		
		test = reports.startTest("Login Test 1");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username.sendKeys("ZakRoberts");
		Thread.sleep(500);
		WebElement password = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password.sendKeys("password");
		Thread.sleep(500);
		password.submit();

		driver.get("http://thedemosite.co.uk/login.php");
		WebElement username1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username1.sendKeys("ZakRoberts");
		Thread.sleep(500);
		WebElement password1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password1.sendKeys("password");
		Thread.sleep(500);
		password1.submit();

		try {
			String login = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();

			if (login.equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "It has logged in");
			} else {
				test.log(LogStatus.FAIL, "It has not logged in");
				fail();
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}

	}

	@Test
	// creates user then tries to login as created user
	public void createNotLoginUser() throws InterruptedException {
		
		test = reports.startTest("Login Test 2");
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		WebElement username = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username.sendKeys("ZakRoberts");
		Thread.sleep(500);
		WebElement password = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password.sendKeys("password");
		Thread.sleep(500);
		password.submit();

		driver.get("http://thedemosite.co.uk/login.php");
		WebElement username1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		Thread.sleep(500);
		username1.sendKeys("ZakRoberts");
		Thread.sleep(500);
		WebElement password1 = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		Thread.sleep(500);
		password1.sendKeys("fjkbesgkhsrbg");
		Thread.sleep(500);
		password1.submit();

		try {
			String login = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();

			if (login.equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "It has logged in");
			} else {
				test.log(LogStatus.FAIL, "It has not logged in");
				fail();
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}

	}

}