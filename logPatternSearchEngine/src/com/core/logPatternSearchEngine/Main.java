package com.core.logPatternSearchEngine;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld");

		// System.out.print(returnValueFromAnotherClass());
		System.out.print(returnValueFromFile());

	}

	public static int returnValueFromAnotherClass() {
		Calculation calc = new Calculation();
		return calc.returnValue();
	}

	public static String returnValueFromFile() throws FileNotFoundException {
		Calculation calcFile = new Calculation();
		return calcFile.readFromFile();
	}
}