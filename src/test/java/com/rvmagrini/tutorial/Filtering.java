package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.Car;
import com.rvmagrini.mockandbeans.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws IOException {
        List<Car> cars = MockData.getCars();

        List<Car> yellowCarsLessThan20k = cars.stream()
                .filter(car -> car.getPrice() < 20_000.00)
                .filter(car -> car.getColor().equals("Yellow"))
                .collect(Collectors.toList());

        yellowCarsLessThan20k.forEach(System.out::println);
    }

    @Test
    public void takeWhile() {
        System.out.println("Using Filter:");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));

        System.out.println();
        System.out.println("Using Take While:");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();
    }

    @Test
    public void dropWhile() {
        System.out.println("Using Filter:");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));

        System.out.println();
        System.out.println("Using Drop While:");
        Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(number -> number % 2 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();
    }

    @Test
    public void findFirst() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers)
                .filter(number -> number == 50)
                .findFirst()
                .orElse(-1);

        System.out.println(result);
    }

    @Test
    public void findAny() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers)
                .filter(number -> number == 6)
                .findAny()
                .orElse(-1);

        System.out.println(result);
    }

}