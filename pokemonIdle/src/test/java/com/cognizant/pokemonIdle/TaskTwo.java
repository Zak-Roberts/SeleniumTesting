package com.cognizant.pokemonIdle;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TaskTwo {

	WebDriver driver = TestRunner.driver;

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void TaskTwoTest() throws InterruptedException {

		while (!driver.findElement(By.id("currentRoute")).getText().contains("10/10")) {
			driver.findElement(By.id("enemyInfo")).click();
		}
		
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("document.getElementById(\"rightColumn\").removeChild(document.getElementById(\"oakModal\"));");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("document.body.removeChild(document.getElementsByClassName(\"modal-backdrop fade in\")[0]);");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id=\"route_2\"]")).click();
		Thread.sleep(3000);
		
	}

}