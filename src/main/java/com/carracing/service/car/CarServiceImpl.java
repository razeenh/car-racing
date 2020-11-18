package com.carracing.service.car;

import com.carracing.dao.car.Car;
import com.carracing.dao.car.CarRepository;
import com.carracing.sdk.mapper.DtoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private CarRepository repo;
    private DtoMapper<Car, CarDto> dtoMapper;

    public CarServiceImpl(CarRepository repo) {
        this.repo = repo;
        this.dtoMapper = new CarDtoMapperImpl();
    }

    @Override
    public List<CarDto> getCars() {
        return repo.findAll().stream().map(dtoMapper::mapFrom).collect(Collectors.toList());
    }
}
