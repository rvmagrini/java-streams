package com.rvmagrini.tutorial;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    @Test
    public void joiningStrings() {
        // "Anna, John, Marcos, Helena, Yasmin"
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        StringBuilder joinedNames = new StringBuilder();

        for (String name : names) {
            joinedNames
                    .append(name.substring(0, 1).toUpperCase())
                    .append(name.substring(1))
                    .append(", ");
        }
        System.out.println(joinedNames.substring(0, joinedNames.length()-2));
    }

    @Test
    public void joiningStringsWithStreams() {
        // "Anna, John, Marcos, Helena, Yasmin"
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");

        String joinedNames = names.stream()
                .map(String::toLowerCase)
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.joining(", "));
        System.out.println(joinedNames);
    }

}
