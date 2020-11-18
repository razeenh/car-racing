package com.carracing.service.car;

import com.carracing.dao.car.Car;
import com.carracing.dao.car.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {

    @Mock
    private CarRepository repo;
    @InjectMocks
    private CarServiceImpl carService;

    private static final String CAR_NAME = "Audi";

    @Test
    public void canFindTracksSuccessfully() {
        when(repo.findAll()).thenReturn(getCars());

        List<CarDto> cars = carService.getCars();

        verify(repo, times(1)).findAll();
        Assert.assertEquals(CAR_NAME, cars.get(0).getName());
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        Car car = new Car();
        car.setId(1);
        car.setName(CAR_NAME);
        car.setAcceleration(5);
        car.setTopSpeed(8);
        car.setCorneringAbility(6);
        car.setBraking(7);
        cars.add(car);
        return cars;
    }
}