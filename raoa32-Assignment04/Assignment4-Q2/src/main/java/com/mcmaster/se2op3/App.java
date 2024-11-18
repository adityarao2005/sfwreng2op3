package com.mcmaster.se2op3;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            int[] data = { 10, 20, 30, 40, 50 };
            StatisticsCalculator calculator = new StatisticsCalculator(data);

            System.out.println("Average: " + calculator.calculateAverage());
            System.out.println("Median: " + calculator.calculateMedian());

            // Example of handling an exception
            int[] emptyData = {};
            calculator.updateArray(emptyData); // Should handle exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
