package com.core.logPatternSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculation {

	public String wholeFileContents;
	public int characterCount;
	public int lineNumber = 0;
	public String testStart = "[SoapUITest.java:54] Running tests in the project [Ericsson Retail Management System]";
	public boolean startCopyingtoNewFile = false;

	public int calculateCharCount() throws FileNotFoundException {

		Scanner fileIn = new Scanner(new File("C:/test.txt"));
		wholeFileContents = fileIn.useDelimiter("\\Z").next();
		characterCount = 2 + wholeFileContents.length();
		System.out.println("Character count: " + characterCount);
		return characterCount;
	}

	public void readLineByLine() throws FileNotFoundException, UnsupportedEncodingException {

		// initializing new cropped file
		PrintWriter writer = new PrintWriter((new File("C:\\Users\\ealiyik\\Desktop\\JAVA\\" + "croppedText.dat")),
				"UTF-8");

		try (BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\ealiyik\\Desktop\\JAVA\\" + "consoleText.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				// process the line.

				lineNumber++;
//				if (lineNumber % 10000 == 0) {
//					System.out.println("Line Number = " + lineNumber + "   Line content = " + line);
//				}

				if (line.contains(testStart)) {
					System.out.println("Found Start of tests " + line);
					startCopyingtoNewFile = true;
				}
				if (startCopyingtoNewFile) {

					writer.println(line);

				}

			}
			System.out.println("Copy boolean is set 'False' ");
			startCopyingtoNewFile = false;
			writer.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	

}
