package com.epam.logic;

import com.epam.entities.Train;
import com.epam.entities.TrainDirection;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public List<Train> parseTrains(List<String> stringList) {
        List<Train> trains = new ArrayList<>();
        TrainValidator validator = new TrainValidator();

        for (String string : stringList) {
            if (validator.isValid(string)) {
                String values[] = string.split(" ");

                String id = values[0];
                String stationFrom = values[1];
                String stationTo = values[2];
                String direction = values[3];
                long idNumber = Long.valueOf(id);

                TrainDirection trainDirection;

                switch (direction) {
                    case "west":
                        trainDirection = TrainDirection.WEST;
                        break;
                    case "east":
                        trainDirection = TrainDirection.EAST;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

                Train train = new Train(idNumber, stationFrom, stationTo, trainDirection);
                trains.add(train);
            }
        }
        return trains;
    }
}
