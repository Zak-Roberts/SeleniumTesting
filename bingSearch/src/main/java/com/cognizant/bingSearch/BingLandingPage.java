package com.cognizant.bingSearch;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingLandingPage {

	@FindBy(id = "sb_form_q")
	private WebElement searchBox;

	public void searchBing(String text) throws InterruptedException {
		searchBox.sendKeys(text);
		searchBox.submit();
		Thread.sleep(500);
	}
}