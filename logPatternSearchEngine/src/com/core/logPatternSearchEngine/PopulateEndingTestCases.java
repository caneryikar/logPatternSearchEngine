package com.core.logPatternSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PopulateEndingTestCases {

	public ArrayList<String> endOfTC = new ArrayList<String>();

	public ArrayList<String> populateStringArray() throws IOException {
		PrintWriter writer = new PrintWriter((new File("C:\\Users\\VAIO\\Desktop\\JAVA\\" + "endhop.txt")));
		// feeding endOfTC array
		BufferedReader readFromFile = new BufferedReader(new FileReader("C:\\Users\\VAIO\\Desktop\\JAVA\\" + "endOfTC" + ".txt"));
		String oneLineFromFile = new String();

		while ((oneLineFromFile = readFromFile.readLine()) != null) {
			endOfTC.add(oneLineFromFile);
		}
		writer.println(endOfTC);
		readFromFile.close();
		writer.close();
//		System.out.println(endOfTC.size());
		return endOfTC;
	}

}
