package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {
	
	// Implementation of the writeSymptoms method
	@Override
	public void writeSymptoms(Map<String, Integer>symptoms) {
		
		
		// The name of the file in which to write the symptoms
		String myFile = "result.out";// pas besoin d extention
		
		
		// Write the symptoms to result.out file with the BufferedWriter
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))){
		
			
			// Browse the Map to add each symptom and its quantity
			for(Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				String line = entry.getKey()+": "+entry.getValue();
				writer.write(line);
				
				writer.newLine();    //Skip the line
			}
			System.out.println("The symptoms are written in "+myFile);
			
			
		}catch(IOException e) {
			e.printStackTrace();    //Error handling in case of writing error
		}
		
		
	}

	
}
