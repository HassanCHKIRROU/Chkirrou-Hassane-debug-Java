package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class is responsible for :
 * -reading symptoms.
 * -counting occurrences. 
 * -sorting them alphabetically.
 * -writing the results in the file (result.out).
 */

public class AnalyticsCounter {
	
	/**
     * Stores an instance of ISymptomReader to retrieve symptoms data.
     */
	private ISymptomReader symptomReader;
	
	/**
     * Stores an instance of ISymptomWriter to write symptoms data.
     */
	private ISymptomWriter symptomWriter;
	
	
	/**
     * Constructs an AnalyticsCounter with the specified reader and writer.
     * 
     * @param reader the ISymptomReader used to read symptoms
     * @param writer the ISymptomWriter used to write symptoms
     */
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}
	
	
	/**
     * Method retrieves the list of symptoms from the reader.
     * 
     * @return a list of symptoms as strings
     */
	public List<String> getSymptoms(){
	    return symptomReader.getSymptoms(); 
	}
	
	
	/**
     * Method calculates the occurrences of each symptom.
     * 
     * @param symptoms a list of symptoms to count
     * @return a map containing each symptom and its occurrence count
     */
	public Map<String, Integer> countSymptoms(List<String>symptoms){
		Map<String, Integer> symptomCount = new HashMap<>();
		
		for(String symptom : symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0)+1);
		}
	    return symptomCount;
	}
	
	
	/**
     * Method sorts symptoms alphabetically.
     * 
     * @param symptoms a map of symptoms with their occurrence count
     * @return a map of symptoms sorted alphabetically
     */
	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptoms) {
		
		//using a treeMap for natural sorting of symptoms
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	
	
	/**
     * Method writes the symptoms and their occurrences to an output file.
     * 
     * @param symptoms a map of symptoms and their occurrence count to write
     */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	} 
	
} 
