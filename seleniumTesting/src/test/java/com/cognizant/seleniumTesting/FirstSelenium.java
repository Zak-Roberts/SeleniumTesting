package com.cognizant.seleniumTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	// @Test
	// public void seleniumTest() {
	// driver.manage().window().maximize();
	// driver.get("https://github.com/");
	// }

	@Test
	public void gettingElements() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		Thread.sleep(1000);
		textbox.sendKeys("puppy");
		Thread.sleep(1000);
		textbox.submit();
		Thread.sleep(1000);
		WebElement images = driver.findElement(By.linkText("Images"));
		images.click();
	}

	@Test
	public void getElements() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		Thread.sleep(1000);
		textbox.sendKeys("Selenium");
		Thread.sleep(1000);
		textbox.submit();
		WebElement selenium = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		assertEquals("Selenium not displayed", true, selenium.isDisplayed());
	}

//	@Before		// runs before every test
//	public void setup() {		// naming convention
//		System.out.println("Before");
//	}
//
//	@After		// runs after every test
//	public void teardown() {	// naming convention
//		System.out.println("After");
//	}
//
//	@Test
//	public void test1() {
//		System.out.println("Test 1");
//	}
//
//	@Test
//	public void test2() {
//		System.out.println("Test 2");
//	}
//	
//	@BeforeClass		// runs at start of execution
//	public static void initial() {
//		System.out.println("First");
//	}
//	
//	@AfterClass			// runs at end of execution
//	public static void end() {
//		System.out.println("Last");
//	}
	
}

// can find elements by (in best order):
// id
// xPath - right click on element -> copy XPath (works when can't use id or name
// or tags, highly unlikely for elements to have same XPath)
// className
// name
// linkText (text associated with anchor link)
// tagName
// partialLinkText(partial of above) - responds with first instance that
// appears!
// (can chain these eg. findElement(By.tagName("").findElement(By.name(""))