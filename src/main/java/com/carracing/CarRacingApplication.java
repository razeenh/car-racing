package com.carracing;

import com.carracing.dao.car.CarRepositoryImpl;
import com.carracing.dao.track.TrackRepositoryImpl;
import com.carracing.process.CarRace;
import com.carracing.process.CarRaceImpl;
import com.carracing.service.car.CarDto;
import com.carracing.service.car.CarService;
import com.carracing.service.car.CarServiceImpl;
import com.carracing.service.track.TrackDto;
import com.carracing.service.track.TrackService;
import com.carracing.service.track.TrackServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CarRacingApplication {

    private CarRace carRace;
    private CarService carService;
    private TrackService trackService;

    public CarRacingApplication(CarService carService, TrackService trackService, CarRace carRace) {
        this.carService = carService;
        this.trackService = trackService;
        this.carRace = carRace;
    }

    public static void main(String[] args) {
        new CarRacingApplication(new CarServiceImpl(new CarRepositoryImpl()),
                new TrackServiceImpl(new TrackRepositoryImpl()),
                new CarRaceImpl()
        ).run();
    }

    public void run() {
        List<CarDto> cars = carService.getCars();
        displayCars(cars);

        List<TrackDto> tracks = trackService.getTracks();
        displayTracks(tracks);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int trackNo = selectTrackAndRace(scanner, tracks.size());
                carRace.startRace(cars, tracks.get(trackNo - 1));

                if (!runAgain(scanner)) {
                    break;
                }
            }
        }
    }

    private boolean runAgain(Scanner scanner) {
        System.out.println();
        System.out.print("Would you like to race again? (Y/N) ");
        System.out.println();
        String doAnotherRace = scanner.next();

        if (doAnotherRace.equalsIgnoreCase("y")) {
            return true;
        }

        return false;
    }

    private int selectTrackAndRace(Scanner scanner, int trackCount) {
        System.out.print("Please select a track (Enter the number): ");
        String trackNo = scanner.next();

        int trackNumber = 0;
        boolean isBadEntry = false;

        try {
            trackNumber = Integer.parseInt(trackNo);
            if ((trackNumber < 1) || (trackNumber > trackCount)) {
                isBadEntry = true;
            }
        } catch (Exception e) {
            isBadEntry = true;
        }

        if (isBadEntry) {
            System.err.println("Your selection is invalid. Please supply a value between 1 and " + trackCount);
            System.out.println();
            return selectTrackAndRace(scanner, trackCount);

        } else {
            System.out.println();
            System.out.println();

            return trackNumber;
        }
    }

    private void displayCars(List<CarDto> cars) {
        System.out.println();
        System.out.println();
        System.out.println("Cars:");
        System.out.println("====");
        System.out.println();

        for (CarDto car : cars) {
            System.out.println("Name:                   " + car.getName());
            System.out.println("    Acceleration:       " + car.getAcceleration());
            System.out.println("    Braking:            " + car.getBraking());
            System.out.println("    Cornering Ability:  " + car.getCorneringAbility());
            System.out.println("    Top Speed:          " + car.getTopSpeed());
            System.out.println();
            System.out.println("	-----------------------");
        }

        System.out.println();
    }

    private void displayTracks(List<TrackDto> tracks) {
        System.out.println("Available Tracks:");
        System.out.println("================");
        System.out.println();

        int trackCounter = 1;

        for (TrackDto track : tracks) {
            System.out.println(trackCounter++ + ") " + track.getRoute());
        }

        System.out.println();
    }
}
