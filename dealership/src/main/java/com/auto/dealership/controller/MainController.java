package com.auto.dealership.controller;

import com.auto.dealership.dto.CarDto;
import com.auto.dealership.service.CarService;
import com.auto.dealership.specifications.CarSpecification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller
public class MainController {
    private final CarService carService;


    public MainController(CarService carService) {
        this.carService = carService;

    }

    @GetMapping("/")
    public String home(@RequestParam(required = false) String name,
                       @RequestParam(required = false) Double priceGe,
                       @RequestParam(required = false) Double priceLe,
                       Model model,
                       Principal principal) {
        List<CarDto> cars = carService.getAll(new CarSpecification(name, priceGe, priceLe));
        model.addAttribute("cars", cars);
        model.addAttribute("filesInfo");
        return "home";
    }
}
