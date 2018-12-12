package com.cognizant.testingSite;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingSite {

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
	public void findIHateYouSleep() throws InterruptedException {

		driver.get("https://christophperrins.github.io/TestingSite/");
		Thread.sleep(6000);
		WebElement header = driver.findElement(By.xpath("//*[@id=\"quote\"]/h1"));

		assertEquals("not equal to 'I HATE YOU!'", "I HATE YOU!", header.getText());
	}

	@Test
	public void findIHateYouImplicit() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://christophperrins.github.io/TestingSite/");
		boolean header1 = driver.findElement(By.tagName("h1")).isDisplayed();

		try {
			WebElement header = null;
			if (header1) {
				header = driver.findElement(By.tagName("h1"));
			}
			assertEquals("not equal to 'I HATE YOU!'", "I HATE YOU!", header.getText());
		}
		catch (NullPointerException e) {

		}
	}

	@Test
	public void findIHateYouExplicit() throws InterruptedException {
		driver.get("https://christophperrins.github.io/TestingSite/");
		boolean header1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1"))).isDisplayed();
		try {
			WebElement header = null;
			if (header1) {
				header = driver.findElement(By.tagName("h1"));
			}
			assertEquals("not equal to 'I HATE YOU!'", "I HATE YOU!", header.getText());
		}
		catch (NullPointerException e) {

		}

	}
}
