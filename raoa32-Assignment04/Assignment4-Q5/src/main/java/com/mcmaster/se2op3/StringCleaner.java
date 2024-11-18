package com.mcmaster.se2op3;

public class StringCleaner {

    private String removePunctuation(String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!(c == ',' || c == '.' || c == ':' || c == '?' || c == '!')) {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    private String convertToLowerCase(String input) {
        return input.toLowerCase();
    }

    private String removeExtraSpaces(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public String cleanString(String input) {
        String cleanedString = removePunctuation(input);
        cleanedString = convertToLowerCase(cleanedString);
        cleanedString = removeExtraSpaces(cleanedString);

        return cleanedString;
    }
}
