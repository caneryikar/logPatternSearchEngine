package com.core.logPatternSearchEngine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
	
	private static SegmentationOfFile segment;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println(calculateCharCount());
		populateStringArrays();
		readFileLineByLine();
		startSegmentationOfFile();
		
	}

	
	
	
	
	
	
	
	
	
	public static void populateStringArrays() throws IOException {
		PopulateStringArrays populateArray = new PopulateStringArrays();
		segment = populateArray.populateStringArray();
		
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
	
	public static void startSegmentationOfFile() throws FileNotFoundException, UnsupportedEncodingException {
		SegmentationOfFile segment = new SegmentationOfFile();
		segment.segmentationOfFile(segment);
	}
	
	
}