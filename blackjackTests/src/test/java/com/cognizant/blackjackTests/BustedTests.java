package com.cognizant.blackjackTests;

import org.junit.Assert;
import org.junit.Test;

public class BustedTests {

	@Test
	public void p1Bust() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("p1 not bust!", 20, blackjack.play(24, 20));
	}
	
	@Test
	public void p2Bust() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("p2 not bust!", 20, blackjack.play(20, 24));
	}
	
}
