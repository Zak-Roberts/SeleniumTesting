package com.cognizant.blackjackTests;

import org.junit.Assert;
import org.junit.Test;

public class InvalidTests {
	
	@Test
	public void p1Invalid() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("p1 not invalid!", 20, blackjack.play(32, 20));
	}
	
	@Test
	public void p2Invalid() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("p2 not invalid!", 20, blackjack.play(20, 32));
	}

	@Test
	public void bothInvalid() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("both not invalid!", 0, blackjack.play(32, 1));
	}
}
