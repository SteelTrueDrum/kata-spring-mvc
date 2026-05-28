package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    private final List<Car> carList = Arrays.asList(
            new Car("VW", "Polo", 2021),
            new Car("Audi", "A6", 2020),
            new Car("Mercedes", "S-class", 2023),
            new Car("Lada", "Kalina", 2014),
            new Car("Lada", "2107", 2005)
    );

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> resultList;

        if (count == null || count >= 5) {
            resultList = carList;
        } else {
            resultList = carList.stream()
                    .limit(count)
                    .collect(Collectors.toList());
        }

        model.addAttribute("cars", resultList);
        return "cars";
    }

}