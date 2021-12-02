package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.Car;
import com.rvmagrini.mockandbeans.MockData;
import com.rvmagrini.mockandbeans.Person;
import com.rvmagrini.mockandbeans.PersonDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
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

    @Test
    public void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double averageCarPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(averageCarPrice);
    }
    
    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sub = Arrays.stream(integers)
                .reduce(0, (left, right) -> left - right);
        int sum = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        System.out.println(sub);
        System.out.println(sum);
    }

}
