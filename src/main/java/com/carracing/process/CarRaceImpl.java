package com.carracing.process;

import com.carracing.dao.car.CarAttribute;
import com.carracing.dao.track.TrackDirection;
import com.carracing.service.car.CarDto;
import com.carracing.service.track.TrackDto;

import java.util.*;

public class CarRaceImpl implements CarRace {

    @Override
    public void startRace(List<CarDto> cars, TrackDto track) {
        Map<TrackDirection, Integer> trackDirections = analyzeTrackDirections(track);

        NavigableMap<Integer, CarDto> carScores = new TreeMap<>();

        for (CarDto car : cars) {
            int totalScore = calculateScore(car, trackDirections);
            carScores.put(totalScore, car);
        }

        carScores = carScores.descendingMap();
        int position = 1;

        System.out.println("===========");
        System.out.println("Top 3 Cars");
        System.out.println("===========");
        System.out.println();

        for (Map.Entry<Integer, CarDto> carScore : carScores.entrySet()) {
            System.out.println("Position #" + position++);
            System.out.println("    Car:    " + carScore.getValue().getName());
            System.out.println("    Score:  " + carScore.getKey());
            System.out.println("-------------------------");

            if (position == 4) {
                break;
            }
        }
    }

    private Map<TrackDirection, Integer> analyzeTrackDirections(TrackDto track) {
        Map<TrackDirection, Integer> trackDirections = new HashMap<>();

        for (char trackDirectionValue : track.getRoute().toCharArray()) {
            TrackDirection trackDirection = TrackDirection.resolve(trackDirectionValue);

            if (trackDirections.containsKey(trackDirection)) {
                trackDirections.put(trackDirection, trackDirections.get(trackDirection)+1);

            } else {
                trackDirections.put(trackDirection, 1);
            }
        }

        return trackDirections;
    }

    private int calculateScore(CarDto car, Map<TrackDirection, Integer> trackDirections) {
        return trackDirections.entrySet()
                .stream()
                .map(directionEntry -> {
                    int score = 0;

                    for (CarAttribute carAttribute : directionEntry.getKey().getCarAttributes()) {
                        switch (carAttribute) {
                            case BRAKING:           score += car.getBraking() * directionEntry.getValue(); break;
                            case CORNERING_ABILITY: score += car.getCorneringAbility() * directionEntry.getValue(); break;
                            case ACCELERATION:      score += car.getAcceleration() * directionEntry.getValue(); break;
                            case TOP_SPEED:         score += car.getTopSpeed() * directionEntry.getValue(); break;
                        }
                    }

                    return score;
                })
                .mapToInt(Integer::intValue)
                .sum();
    }
}
