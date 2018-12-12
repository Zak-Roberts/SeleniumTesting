package com.cognizant.phpTravels;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Basic {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	// creates user then tries to login as created user
	public void bookLondonHotel() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		List<WebElement> divs = driver.findElements(By.tagName("div"));

		Actions action = new Actions(driver);

		for (WebElement div : divs) {
			try {
				WebElement divInputs = div.findElement(By.tagName("input"));
				divInputs.sendKeys("London");
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB + "11/12/2018" + Keys.TAB).perform();
				Thread.sleep(1000);
				action.sendKeys("13/12/2018" + Keys.TAB).perform();
				Thread.sleep(1000);
				break;
			} catch (Exception e) {

			}
		}

		WebElement people = driver.findElement(By.id("travellersInput"));
		people.click();
		Thread.sleep(1000);
		WebElement peopleAdd = driver.findElement(By.xpath("//*[@id=\"adultPlusBtn\"]"));
		peopleAdd.click();
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));
		search.click();

		WebElement nextPage = driver
				.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[2]/ul/li[3]/a"));
		nextPage.click();
		Thread.sleep(1000);

		List<WebElement> searchResults = driver.findElements(By.tagName("div"));
		for (WebElement item : searchResults) {
			try {
				WebElement itemLinks = item.findElement(By.tagName("a"));
				if (itemLinks.getAttribute("title").equals("London")) {
					itemLinks.click();
				}
				break;
			} 
			catch (Exception e) {
			}
		}

	}

}