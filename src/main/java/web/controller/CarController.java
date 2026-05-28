package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {

    private final CarService carService;

    // Внедрение сервиса через конструктор
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        // Контроллер делегирует задачу сервису
        model.addAttribute("cars", carService.getCarsByCount(count));
        return "cars";
    }

}