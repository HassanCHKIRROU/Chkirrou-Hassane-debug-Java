package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	
	// the constructor that will initialize the filePath
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	// Implementation of the retrieve symptoms method
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
