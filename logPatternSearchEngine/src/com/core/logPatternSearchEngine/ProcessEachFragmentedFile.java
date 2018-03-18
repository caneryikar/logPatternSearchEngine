package com.core.logPatternSearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessEachFragmentedFile {

	public String lastLine, lineBeforeLast;
	public int linkCount = 0;

	public void processEachFile() throws IOException {

		File dir = new File("C:\\Users\\VAIO\\Desktop\\JAVA\\FragmantedFiles\\");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
				// time taken: 6205ms, status: FINISHED
				String path = child.toString();
				// System.out.println(path);
				// String line32 = Files.readAllLines(Paths.get(path)).get(32);
				// System.out.println(line32);
				BufferedReader readFromFile = new BufferedReader(new FileReader(child));
				String line;
				while ((line = readFromFile.readLine()) != null) {
					// process the line.
					// if (oneLineFromFile.contains("time taken: ")) {
					// System.out.println( oneLineFromFile);
					// }
					lineBeforeLast = lastLine;
					lastLine= line;
					if (line.contains(" HTTP/1.1")) {
						linkCount++;
					}
				}
				
				System.out.print(child+" has ");
				System.out.print(linkCount);
				System.out.println(" calls");
				System.out.println(lineBeforeLast);
				// System.out.println(lineBeforeLast);

				linkCount = 0;
			}
		} else {
			// Handle the case where dir is not really a directory.
			// Checking dir.isDirectory() above would not be sufficient
			// to avoid race conditions with another process that deletes
			// directories.
		}

	}

}
