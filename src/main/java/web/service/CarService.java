package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    // Список с машинами
    private final List<Car> carList = Arrays.asList(
            new Car("VW", "Polo", 2021),
            new Car("Audi", "A6", 2020),
            new Car("Mercedes", "S-class", 2023),
            new Car("Lada", "Kalina", 2014),
            new Car("Lada", "2107", 2005)
    );

    // Возвращаем список машин в зависимости от count
    public List<Car> getCarsByCount(Integer count) {
        if (count == null || count < 0) {
            return carList;
        }
        return carList.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
