package com.mcmaster.se2op3;

/**
 * class DecimalToConversion
 */
public class DecimalToConversion {

    /**
     * Convert a decimal number to an octal number
     * 
     * @param number the decimal number to convert
     * @return the octal number
     */
    public static int toOctal(int number) {
        // Handle negative numbers
        if (number < 0) {
            return -1 * toOctal(-number);
        }

        // Base case
        if (number < 8) {
            return number;
        }

        // Recursive case
        return toOctal(number / 8) * 10 + number % 8;
    }

}
