package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.Car;
import com.rvmagrini.mockandbeans.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws IOException {
        Map<String, List<Car>> carsByMake = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

        carsByMake.forEach((make, cars) -> {
            System.out.println("Make: " + make);
            cars.forEach(System.out::println);
            System.out.println("============================");
        });
    }

    @Test
    public void groupingAndCounting() {
        List<String> names = List.of(
                "Alex",
                "John",
                "Mike",
                "John",
                "Alex",
                "John",
                "Kate",
                "Alex",
                "Mike"
        );

        Map<String, Long> occurrences = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        System.out.println(occurrences);
    }

}
