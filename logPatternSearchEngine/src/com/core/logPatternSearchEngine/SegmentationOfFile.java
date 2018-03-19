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
	public String path;
	// public String computer = "VAIO";
	public String computer = "EALIYIK";

	public void segmentationOfFile(ArrayList<String> startOfTC, ArrayList<String> endOfTC)
			throws FileNotFoundException, UnsupportedEncodingException {
		// setting up correct path
		path = (computer == "VAIO") ? "C:\\Users\\VAIO\\Desktop\\JAVA\\" : "C:\\Users\\ealiyik\\Desktop\\JAVA\\";

		int a = startOfTC.size();
		int b = endOfTC.size();

		if (a == b) {
			System.out.println("startOfTC boyutu: " + startOfTC.size());
			System.out.println("endOfTC boyutu: " + endOfTC.size());
			int size = startOfTC.size();

			for (int i = 0; i < size; i++) {
				// initializing new cropped file
				PrintWriter writer = new PrintWriter(
						(new File(path+"FragmantedFiles\\" + startOfTC.get(i) + ".dat")),
						"UTF-8");

				try (BufferedReader br = new BufferedReader(
						new FileReader(path + "croppedText.dat"))) {
					String line;

					while ((line = br.readLine()) != null) {
						// process the line.
						if (line.contains(startOfTC.get(i))) {
							if (!line.contains("Finished"))
								System.out.println("Found Start of tests " + line);
							startCopyingtoNewFile = true;
						}
						if (startCopyingtoNewFile) {
							writer.println(line);
						}

						if (line.contains(endOfTC.get(i))) {
							if (line.contains("Finished")) {
								System.out.println("Found End of tests   " + line);
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
		} else {
			System.err.println("Length of startOfTC and endOfTC are not same");
		}
	}
}
