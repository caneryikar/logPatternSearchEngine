package com.core.logPatternSearchEngine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PopulateStringArrays {

	public SegmentationOfFile populateStringArray() throws IOException {

		SegmentationOfFile segment = new SegmentationOfFile();

		// feeding StartOfTC array
		BufferedReader startOfTC = new BufferedReader(
		new FileReader("C:\\Users\\ealiyik\\Desktop\\JAVA\\" + "startOfTC" + ".txt"));

		String line = new String();
		while ((line = startOfTC.readLine()) != null) {

			segment.startOfTC.add(line); // doðru mu? gibi tamam deneyeyim
//			System.out.println(segment.startOfTC);
//			System.out.println("HP"+line);

		}
		startOfTC.close();

		// feeding EndOfTC array
		BufferedReader endOfTC = new BufferedReader(
		new FileReader("C:\\Users\\ealiyik\\Desktop\\JAVA\\" + "endOfTC" + ".txt"));

		String endLine = new String();
		while ((endLine = endOfTC.readLine()) != null) {

			segment.endOfTC.add(line);
//			System.out.println(segment.endOfTC);
//			System.out.println(endLine);

		}
		endOfTC.close();
return segment;
	}

}
