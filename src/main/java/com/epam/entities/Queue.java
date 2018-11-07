package com.epam.entities;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Train> trains = new ArrayList<>();

    synchronized public void push(Train train) {
        trains.add(train);
//        notifyAll();
    }

    synchronized public Train pull() {
//        while (trains.size() == 0) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        Train train = trains.get(0);
//        trains.remove(0);
//        return train;

        if (!trains.isEmpty()) {
            Train train = trains.get(0);
            trains.remove(0);
            return train;
        }
        return null;
    }

    public int size() {
        return trains.size();
    }
}
