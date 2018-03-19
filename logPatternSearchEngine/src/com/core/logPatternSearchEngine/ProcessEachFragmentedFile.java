package com.core.logPatternSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ProcessEachFragmentedFile {

	public String lastLine, lineBeforeLast;
	public int linkCount = 0;
	public String path;
	// public String computer = "VAIO";
	public String computer = "EALIYIK";
	public float duration;
	public float totalDuration = 0;

	public void processEachFile() throws IOException {
		// setting correct path
		path = (computer == "VAIO") ? "C:\\Users\\VAIO\\Desktop\\JAVA\\" : "C:\\Users\\ealiyik\\Desktop\\JAVA\\";

		File dir = new File(path + "FragmantedFiles\\");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
				String path = child.toString();

				BufferedReader readFromFile = new BufferedReader(new FileReader(child));
				String line;
				while ((line = readFromFile.readLine()) != null) {
					// process the line.
					// if (oneLineFromFile.contains("time taken: ")) {
					// System.out.println( oneLineFromFile);
					// }
					lineBeforeLast = lastLine;
					lastLine = line;
					if (line.contains(" HTTP/1.1")) {
						linkCount++;
					}
				}

				// System.out.print(child + " has ");
				// System.out.print(linkCount);
				// System.out.println(" calls");s
				linkCount = 0;

				System.out.print(lineBeforeLast);
				// finding duration of testcase
				calculateDuration(lineBeforeLast);
			}
			System.out.println("Total duration " + (totalDuration / 60000) + " minutes");
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

	}

	public float calculateDuration(String lineBeforeLast) {

		String[] data = lineBeforeLast.split(" "); // --> bu bos gelebilir
		if (data.length > 3) {
			String durationString = data[data.length - 3]; // --> bu patlar?
			if (durationString.endsWith("ms,")) {
				durationString = durationString.substring(0, durationString.length() - 3);
				duration = Integer.parseInt((String) durationString);
				System.out.println(" " + duration / 1000 + "seconds");
				totalDuration += duration;
			}
		}
		return totalDuration;

	}

}
