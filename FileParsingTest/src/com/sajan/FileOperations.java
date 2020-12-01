package com.sajan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class FileOperations {

    public static StringBuilder readFileData(String fileName) {
    	StringBuilder stringBuilder = new StringBuilder();

        try {
            String fileData;
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(new BufferedReader(fileReader));

            while (scanner.hasNextLine()) {
                fileData = scanner.nextLine();
                stringBuilder.append(fileData);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }

        return stringBuilder;
    }

    public static void getTotalWords(StringBuilder fileData) {
    	if (fileData != null) { 
	        System.out.println("TOTAL WORDS IN FILE -> " + fileData.toString().split("[^a-zA-Z0-9-]+").length);
	    }
    }

    public static void getTopTenWords(StringBuilder fileData) {
    	
    	if (fileData != null) {
	        LinkedList<Map.Entry<String,Integer>> list = HelperFunctions.getSortedWordsList(fileData);
	
	        System.out.println("\n===== TOP 10 MOST USED WORDS IN FILE =====");
	
	        try {
	            for(int i=0; i<10; i++) {
	                System.out.println("Word "+ (i+1) + " -> " + list.get(i));
	            }
	        } catch (IndexOutOfBoundsException e) {
	            System.out.println("We only have " + list.size() + " unique words in the file.");
	        }
    	}
    }

    public static void getLastSentenceWithMostUsedWord(StringBuilder fileData) {
    	
    	if (fileData != null) {

	        LinkedList<Map.Entry<String, Integer>> list = HelperFunctions.getSortedWordsList(fileData);
	        Map.Entry<String, Integer> maxEntry = list.get(0);
	        String[] splitByPeriods = fileData.toString().split("(?<=[a-z])\\.\\s+");
	
	        for(int i=splitByPeriods.length - 1; i>0; i--) {
	            if (HelperFunctions.checkForWord(maxEntry.getKey(), splitByPeriods[i].toLowerCase())) {
	                if(i == splitByPeriods.length - 1) {
	                    System.out.println("\nLAST SENTENCE WITH MOST USED WORD -> " + splitByPeriods[i]);
	                    return;
	                }
	                System.out.println("\nLAST SENTENCE WITH MOST USED WORD -> " + splitByPeriods[i] + ".");
	                return;
	            }
	        }
    	}
    }
}
