package com.rvmagrini.tutorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @BeforeEach
    void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = new ArrayList<>();

        // arrayListOfNames.forEach(list -> list.forEach(name -> names.add(name)));

        // for (List<String> name : arrayListOfNames) {
        //    names.addAll(name);
        // }

        arrayListOfNames.forEach(names::addAll);

        System.out.println(names);
    }

    @Test
    public void withFlatMap() {
        List<String> names = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(names);
    }

}
