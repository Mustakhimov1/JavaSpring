package com.auto.dealership.service.impl;

import com.auto.dealership.dto.CarDto;
import com.auto.dealership.exception.HttpStatusException;
import com.auto.dealership.repository.CarRepository;
import com.auto.dealership.service.CarService;
import com.auto.dealership.specifications.CarSpecification;
import com.auto.dealership.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> getAll(CarSpecification filter) {
        return carRepository.findAll(filter)
                .stream()
                .map(Mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto getById(Long id) {
        return carRepository.findById(id)
                .map(Mapper::map)
                .orElseThrow(() -> new HttpStatusException("Car not found by id: " + id));
    }
}
