package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
  
	//les attributs pour stocker les instances de ISymptomReader et ISymptomWriter
	
    private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;
	
	
	// le constructeur qui va initialiser writer et reader
	
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.symptomReader = reader;
		this.symptomWriter = writer;
	}
	
	
	//methode pour recuperer la liste des symptoms à partir de reader
	
	public List<String> getSymptoms(){
	    return symptomReader.getSymptoms(); 
	}
	
	
	//méthode pour calculer les occurences de chaque symptome
	public Map<String, Integer> countSymptoms(List<String>symptoms){
		Map<String, Integer> symptomCount = new HashMap<>();
		
		for(String symptom : symptoms) {
			symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0)+1);
		}
	    return symptomCount;
	}
	
	
	//méthode pour trier les symptomes par ordre alphabetique
	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptoms) {
		
		//utilisation d'une treeMap pour un tri naturel des symptomes
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	
	
	//méthode pour ecrire les symptomes dans le fichier de sortie
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
	
	
	
} 
