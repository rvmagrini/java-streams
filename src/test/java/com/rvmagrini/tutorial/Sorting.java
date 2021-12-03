package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.Car;
import com.rvmagrini.mockandbeans.MockData;
import com.rvmagrini.mockandbeans.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingStreamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();

        List<String> peopleSorted = people.stream()
                .map(Person::getFirstName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(peopleSorted);
    }

    @Test
    public void sortingStreamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();

        List<String> peopleSortedReversed = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(peopleSortedReversed);
    }

    @Test
    public void sortingStreamOfObjects() throws IOException {
        List<Person> people = MockData.getPeople();

        List<Person> peopleSorted = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        peopleSorted.forEach(System.out::println);
    }

    @Test
    public void sortingStreamOfObjectsReverse() throws IOException {
        List<Person> people = MockData.getPeople();

        List<Person> peopleSortedReversed = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName).reversed())
                .collect(Collectors.toList());
        peopleSortedReversed.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();

        List<String> topTenMostExpBlueCars = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .map(car -> car.getColor() + " " + car.getMake() + " (" + car.getModel() + "): " + car.getPrice())
                .collect(Collectors.toList());

        topTenMostExpBlueCars.forEach(System.out::println);
    }


}
