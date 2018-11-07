package com.epam.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TrainConsumer {
    private static final int THREAD_POOL_SIZE = 2;
    private Queue queue;
    private ExecutorService tunnels;

    public TrainConsumer(Queue queue) {
        this.queue = queue;
        this.tunnels = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }


    public void consuming() {
        List<Tunnel> tunnelList = new ArrayList<>();
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            tunnelList.add(new Tunnel(queue));
        }

        for (Tunnel tunnel : tunnelList) {
            tunnels.execute(tunnel);
            System.out.println("# Thread #" + Thread.currentThread().getName());
        }

        try {
            System.out.println("attempt to shutdown executor");
            tunnels.shutdown();
            tunnels.awaitTermination(25, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!tunnels.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            tunnels.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
