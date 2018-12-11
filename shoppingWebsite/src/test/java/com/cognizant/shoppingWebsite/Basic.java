package com.cognizant.shoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {

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

	@Test
	public void findChiffonDress() throws InterruptedException {
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
		} catch (NoSuchElementException e) {
			Assert.fail("The 'Printed Chiffon Dress' was not found!");
		}
		Assert.assertNotNull(dress);
		Assert.assertEquals("Printed Chiffon Dress not displayed", true, dressTitle.contains("Printed Chiffon Dress"));
	}

}
