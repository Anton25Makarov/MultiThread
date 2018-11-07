package com.epam;

import com.epam.entities.*;
import com.epam.logic.TrainCreator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TrainCreator trainCreator = new TrainCreator();
        List<Train> trainList = trainCreator.createTrains("src/main/resources/exampleTrains.txt");

        Queue queue = new Queue();

        TrainProducer trainProducer = new TrainProducer(queue, trainList);

        TrainConsumer trainConsumer = new TrainConsumer(queue);

        Thread thread = new Thread(trainProducer);

        thread.start();
        trainConsumer.consuming();

    }
}
