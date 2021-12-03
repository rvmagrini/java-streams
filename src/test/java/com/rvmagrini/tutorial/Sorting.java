package com.rvmagrini.tutorial;

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



}
