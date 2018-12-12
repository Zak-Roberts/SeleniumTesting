package com.cognizant.blackjackTests;

public class Blackjack {

	public int play(int a, int b) {

		int result = 0;
		
		if (b > a && b <= 21 && b>1) {
			result = b;
		}
		else if (a > b && a <= 21 && a>1) {
			result = a;
		}
		else if (a > 21 && b <= 21 && b>1) {
			result = b;
		}
		else if (b > 21 && a <= 21 && a>1) {
			result = a;
		}
		else if (b > 21 && a > 21) {
			result = 0;
		}
		else if(a<2 || b<2 || a>31 || b>32) {
			result = 0;
		}
		return result;
	}

}
