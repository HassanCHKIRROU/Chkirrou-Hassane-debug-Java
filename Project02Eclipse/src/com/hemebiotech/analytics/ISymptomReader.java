package com.hemebiotech.analytics;

import java.util.List;

/**
 * The ISymptomReader interface defines a contract for reading symptom data.
 * The implementation of this interface provide a way to retrieve a list of symptoms .
 */
public interface ISymptomReader {
	
	
	/**
     * Retrieves a list of symptoms from a data source (symptoms.txt).
     * 
     * @return a List of Strings, where each String represents a symptom. 
     *         
     */
	List<String> getSymptoms ();
	
}
