package com.mcmaster.se2op3;

public class TelephoneMapper {

    public static char mapChar(char input) {
        // If the character is a digit, return it
        if (Character.isDigit(input)) {
            return input;
        }

        // Map the character to a number
        switch (input) {
            case 'A':
            case 'B':
            case 'C':
                return '2';
            case 'D':
            case 'E':
            case 'F':
                return '3';
            case 'G':
            case 'H':
            case 'I':
                return '4';
            case 'J':
            case 'K':
            case 'L':
                return '5';
            case 'M':
            case 'N':
            case 'O':
                return '6';
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                return '7';
            case 'T':
            case 'U':
            case 'V':
                return '8';
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return '9';
            default:
                return input;
        }
    }

    public static String mapNumber(String input) {
        // Create an array to store the output
        char[] output = new char[10];
        // Remove all non-numeric characters
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                continue;
            }
            output[counter++] = mapChar(input.charAt(i));
        }

        // Format the array into a phone number
        return String.format("%c%c%c-%c%c%c-%c%c%c%c", output[0], output[1], output[2], output[3], output[4], output[5],
                output[6], output[7], output[8], output[9]);
    }

    public static boolean validateFormat(String input) {
        // Check if the input is in the correct format
        return input.matches("[A-Z0-9]{3}-?[A-Z0-9]{3}-?[A-Z]{4}");
    }
}
