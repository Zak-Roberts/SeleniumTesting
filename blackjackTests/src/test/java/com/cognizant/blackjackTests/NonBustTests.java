package com.cognizant.blackjackTests;

import org.junit.Assert;
import org.junit.Test;

public class NonBustTests {

	@Test
	public void p1Won() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("p1 not won!", 20, blackjack.play(20, 18));
	}
	
	@Test
	public void p2Won() {
		Blackjack blackjack = new Blackjack();
		Assert.assertEquals("p2 not won!", 20, blackjack.play(18, 20));
	}
	
}
