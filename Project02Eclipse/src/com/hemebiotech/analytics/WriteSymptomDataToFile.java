package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The WriteSymptomDataToFile class is an implementation of ISymptomWriter that writes symptom data to a file.
 * This class takes a map of symptoms with their respective occurrence counts and writes them to an output file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/**
     * Writes the given map of symptoms and their occurrence counts to a file (result.out).
     * Each symptom is written on a new line in the format: "symptom : count".
     *
     * @param symptoms a map containing symptoms as keys and their occurrence counts as values
     */
	@Override
	public void writeSymptoms(Map<String, Integer>symptoms) {
		
		
		// The name of the file in which to write the symptoms
		String myFile = "result.out";
		
		// Write the symptoms to result.out file with the BufferedWriter
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))){
		
			// Browse the Map to add each symptom and its quantity
			for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				String line = "- "+entry.getKey()+": "+entry.getValue();
				writer.write(line);
				writer.newLine(); 
			}
			System.out.println("The symptoms are written in the file: "+"'"+myFile+"'");
			writer.close();
			
		//Error handling in case of writing error	
		}catch(IOException e) {
			e.printStackTrace();    
		}
		
	}
	
}
