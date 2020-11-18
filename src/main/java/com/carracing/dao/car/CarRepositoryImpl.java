package com.carracing.dao.car;

import com.carracing.sdk.dao.JdbcWrapper;

import java.util.List;

public class CarRepositoryImpl extends JdbcWrapper implements CarRepository {

    @Override
    public List<Car> findAll() {
        return super.executeQuery("select * from car", new CarMapperImpl());
    }
}
