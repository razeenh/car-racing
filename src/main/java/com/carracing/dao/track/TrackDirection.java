package com.carracing.dao.track;

import com.carracing.dao.car.CarAttribute;

import java.util.Arrays;
import java.util.List;

public enum TrackDirection {
    STRAIGHT('1', Arrays.asList(CarAttribute.ACCELERATION, CarAttribute.TOP_SPEED)),
    TURN('0', Arrays.asList(CarAttribute.BRAKING, CarAttribute.CORNERING_ABILITY));

    private char value;
    private List<CarAttribute> carAttributes;

    TrackDirection(char value, List<CarAttribute> carAttributes) {
        this.value = value;
        this.carAttributes = carAttributes;
    }

    public char getValue() {
        return value;
    }

    public List<CarAttribute> getCarAttributes() {
        return carAttributes;
    }

    public static TrackDirection resolve(char directionValue) {
        for (TrackDirection trackDirection : values()) {
            if (trackDirection.getValue() == directionValue) {
                return trackDirection;
            }
        }

        throw new IllegalArgumentException("Unknown track direction: " + directionValue);
    }
}
