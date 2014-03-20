package com.devenops.anagrammer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author dnorton
 */
public class Anagrammer {

    public static List<List<String>> anagramsAsListOfLists(List<String> words) {
        HashMap<String, List<String>> anagramMap = anagramsAsMapOfLists(words);

        List<List<String>> anagrams = new ArrayList<List<String>>();

        //This is the bit I screwed up in my interview.
        for (List<String> anagram : anagramMap.values()) {
            anagrams.add(anagram);
        }

        return anagrams;


    }

    public static HashMap<String, List<String>> anagramsAsMapOfLists(List<String> words) {
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();

        for (String word : words) {
            String key = sort(word);
            List<String> anagram = anagrams.get(key);
            if (anagram == null) {
                anagram = new ArrayList<String>();
                anagram.add(word);
                anagrams.put(key, anagram);
            } else {
                anagram.add(word);
            }
        }

        return anagrams;
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
