package com.sajan;

public class Main {

    public static void main(String[] args) {
        StringBuilder fileData = FileOperations.readFileData("passage.txt");
        FileOperations.getTotalWords(fileData);
        FileOperations.getTopTenWords(fileData);
        FileOperations.getLastSentenceWithMostUsedWord(fileData);
    }

}
