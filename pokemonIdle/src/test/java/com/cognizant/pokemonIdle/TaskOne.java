package com.cognizant.pokemonIdle;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskOne {
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@Test
	public void TaskOneTest() throws InterruptedException {
		
		WebDriver driver = TestRunner.driver;
		driver.get("http://ishadijcks.github.io/");
		Thread.sleep(1000);
		driver.findElement(By.id("Squirtle")).click();
		driver.findElement(By.id("startAdventure")).click();
		
	}
	
}
