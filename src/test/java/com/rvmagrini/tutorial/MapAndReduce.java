package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.MockData;
import com.rvmagrini.mockandbeans.Person;
import com.rvmagrini.mockandbeans.PersonDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndReduce {

    @Test
    public void transformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 90)
                .map(person -> new PersonDTO(
                            person.getId(),
                            person.getFirstName(),
                            person.getAge()))
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
    }

}
