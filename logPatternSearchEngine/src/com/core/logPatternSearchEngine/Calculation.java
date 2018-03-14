package com.core.logPatternSearchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculation {

	public int testValue = 2;
	public String characterCount;
	public String lineCount;

	public int returnValue() {
		return testValue;
	}

	public String readFromFile() throws FileNotFoundException {

		Scanner fileIn = new Scanner(new File("C:/test.txt"));
		Scanner fileIn2 = new Scanner(new File("C:/test.txt"));

		characterCount = fileIn.useDelimiter("\\Z").next();
//		lineCount = fileIn2.useDelimiter("\r").next();

		
		
		fileIn2.useDelimiter("[;\r\n]+");
	
		while (fileIn2.hasNext())
		{
			if(fileIn2.next()=="\r")
		  System.out.printf("%s%n", fileIn2.next());
		}
		//
		// while( fileIn2.hasNextLine())
		// {
		// lineCount ++ ;
		// System.out.println;
		// System.out.println("Line count: "+ lineCount);
		//
		// }
		//
		// while (lineCount.)
		// for (String item : sc2.nextLine().split(";"))
		// {
		// System.out.printf("%s%n", item);
		// }

		System.out.println("Character count: " + characterCount.length());
	//	System.out.println("Line count: " + lineCount.length());

		return characterCount;

	}

}
