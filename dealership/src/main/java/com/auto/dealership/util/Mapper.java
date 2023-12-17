package com.auto.dealership.util;

import com.auto.dealership.dto.CarDto;
import com.auto.dealership.model.Car;

public class Mapper {
    public static CarDto map(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setName(car.getName());
        carDto.setDescription(car.getDescription());
        return carDto;
    }
}
