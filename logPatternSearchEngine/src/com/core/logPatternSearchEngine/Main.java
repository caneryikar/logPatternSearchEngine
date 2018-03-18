package com.core.logPatternSearchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	private static ArrayList<String> array1, array2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// System.out.println(calculateCharCount());
		// array= populateStringArrays();
		// System.out.println(array.size());
		// readFileLineByLine();

		 
//		array1= populateStartingStringArrays();
//		array2= populateStartingStringArrays();
//		readFileLineByLine();
//		 startSegmentationOfFile(array1,array2);
		 processEachFile();




	}

	public static ArrayList<String> populateStartingStringArrays() throws IOException {
		PopulateStartingTestCases populateStartingArray = new PopulateStartingTestCases();
		return populateStartingArray.populateStringArray();

	}

	public static ArrayList<String> populateEndingStringArrays() throws IOException {
		PopulateEndingTestCases populateEndingArray = new PopulateEndingTestCases();
		return populateEndingArray.populateStringArray();

	}

	public static int calculateCharCount() throws FileNotFoundException {
		Calculation calcFile = new Calculation();
		return calcFile.calculateCharCount();
	}

	public static void readFileLineByLine() throws FileNotFoundException {
		Calculation readLine = new Calculation();
		try {
			readLine.readLineByLine();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void startSegmentationOfFile(ArrayList<String> string1, ArrayList<String> string2)
			throws FileNotFoundException, UnsupportedEncodingException {
		SegmentationOfFile segment = new SegmentationOfFile();
		segment.segmentationOfFile(string1,string2);
	}
	
	public static void processEachFile() throws IOException {
		ProcessEachFragmentedFile processEach = new ProcessEachFragmentedFile();
		processEach.processEachFile();
	}

}