package com.cognizant.bingSearch;

import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FindingElementsScreenshot {

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
	public void bingSearch() throws InterruptedException, IOException {
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		BingLandingPage bingLandingPage = PageFactory.initElements(driver, BingLandingPage.class);
		//BingSearchedPage bingSearchedPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		bingLandingPage.searchBing("Selenium");
		
		//Assert.assertEquals("Selenium", bingSearchedPage.getSearch().getText());	
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(scrFile.getAbsolutePath());
		//copy(scrFile.getAbsolutePath(), "C:\\Users\\Admin\\Desktop\\AutomatedTesting\\Screenshots\\pic.png");
		copyApache(scrFile, "C:\\Users\\Admin\\Desktop\\AutomatedTesting\\Screenshots\\pic.png");
		Thread.sleep(60000);
		
	}
	
//	public void copy (String inFile, String outFile) throws IOException {
//		byte[] bytes = new byte[128];
//		FileInputStream fi = new FileInputStream(inFile);
//		FileOutputStream fo = new FileOutputStream(outFile);
//		int count = 0, read = 0;
//		while ((read = fi.read(bytes)) != 1 ) {
//			fo.write(bytes, 0, read);
//			count += read;
//		}
//		fi.close();
//		fo.close();
//	}
	
	public void copyApache (File scrFile, String outFile) throws IOException {
		FileUtils.copyFile(scrFile, new File(outFile));
	}
	
}
