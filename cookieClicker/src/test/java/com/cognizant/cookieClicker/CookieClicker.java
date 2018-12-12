package com.cognizant.cookieClicker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CookieClicker {

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
	public void clickCookies() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("http://orteil.dashnet.org/cookieclicker/");
		Thread.sleep(2000);

		while (true) {
			WebElement cookie = driver.findElement(By.id("bigCookie"));
			cookie.click();

			if (driver.findElements(By.id("upgrade0")).size() != 0
					&& driver.findElement(By.id("upgrade0")).getAttribute("class").equals("crate upgrade enabled")) {
				driver.findElement(By.id("upgrade0")).click();
			}
			
			if (!driver.findElement(By.id("shimmers")).getAttribute("class").equals("")) {
				driver.findElement(By.id("shimmers")).click();
			}

			WebElement product0 = driver.findElement(By.xpath("//*[@id=\"product0\"]"));
			WebElement product0Owned = driver.findElement(By.id("productOwned0"));

			WebElement product1 = driver.findElement(By.xpath("//*[@id=\"product1\"]"));
			WebElement product1Owned = driver.findElement(By.id("productOwned1"));

			WebElement product2 = driver.findElement(By.xpath("//*[@id=\"product2\"]"));
			WebElement product2Owned = driver.findElement(By.id("productOwned2"));

			WebElement product3 = driver.findElement(By.xpath("//*[@id=\"product3\"]"));
			WebElement product3Owned = driver.findElement(By.id("productOwned3"));

			WebElement product4 = driver.findElement(By.xpath("//*[@id=\"product4\"]"));
			WebElement product4Owned = driver.findElement(By.id("productOwned4"));

			WebElement product5 = driver.findElement(By.xpath("//*[@id=\"product5\"]"));
			WebElement product5Owned = driver.findElement(By.id("productOwned5"));

			WebElement product6 = driver.findElement(By.xpath("//*[@id=\"product6\"]"));
			WebElement product6Owned = driver.findElement(By.id("productOwned6"));
			
			WebElement product7 = driver.findElement(By.xpath("//*[@id=\"product7\"]"));
			WebElement product7Owned = driver.findElement(By.id("productOwned7"));
			
			WebElement product8 = driver.findElement(By.xpath("//*[@id=\"product8\"]"));
			WebElement product8Owned = driver.findElement(By.id("productOwned8"));
			
			WebElement product9 = driver.findElement(By.xpath("//*[@id=\"product9\"]"));
			WebElement product9Owned = driver.findElement(By.id("productOwned9"));
			
			WebElement product10 = driver.findElement(By.xpath("//*[@id=\"product10\"]"));
			WebElement product10Owned = driver.findElement(By.id("productOwned10"));
			
			WebElement product11 = driver.findElement(By.xpath("//*[@id=\"product11\"]"));
			WebElement product11Owned = driver.findElement(By.id("productOwned11"));
			
			WebElement product12 = driver.findElement(By.xpath("//*[@id=\"product12\"]"));
			WebElement product12Owned = driver.findElement(By.id("productOwned12"));
			
			WebElement product13 = driver.findElement(By.xpath("//*[@id=\"product13\"]"));
			WebElement product13Owned = driver.findElement(By.id("productOwned13"));
			
			WebElement product14 = driver.findElement(By.xpath("//*[@id=\"product14\"]"));
			WebElement product14Owned = driver.findElement(By.id("productOwned14"));
			
			WebElement product15 = driver.findElement(By.xpath("//*[@id=\"product15\"]"));
			WebElement product15Owned = driver.findElement(By.id("productOwned15"));

			if (product0.getAttribute("class").equals("product unlocked enabled")) {
				if (product0Owned.getText().equals("")) {
					product0.click();
				} else if (Integer.parseInt(product0Owned.getText()) < 10) {
					product0.click();
				}
			}

			if (product1.getAttribute("class").equals("product unlocked enabled")) {
				if (product1Owned.getText().equals("")) {
					product1.click();
				} else if (Integer.parseInt(product1Owned.getText()) < 10) {
					product1.click();
				}
			}

			if (product2.getAttribute("class").equals("product unlocked enabled")) {
				if (product2Owned.getText().equals("")) {
					product2.click();
				} else if (Integer.parseInt(product2Owned.getText()) < 10) {
					product2.click();
				}
			}

			if (product3.getAttribute("class").equals("product unlocked enabled")) {
				if (product3Owned.getText().equals("")) {
					product3.click();
				} else if (Integer.parseInt(product3Owned.getText()) < 10) {
					product3.click();
				}
			}
			
			if (product4.getAttribute("class").equals("product unlocked enabled")) {
				if (product4Owned.getText().equals("")) {
					product4.click();
				} else if (Integer.parseInt(product4Owned.getText()) < 10) {
					product4.click();
				}
			}
			
			if (product5.getAttribute("class").equals("product unlocked enabled")) {
				if (product5Owned.getText().equals("")) {
					product5.click();
				} else if (Integer.parseInt(product5Owned.getText()) < 10) {
					product5.click();
				}
			}
			
			if (product6.getAttribute("class").equals("product unlocked enabled")) {
				if (product6Owned.getText().equals("")) {
					product6.click();
				} else if (Integer.parseInt(product6Owned.getText()) < 10) {
					product6.click();
				}
			}
			
			if (product7.getAttribute("class").equals("product unlocked enabled")) {
				if (product7Owned.getText().equals("")) {
					product7.click();
				} else if (Integer.parseInt(product7Owned.getText()) < 10) {
					product7.click();
				}
			}
			
			if (product8.getAttribute("class").equals("product unlocked enabled")) {
				if (product8Owned.getText().equals("")) {
					product8.click();
				} else if (Integer.parseInt(product8Owned.getText()) < 10) {
					product8.click();
				}
			}
			
			if (product9.getAttribute("class").equals("product unlocked enabled")) {
				if (product9Owned.getText().equals("")) {
					product9.click();
				} else if (Integer.parseInt(product9Owned.getText()) < 10) {
					product9.click();
				}
			}
			
			if (product10.getAttribute("class").equals("product unlocked enabled")) {
				if (product10Owned.getText().equals("")) {
					product10.click();
				} else if (Integer.parseInt(product10Owned.getText()) < 10) {
					product10.click();
				}
			}
			
			if (product11.getAttribute("class").equals("product unlocked enabled")) {
				if (product11Owned.getText().equals("")) {
					product11.click();
				} else if (Integer.parseInt(product11Owned.getText()) < 10) {
					product11.click();
				}
			}
			
			if (product12.getAttribute("class").equals("product unlocked enabled")) {
				if (product12Owned.getText().equals("")) {
					product12.click();
				} else if (Integer.parseInt(product12Owned.getText()) < 10) {
					product12.click();
				}
			}
			
			if (product13.getAttribute("class").equals("product unlocked enabled")) {
				if (product13Owned.getText().equals("")) {
					product13.click();
				} else if (Integer.parseInt(product13Owned.getText()) < 10) {
					product13.click();
				}
			}
			
			if (product13.getAttribute("class").equals("product unlocked enabled")) {
				if (product13Owned.getText().equals("")) {
					product13.click();
				} else if (Integer.parseInt(product13Owned.getText()) < 10) {
					product13.click();
				}
			}
			
			if (product14.getAttribute("class").equals("product unlocked enabled")) {
				if (product14Owned.getText().equals("")) {
					product14.click();
				} else if (Integer.parseInt(product14Owned.getText()) < 10) {
					product14.click();
				}
			}
			
			if (product15.getAttribute("class").equals("product unlocked enabled")) {
				if (product15Owned.getText().equals("")) {
					product15.click();
				} else if (Integer.parseInt(product15Owned.getText()) < 10) {
					product15.click();
				}
			}

		}
	}

}

// @FindAll - OR
// @FindBys - AND, need to be in object
// eg. @FindBys({
// @FindBy ...
// @FindBy ...
// })

// id = shimmers != "" -> then click
