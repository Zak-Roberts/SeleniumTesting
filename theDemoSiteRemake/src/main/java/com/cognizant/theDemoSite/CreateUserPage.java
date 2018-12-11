package com.cognizant.theDemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {

	@FindBy (xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	WebElement usernameBox;
	
	@FindBy (xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	WebElement passwordBox;
	
	public void createUser(String username, String password) throws InterruptedException {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		Thread.sleep(1000);
		passwordBox.submit();
	}
	
}
