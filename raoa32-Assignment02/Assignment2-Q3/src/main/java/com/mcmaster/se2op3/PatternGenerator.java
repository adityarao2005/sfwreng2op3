package com.mcmaster.se2op3;

public class PatternGenerator {

    public static void createTriangle(int number) {
        String cache = "";

        for (int i = 1; i <= number; i++) {
            cache += i;
            System.out.println(cache);
        }
    }
}
