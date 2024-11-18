package com.mcmaster.se2op3;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            StringAnalyzer analyzer = new StringAnalyzer("A man a plan a canal Panama");

            System.out.println("Word Frequencies: " + analyzer.getWordFrequencies());
            System.out.println("Longest Word: " + analyzer.getLongestWord());
            System.out.println("Is Palindrome: " + analyzer.isPalindrome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
