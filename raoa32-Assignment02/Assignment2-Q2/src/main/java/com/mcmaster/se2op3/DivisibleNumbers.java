package com.mcmaster.se2op3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DivisibleNumbers {
    private List<Integer> divideByThree;
    private List<Integer> divideByFive;
    private List<Integer> divideByFifteen;

    public DivisibleNumbers() {
        divideByFifteen = new ArrayList<>();
        divideByFive = new ArrayList<>();
        divideByThree = new ArrayList<>();
    }

    public void findDivisibleNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            if (i % 15 == 0) {
                divideByFifteen.add(i);
            }
            if (i % 5 == 0) {
                divideByFive.add(i);
            }
            if (i % 3 == 0) {
                divideByThree.add(i);
            }
        }
    }

    public String getDivideByThree() {
        return divideByThree.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public String getDivideByFive() {
        return divideByFive.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public String getDivideByFifteen() {
        return divideByFifteen.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
