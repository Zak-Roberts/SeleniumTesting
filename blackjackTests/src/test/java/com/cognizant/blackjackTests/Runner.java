package com.cognizant.blackjackTests;

import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
	public static void main(String[] args) {
		Runner runner = new Runner();
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
//		if (input == 1) {
//			System.out.println("-RUNNING ALL TEST SUITES");
//			runner.allSuites();
//		}
		if (input == 2) {
			System.out.println("-RUNNING ALL VALID TEST SUITES");
			runner.validSuite();
		}
		if (input == 3) {
			System.out.println("-RUNNING ALL INVALID TEST SUITES");
			runner.bustedSuite();
		}
	}

	public void resultLoop(Result result) {
		System.out.println("--Displaying Failures");
		if (!result.wasSuccessful()) {
			for (Failure failure : result.getFailures()) {
				System.out.println("---" + failure.getTestHeader() + " :: " + failure.getMessage());
			}
		}
	}

	public void allSuites() {
		Result result = JUnitCore.runClasses(ValidSuite.class, InvalidSuite.class);
		resultLoop(result);
	}

	public void validSuite() {
		Result result = JUnitCore.runClasses(ValidSuite.class);
		resultLoop(result);
	}

	public void bustedSuite() {
		Result result = JUnitCore.runClasses(InvalidSuite.class);
		resultLoop(result);
	}
}