package com.rvmagrini.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctAndSets {

    @Test
    public void distinct() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinct);
        assertThat(distinct).hasSize(9);
    }

    @Test
    public void distinctWithSet() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        // Set<Integer> distinctSet = new HashSet<>(numbers);
        Set<Integer> distinctSet = numbers.stream().collect(Collectors.toSet());

        System.out.println(distinctSet);
        assertThat(distinctSet).hasSize(9);
    }

}
