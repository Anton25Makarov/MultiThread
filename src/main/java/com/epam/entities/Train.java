package com.epam.entities;


import java.util.concurrent.TimeUnit;

public class Train implements Runnable {
    private long idNumber;
    private String stationFrom;
    private String stationTo;
    private TrainDirection TrainDirection;

    public Train(long idNumber, String stationFrom, String stationTo, TrainDirection TrainDirection) {
        this.idNumber = idNumber;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
        this.TrainDirection = TrainDirection;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Tunnel: " + Thread.currentThread().getName() +
                        ". Train: " + this + ". Distance: " + ((double) i / (3 - 1)));
                TimeUnit.MILLISECONDS.sleep(300);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public com.epam.entities.TrainDirection getTrainDirection() {
        return TrainDirection;
    }

    @Override
    public String toString() {
        return "Train{" +
                "idNumber=" + idNumber +
                ", stationFrom='" + stationFrom + '\'' +
                ", stationTo='" + stationTo + '\'' +
                ", TrainDirection=" + TrainDirection +
                '}';
    }
}
