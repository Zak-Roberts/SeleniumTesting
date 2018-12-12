package com.cognizant.shoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
		reports = new ExtentReports("C:/Users/admin/Desktop/AutomatedTesting/Reports/ShoppingWebsiteReport.html", true);
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
	public void findChiffonDress() throws InterruptedException {

		test = reports.startTest("Find Chiffon Dress");
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		Thread.sleep(500);
		textbox.sendKeys("Dress");
		Thread.sleep(500);
		textbox.submit();
		Thread.sleep(500);

		WebElement dress = null;
		String dressTitle = null;
		try {
			dress = driver.findElement(By.id("center_column"));
			dress = dress.findElement(By.cssSelector("ul[class='product_list grid row']"));		// needs this if there are spaces in className!
			dress = dress.findElement(By.partialLinkText("Printed Chiffon Dress"));
			dressTitle = dress.getAttribute("title");
			
			if (dressTitle.contains("Printed Chiffon Dress")) {
				test.log(LogStatus.PASS, "The 'Printed Chiffon Dress' was found!");
			}
			
		} catch (NoSuchElementException e) {
			//Assert.fail("The 'Printed Chiffon Dress' was not found!");
			test.log(LogStatus.FAIL, "The 'Printed Chiffon Dress' was not found!");
			fail();
		}
		//Assert.assertNotNull(dress);
		//Assert.assertEquals("Printed Chiffon Dress not displayed", true, dressTitle.contains("Printed Chiffon Dress"));
	}
	
	@Test
	public void notFindChiffonDress() throws InterruptedException {

		test = reports.startTest("Not Find Chiffon Dress");
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		Thread.sleep(500);
		textbox.sendKeys("Blouse");
		Thread.sleep(500);
		textbox.submit();
		Thread.sleep(500);

		WebElement dress = null;
		String dressTitle = null;
		try {
			dress = driver.findElement(By.id("center_column"));
			dress = dress.findElement(By.cssSelector("ul[class='product_list grid row']"));		// needs this if there are spaces in className!
			dress = dress.findElement(By.partialLinkText("Printed Chiffon Dress"));
			dressTitle = dress.getAttribute("title");
			
			if (dressTitle.contains("Printed Chiffon Dress")) {
				test.log(LogStatus.PASS, "The 'Printed Chiffon Dress' was not found!");
			}
			
		} catch (NoSuchElementException e) {
			//Assert.fail("The 'Printed Chiffon Dress' was not found!");
			test.log(LogStatus.FAIL, "The 'Printed Chiffon Dress' was not found!");
			fail();
		}
		//Assert.assertNotNull(dress);
		//Assert.assertEquals("Printed Chiffon Dress not displayed", true, dressTitle.contains("Printed Chiffon Dress"));
	}

}