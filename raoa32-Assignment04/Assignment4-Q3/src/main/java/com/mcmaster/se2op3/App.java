package com.mcmaster.se2op3;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StringCleaner cleaner = new StringCleaner();
        String input = "  Hello, World! How's it going?  ";
        String cleanedText = cleaner.cleanString(input);
        System.out.println("Cleaned Text: " + cleanedText);
    }
}
