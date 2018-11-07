package com.epam.logic;

import com.epam.entities.Train;

import java.util.List;

public class TrainCreator {

    public List<Train> createTrains(String filePath) {
        FileReader fileReader = new FileReader();
        List<String> stringList = fileReader.readLines(filePath);

        DataParser dataParser = new DataParser();
        return dataParser.parseTrains(stringList);
    }
}
