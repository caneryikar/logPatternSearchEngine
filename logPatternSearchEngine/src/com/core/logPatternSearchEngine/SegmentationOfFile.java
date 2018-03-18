package com.core.logPatternSearchEngine;

//import java.awt.List; // This is problem
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;



public class SegmentationOfFile {

	public boolean startCopyingtoNewFile = false;

	
	
	//public java.util.List<String> endOfTC  = new ArrayList<String>() ;
	// public String startStartUpTC1 = "Running TestCase [Test Suite for
	// StartUp-TestCase 1]";
	// public String endStartUpTC1 = "Finished Running TestCase [Test Suite for
	// StartUp-TestCase 1]";

	public void segmentationOfFile(ArrayList<String> startOfTC, ArrayList<String> endOfTC) throws FileNotFoundException, UnsupportedEncodingException {
		
		

//		PrintWriter writer2 = new PrintWriter((new File("C:\\Users\\VAIO\\Desktop\\JAVA\\" + "mainHOP.txt")));
//		writer2.println(array1+"HACIDAYIIII");
//		writer2.close();
//		
		
		if(startOfTC.size()==endOfTC.size()) {
			
		
		System.out.println("startOfTC boyutu: "+startOfTC.size());
		System.out.println("endOfTC boyutu: "+endOfTC.size());
		int size = startOfTC.size();

		for (int i = 0; i < size; i++) {
//			System.out.println(i);
//			System.out.println(startOfTC.get(i));
//			System.out.println(endOfTC.get(i));
			// initializing new cropped file
			PrintWriter writer = new PrintWriter(
					(new File("C:\\Users\\VAIO\\Desktop\\JAVA\\FragmantedFiles\\" + startOfTC.get(i)  +".dat")),
					"UTF-8");

			try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\VAIO\\Desktop\\JAVA\\" + "croppedText.dat"))) {
				String line;

				while ((line = br.readLine()) != null) {
					// process the line.
//						System.out.println(line.length() + line);
					if (line.contains(startOfTC.get(i))) {
						System.out.println("Found Start of tests " + line);
						startCopyingtoNewFile = true;
					}
					if (startCopyingtoNewFile) {
//						System.out.println("Dosyaya yazýyor: "+ line);
						writer.println(line);
					}
					
					if (line.contains(endOfTC.get(i))) {
						if(line.contains("Finished"))
						{
								// System.out.println(line);
								System.out.println("Copy boolean is set 'False' ");
							startCopyingtoNewFile = false;
						}
					}
				}
				writer.close();
			}

			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
startCopyingtoNewFile = false;
		}
		}
		else {
			System.err.println("Length of startOfTC and endOfTC are not same");
		}
	}
}
