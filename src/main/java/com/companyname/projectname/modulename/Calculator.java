package com.companyname.projectname.modulename;

public class Calculator { // Cntrol+Shift_F

	public static void main(String[] args) { // Stating point // JVM

		System.out.println("I am desigining calculator");

		additionOfTwoNumber(10, 7);
		subOfTwoNumber(10, 5);
		mulOfTwoNumber(3, 26);
		divOfTwoNumber(25, 5);
	}

	public static void additionOfTwoNumber(int a, int b) { // Method Or function

		int c = a + b; // Arith

		System.out.println("Addition of two numbers: " + c); // Conc
	}

	public static void subOfTwoNumber(int a, int b) { // Method Or function

		int c = a - b; // Arith

		System.out.println("subtraction of two numbers: " + c); // Conc
	}

	public static void mulOfTwoNumber(int a, int b) { // Method Or function

		// int c = a * b; // Arith

		System.out.println("multiplication of two numbers: " + (a * b)); // Conc
	}

	public static void divOfTwoNumber(int a, int b) { // Method Or function

		// int c = a * b; // Arith

		System.out.println("Div of two numbers: " + (a / b)); // Conc
	}
}
