package com.rvmagrini.tutorial;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 4, 100, 23, 93, 99);
        int min = numbers.stream()
                // .min((o1, o2) -> o1.compareTo(o2))
                // .min(Integer::compareTo)
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Min: " + min);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 4, 100, 23, 93, 99);
        int max = numbers.stream()
                // .max((o1, o2) -> o1.compareTo(o2))
                // .max(Integer::compareTo)
                .max(Comparator.naturalOrder())
                .get();
        System.out.println("Max: " + max);
    }

}
