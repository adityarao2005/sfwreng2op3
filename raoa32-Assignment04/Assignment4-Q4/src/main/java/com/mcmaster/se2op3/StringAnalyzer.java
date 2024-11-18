package com.mcmaster.se2op3;

import java.util.HashMap;
import java.util.Map;

public class StringAnalyzer {
    private String text;

    public StringAnalyzer(String text) {
        StringCleaner cleaner = new StringCleaner();
        this.text = cleaner.cleanString(text);
    }

    public Map<String, Integer> getWordFrequencies() {
        String words[] = text.split(" ");
        Map<String, Integer> wordFrequencies = new HashMap<String, Integer>();

        for (String word : words) {
            if (word.length() > 0) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequencies;
    }

    public String getLongestWord() {
        if (text.isEmpty()) {
            throw new ArithmeticException("Cleaned text is empty.");
        }

        String words[] = text.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    public boolean isPalindrome() {
        if (text.isEmpty()) {
            throw new ArithmeticException("Cleaned text is empty.");
        }

        String reversedText = new StringBuilder(text.replaceAll("\\s+", "")).reverse().toString();
        return text.replaceAll("\\s+", "").equals(reversedText);
    }

    public String getText() {
        return text;
    }
}
