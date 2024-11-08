package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ReadSymptomDataFromFile class is an implementation of ISymptomReader that reads symptoms data from a file (symptoms.txt).
 * This class reads each line of the specified file and stores it as a symptom in a list.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	/**
     * The path of the file from which symptoms will be read.
     */
	private String filePath;
	
	/**
     * Constructs a ReadSymptomDataFromFile with the specified file path .
     * 
     * @param filePath the path to (symptoms.txt)
     */
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	/**
     * Reads symptoms from the file specified by filePath.
     * Each line in the file represents one symptom, which is added to the result list.
     * 
     * @return a list of symptoms read from the file, or an empty list if an error occurs or if filePath is null
     */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			try {
				//read the symptoms from the filePath (symptoms.txt) with BufferedReader
				BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				
			//Error handling in case of reading error
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	return result;
	}

}
