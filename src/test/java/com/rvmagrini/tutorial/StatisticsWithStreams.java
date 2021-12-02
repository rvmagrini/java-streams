package com.rvmagrini.tutorial;

import com.rvmagrini.mockandbeans.Car;
import com.rvmagrini.mockandbeans.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws IOException {
        List<Car> cars = MockData.getCars();

        long numberOfCarsFord = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("ford"))
                .filter(car -> car.getYear() > 2000)
                .count();

        System.out.println(numberOfCarsFord);
    }

    @Test
    public void min() throws IOException {
        List<Car> cars = MockData.getCars();

        double cheapestCar = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);

        System.out.println(cheapestCar);
    }

    @Test
    public void max() throws IOException {
        List<Car> cars = MockData.getCars();

        double mostExpensiveCar = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);

        System.out.println(mostExpensiveCar);
    }

    @Test
    public void average() throws IOException {
        List<Car> cars = MockData.getCars();

        double averageCarPrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(averageCarPrice);
    }

    @Test
    public void sum() throws IOException {
        List<Car> cars = MockData.getCars();

        double sumCarPrices = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();

        System.out.println(BigDecimal.valueOf(sumCarPrices));
    }

}
