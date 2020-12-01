package com.sajan;
import static com.sajan.FileOperations.getLastSentenceWithMostUsedWord;
import static com.sajan.FileOperations.getTopTenWords;
import static com.sajan.FileOperations.getTotalWords;
import static com.sajan.FileOperations.readFileData;

public class Main {

    public static void main(String[] args) {
        StringBuilder fileData = readFileData("passage.txt");
        getTotalWords(fileData);
        getTopTenWords(fileData);
        getLastSentenceWithMostUsedWord(fileData);
    }

}
