package org.junior.lesson1.task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 6, -5, 5, 7, 8, 10, -14);
// вариант из списка с промежуточным результатом
        List<Integer> evenNumbers = numbers
                .stream()
                .filter(num -> num % 2 == 0)
                .toList();
        System.out.println(evenNumbers);
        double av = evenNumbers.stream().mapToInt(i -> i).average().getAsDouble();
        System.out.println(av);

// вариант из массива сразу среднее одной строкой
        int[] array = {3, 4, 6, -5, 5, 7, 8, 10, -14};
        double av2 = Arrays.stream(array).filter(num -> num % 2 == 0).mapToLong(i -> i).average().getAsDouble();
        System.out.println(av2);
    }

}
