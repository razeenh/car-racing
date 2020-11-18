package com.carracing.service.car;

import com.carracing.dao.car.Car;
import com.carracing.sdk.mapper.DtoMapper;

public class CarDtoMapperImpl implements DtoMapper<Car, CarDto> {

    @Override
    public CarDto mapFrom(Car entity) {
        CarDto carDto = new CarDto();
        carDto.setName(entity.getName());
        carDto.setAcceleration(entity.getAcceleration());
        carDto.setBraking(entity.getBraking());
        carDto.setCorneringAbility(entity.getCorneringAbility());
        carDto.setTopSpeed(entity.getTopSpeed());
        return carDto;
    }
}
