package com.carracing.dao.car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarMapperImpl implements CarMapper {

    @Override
    public List<Car> mapResult(ResultSet rs) throws SQLException {
        List<Car> cars = new ArrayList<>();

        while (rs.next()) {
            Car car = new Car();
            car.setId(rs.getInt("id"));
            car.setAcceleration(rs.getInt("acceleration"));
            car.setBraking(rs.getInt("braking"));
            car.setCorneringAbility(rs.getInt("cornering_ability"));
            car.setName(rs.getString("name"));
            car.setTopSpeed(rs.getInt("top_speed"));

            cars.add(car);
        }

        return cars;
    }
}
