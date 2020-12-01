package com.sajan;
import static com.sajan.FileOperations.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder fileData = readFileData("passage.txt");
        if (fileData.length() != 0) {
            getTotalWords(fileData);
            getTopTenWords(fileData);
            getLastSentenceWithMostUsedWord(fileData);
        }
    }

}
