package com.epam.entities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tunnel implements Runnable {
    private static final int THREAD_POOL_SIZE = 3;
    private Queue trainQueue;
    private ExecutorService trains;

    public Tunnel(Queue trainQueue) {
        this.trainQueue = trainQueue;
        this.trains = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    @Override
    public void run() {
        Train train;
        Train trainBuffer;
        while (true) {
            train = trainQueue.pull();


            System.out.println("$: " + train + ". Thread #" + Thread.currentThread().getName());

            if (train == null) {
                break;
            }
            trains.execute(train);
            trainBuffer = train;
        }
        try {
            System.out.println("attempt to shutdown executor");
            trains.shutdown();
            trains.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!trains.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            trains.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

    @Override
    public String toString() {
        return "Tunnel{" +
                "trainQueue=" + trainQueue +
                ", trains=" + trains +
                '}';
    }
}
