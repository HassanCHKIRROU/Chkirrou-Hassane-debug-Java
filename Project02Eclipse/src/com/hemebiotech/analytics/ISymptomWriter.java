package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The ISymptomWriter interface defines a contract for writing symptom data in the file (result.out).
 * The implementation of this interface should provide a method to write a map of symptoms and their counts.
 */
public interface ISymptomWriter {
	
	/**
     * Writes the symptoms and their corresponding counts in the file (result.out).
     * 
     * @param symptoms a Map where the key is the symptom name (String) and the value is the count (Integer) 
     *                 of how many times that symptom was occurred.
     */
	
	void writeSymptoms(Map<String, Integer> symptoms);

}
