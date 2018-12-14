package com.cognizant.pokemonIdle;

import org.junit.runner.JUnitCore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		start();
		driver.quit();
	}
	
	public static void start() {
		JUnitCore.runClasses(TaskOnePOM.class, TaskTwo.class);
	}
	
}