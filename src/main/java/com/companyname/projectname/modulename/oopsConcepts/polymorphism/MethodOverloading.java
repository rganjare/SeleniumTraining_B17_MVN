package com.companyname.projectname.modulename.oopsConcepts.polymorphism;

public class MethodOverloading {

	// Static binding Or Compile time polymorphism Or early binding
	// Method with same name and same arg but with different data types
	// Method with same name and different parameters

	public static void main(String[] args) {

		addition(10, 15);
		addition(4, 5, 10);
		addition(24, "BYMAT");
		addition(23, 24.1212);
		addition();
	}

	public static void addition() {

		System.out.println("Addition of 2 number: " + (35 + 45));
	}
	
	public static void addition(int a, int b, int c) {

		System.out.println("Addition of 2 number: " + (a + b + c));
	}

	public static void addition(int a, int b) {

		System.out.println("Addition of 2 number: " + (a + b));
	}

	public static void addition(int a, double b) {

		System.out.println("Addition of 2 number: " + (a + b));
	}

	public static void addition(int a, String b) {

		System.out.println(a);
		System.out.println(b);
	}
	
}
