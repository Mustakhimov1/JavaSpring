package com.auto.dealership.service;

import com.auto.dealership.dto.CarDto;
import com.auto.dealership.specifications.CarSpecification;

import java.util.List;

public interface CarService {
    List<CarDto> getAll(CarSpecification filter);

    CarDto getById(Long id);
}
