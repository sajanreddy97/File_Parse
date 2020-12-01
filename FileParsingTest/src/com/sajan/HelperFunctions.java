package com.sajan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperFunctions {

    public static LinkedList<Map.Entry<String,Integer>> getSortedWordsList(StringBuilder fileData) {
        HashMap<String, Integer> countMap = new HashMap<>();
        String[] splitData = fileData.toString().toLowerCase().split("[^a-zA-Z0-9-]+");

        for (String s: splitData) {
            if (!countMap.containsKey(s)) {
                countMap.put(s,1);
            } else {
                countMap.replace(s,countMap.get(s) + 1);
            }
        }

        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(countMap.entrySet());
        list.sort(new EntryComparator());

        return list;
    }

    public static boolean checkForWord(String findWord, String sentence) {
        String pattern = "\\b"+findWord+"\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(sentence);
        return m.find();
    }
}
