package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
    //attributes to store instances of ISymptomReader and ISymptomWriter
	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	
	
	// the constructor that will initialize writer and reader
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}
	
	
	//method to retrieve list of symptoms from reader
	public List<String> getSymptoms(){
	    return symptomReader.getSymptoms(); 
	}
	
	
	//method for calculating the occurrences of each symptom
	public Map<String, Integer> countSymptoms(List<String>symptoms){
		Map<String, Integer> symptomCount = new HashMap<>();
		
		for(String symptom : symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0)+1);
		}
	    return symptomCount;
	}
	
	
	//method for sorting symptoms alphabetically
	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptoms) {
		
		//using a treeMap for natural sorting of symptoms
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	
	
	//method to write symptoms to output file
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	} 
	
} 
