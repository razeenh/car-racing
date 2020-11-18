package com.carracing.process;

import com.carracing.service.car.CarDto;
import com.carracing.service.track.TrackDto;

import java.util.List;

public interface CarRace {
    void startRace(List<CarDto> cars, TrackDto track);
}
