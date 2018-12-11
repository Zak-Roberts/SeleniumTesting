package com.cognizant.bingSearch;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchedPage {

	@FindBy (xpath="//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	WebElement headerText;
	
	public WebElement getSearch() {
		return headerText;
	}
	
}
