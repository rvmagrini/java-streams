package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.MockData;
import com.rvmagrini.mockandbeans.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() {
        System.out.println("For i Loop:");
        for (int i=0; i<=10; i++) {
            System.out.print(i);
        }
        System.out.println();

        System.out.println("IntStream Exclusive:");
        IntStream.range(0, 10).forEach(System.out::print);

        System.out.println();
        System.out.println("IntStream Inclusive:");
        IntStream.rangeClosed(0, 10).forEach(System.out::print);
    }

    @Test
    public void rangeIteratingLists() throws Exception {
        System.out.println("IntStream Iteration on Lists:");

        List<Person> people = MockData.getPeople();

        IntStream.range(0, 15)
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }

    @Test
    public void intStreamIterate() {
        System.out.println("IntStream Iteration:");
        IntStream.iterate(0, value -> value + 2)
                .limit(11)
                .forEach(System.out::print);
    }

}
