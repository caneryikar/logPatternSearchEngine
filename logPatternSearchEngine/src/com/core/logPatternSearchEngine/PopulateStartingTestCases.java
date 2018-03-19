package com.core.logPatternSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PopulateStartingTestCases {

	public String path;
	// public String computer = "VAIO";
	public String computer = "EALIYIK";
	
	
	
	public ArrayList<String> startOfTC = new ArrayList<String>();

	public ArrayList<String> populateStringArray() throws IOException {
//		setting correct path
		path = (computer == "VAIO") ? "C:\\Users\\VAIO\\Desktop\\JAVA\\" : "C:\\Users\\ealiyik\\Desktop\\JAVA\\";

		//PrintWriter writer = new PrintWriter((new File(path + "hop.txt")));
		// feeding StartOfTC array
		BufferedReader readFromFile = new BufferedReader(new FileReader(path + "startOfTC" + ".txt"));
		String oneLineFromFile = new String();

		while ((oneLineFromFile = readFromFile.readLine()) != null) {
			startOfTC.add(oneLineFromFile);
		}
//		writer.println(startOfTC);
		readFromFile.close();
//		writer.close();
//		System.out.println(startOfTC.size());
		return startOfTC;
	}

}
