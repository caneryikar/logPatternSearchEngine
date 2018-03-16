package com.core.logPatternSearchEngine;

import java.awt.List; // This is problem
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;



public class SegmentationOfFile {

	public int lineNumber = 0;
	public boolean startCopyingtoNewFile = false;

	
	
	public java.util.List<String> startOfTC = new ArrayList<String>() ;
	public java.util.List<String> endOfTC  = new ArrayList<String>() ;
	// public String startStartUpTC1 = "Running TestCase [Test Suite for
	// StartUp-TestCase 1]";
	// public String endStartUpTC1 = "Finished Running TestCase [Test Suite for
	// StartUp-TestCase 1]";

	public void segmentationOfFile(SegmentationOfFile segment) throws FileNotFoundException, UnsupportedEncodingException {

		int size = startOfTC.size();
		System.out.println("SIZE" + size);
		System.out.println(startOfTC);

		for (int i = 0; i < size; i++) {
			System.out.println(startOfTC.get(i));
			System.out.println(endOfTC.get(i));
			// initializing new cropped file
			PrintWriter writer = new PrintWriter(
					(new File("C:\\Users\\ealiyik\\Desktop\\JAVA\\" + startOfTC.get(i)  +".dat")),
					"UTF-8");

			try (BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\ealiyik\\Desktop\\JAVA\\" + "croppedText.dat"))) {
				String line;

				while ((line = br.readLine()) != null) {
					// process the line.

					lineNumber++;

					if (line.contains(startOfTC.get(i))) {
						System.out.println("Found Start of tests " + line);
						startCopyingtoNewFile = true;
					}
					if (startCopyingtoNewFile) {
						writer.println(line);
					}
					if (line.contains(endOfTC.get(i))) {
						System.out.println("Copy boolean is set 'False' ");
						startCopyingtoNewFile = false;
						writer.close();
					}

				}
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
}
