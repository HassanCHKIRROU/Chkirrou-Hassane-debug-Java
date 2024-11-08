package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The Main class serves as the entry point for the application.
 */
public class Main {
	
    
	public static void main(String[] args) {
		
		//creating an ISymptomReader object to read data from the symptoms.txt file
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		
		//creating an ISymptomWriter object to write in the result.out file
		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		//creating an instance of AnalyticsCounter
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		//recover symptoms
		List <String> symptoms = counter.getSymptoms();
		
		//count the occurrences of symptoms
		Map <String, Integer> symptomCounts = counter.countSymptoms(symptoms);
		
		//sort symptoms alphabetically
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);
		
		//write results in the output file
		counter.writeSymptoms(sortedSymptoms);
	
	}

}
