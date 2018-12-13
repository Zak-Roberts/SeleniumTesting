package com.cognizant.theDemoSite;

import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
	public static void main(String[] args) {
		Runner runner = new Runner();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter test number (5 to run all): ");
		int input = scanner.nextInt();
		if (input == 1) {
			System.out.println("-RUNNING TEST 1 TESTS");
			runner.test1();
		}
		if (input == 2) {
			System.out.println("-RUNNING TEST 2 TESTS");
			runner.test2();
		}
		if (input == 3) {
			System.out.println("-RUNNING TEST 3 TESTS");
			runner.test3();
		}
		if (input == 4) {
			System.out.println("-RUNNING TEST 4 TESTS");
			runner.test4();
		}
		
		if (input == 5) {
			System.out.println("-RUNNING ALL TESTS");
			runner.allTests();
		}
		
		scanner.close();
	}

	public void resultLoop(Result result) {
		System.out.println("--Displaying Failures");
		if (!result.wasSuccessful()) {
			for (Failure failure : result.getFailures()) {
				System.out.println("---" + failure.getTestHeader() + " :: " + failure.getMessage());
			}
		}
	}

	public void test1() {
		Result result = JUnitCore.runClasses(Test1Suite.class);
		resultLoop(result);
	}

	public void test2() {
		Result result = JUnitCore.runClasses(Test2Suite.class);
		resultLoop(result);
	}

	public void test3() {
		Result result = JUnitCore.runClasses(Test3Suite.class);
		resultLoop(result);
	}
	
	public void test4() {
		Result result = JUnitCore.runClasses(Test4Suite.class);
		resultLoop(result);
	}
	
	public void allTests() {
		Result result = JUnitCore.runClasses(Test1Suite.class, Test2Suite.class, Test3Suite.class, Test4Suite.class);
		resultLoop(result);
	}
	
}