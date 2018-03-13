package com.core.logPatternSearchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculation {

	public int testValue = 2;
	public String contents;
	
	public int returnValue(){
	return testValue;
}
	
	public String readFromFile() throws FileNotFoundException {
		
		Scanner fileIn = new Scanner(new File("C:/test.txt"));
		
		
		//File file = new File("/my/location");
		contents = fileIn.useDelimiter("\\Z").next();
		
		
		
		 	return contents;
		
	}
	
}
