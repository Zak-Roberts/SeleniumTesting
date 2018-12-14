package com.cognizant.pokemonIdle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskOneFirstPage {
	
	@FindBy(id="Squirtle")
	private WebElement starter;
	
	@FindBy(id="startAdventure")
	private WebElement start;
	
	public void startAdventure() {
		starter.click();
		start.click();
	}

}
