package com.mcmaster.se2op3;

import java.util.Arrays;

public class TextAnalyzer extends StringAnalyzer {
    public TextAnalyzer(String text) {
        super(text);
    }

    public int averageWordLength() {
        if (getText().isEmpty()) {
            throw new IllegalArgumentException("Cleaned text cannot be empty");
        }

        int totalLength = 0;
        int wordCount = 0;

        String[] words = getText().split(" ");

        for (String word : words) {
            totalLength += word.length();
            wordCount++;
        }

        return totalLength / wordCount;
    }

    public void printWordsAlpha() {
        if (getText().isEmpty()) {
            throw new IllegalArgumentException("Cleaned text cannot be empty");
        }

        String[] words = getText().split(" ");
        Arrays.sort(words);

        String prev = "";

        for (String word : words) {
            if (word.equals(prev)) {
                continue;
            }
            System.out.println(word);
            prev = word;
        }
    }

}
