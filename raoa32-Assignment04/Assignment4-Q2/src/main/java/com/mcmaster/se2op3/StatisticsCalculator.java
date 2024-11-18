package com.mcmaster.se2op3;

import java.util.Arrays;

public class StatisticsCalculator {
    private int[] array;

    public StatisticsCalculator(int[] array) throws Exception {
        updateArray(array);
    }

    private double toTwoDecimalPlaces(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

    public void updateArray(int[] array) throws Exception {
        if (array == null || array.length == 0)
            throw new IllegalArgumentException("Invalid input. Array cannot be null or empty.");
        this.array = array;
    }

    public double calculateAverage() {
        if (array.length == 0)
            throw new ArithmeticException("Array is empty. Cannot perform operation.");

        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        return toTwoDecimalPlaces(sum / array.length);
    }

    public double calculateMedian() {
        if (array.length == 0)
            throw new ArithmeticException("Array is empty. Cannot perform operation.");

        int n = array.length;

        // Sort the array
        Arrays.sort(array);

        // If the length of the array is odd, return the middle element
        if (n % 2 != 0) {
            return array[n / 2];
        }

        // If the length of the array is even, return the average of the two middle elements
        return toTwoDecimalPlaces((array[(n - 1) / 2] + array[n / 2]) / 2.0);
    }

    public int[] accessArray() {
        return array.clone();
    }

}