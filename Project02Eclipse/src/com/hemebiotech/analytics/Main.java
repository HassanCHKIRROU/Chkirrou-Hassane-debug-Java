package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	

	public static void main(String[] args) {
		
		//création d'un objet ISymptomReader pour lire les données du fichier symptoms.txt
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		
		//création d'un objet ISymptomWriter pour écrire dans le fichier result.out
		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		//création d'une instance de AnalyticsCounter
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		//récuperer les symptomes
		List <String> symptoms = counter.getSymptoms();
		
		//compter les occurrences des symptomes
		Map <String, Integer> symptomCounts = counter.countSymptoms(symptoms);
		
		//trier les symptomes par ordre alphabetique
		Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);
		
		//écrire les resultats dans le fichier de sortie
		counter.writeSymptoms(sortedSymptoms);
		

	}

}
