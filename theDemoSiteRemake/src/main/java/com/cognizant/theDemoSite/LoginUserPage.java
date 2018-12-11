package com.cognizant.theDemoSite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUserPage {

	@FindBy (xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	WebElement usernameInput;
	
	@FindBy (xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	WebElement passwordInput;
	
	public void enterUser(String username, String password) throws InterruptedException {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		Thread.sleep(1000);
		passwordInput.submit();
	}
	
}
