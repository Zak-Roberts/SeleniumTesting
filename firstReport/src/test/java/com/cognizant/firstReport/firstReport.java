package com.cognizant.firstReport;

import static org.junit.Assert.*;
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

public class firstReport {

	static ExtentReports reports;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	static public void initial() {
		reports = new ExtentReports("C:/Users/admin/Desktop/AutomatedTesting/Reports/FirstReport.html", true);
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
		reports.endTest(test);
		reports.flush(); // updates
		driver.quit();
	}

	@Test
	public void bingSearch1() {
		test = reports.startTest("Bing Search Selenium 1");
		driver.get("https://www.bing.com/");
		WebElement searchBox = driver.findElement(By.id("sb_form_q"));
		searchBox.sendKeys("Selenium");
		searchBox.submit();

		try {
			WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));

			if (sideBar.getText().equals("Selenium")) {
				test.log(LogStatus.PASS, "It has found 'Selenium' at given XPath");
			} else {
				test.log(LogStatus.FAIL, "It has not found 'Selenium' at given XPath");
				fail();
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
	}

	@Test
	public void bingSearch2() {
		test = reports.startTest("Bing Search Selenium 2");
		driver.get("https://www.bing.com/");
		WebElement searchBox = driver.findElement(By.id("sb_form_q"));
		searchBox.sendKeys("Selenium");
		searchBox.submit();

		try {
			WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));

			if (sideBar.getText().equals("Selenium")) {
				test.log(LogStatus.PASS, "It has found 'Selenium' at given XPath");
			} else {
				test.log(LogStatus.FAIL, "It has not found 'Selenium' at given XPath");
				fail();
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
	}

}
