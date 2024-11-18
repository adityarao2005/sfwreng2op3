package com.mcmaster.se2op3;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            TextAnalyzer analyzer = new TextAnalyzer("A man a plan a canal Panama");

            System.out.println("Word Frequencies: " + analyzer.getWordFrequencies());
            System.out.println("Longest Word: " + analyzer.getLongestWord());
            System.out.println("Is Palindrome: " + analyzer.isPalindrome());
            System.out.println("Average Word Length: " + analyzer.averageWordLength());
            System.out.println("Words in Alphabetical Order:");
            analyzer.printWordsAlpha();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
