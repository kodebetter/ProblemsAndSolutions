package com.sandeep.thread.waitandnotify;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountDownLatchDemo {


    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(4);
        Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
        Thread alertService = new Thread(new Service("AlertService", 1000, latch));
        Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

        cacheService.start();
        alertService.start();
        validationService.start();
        //validationService.start();
        try {
            latch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


class Service implements Runnable {
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

    public Service(String name, int timeToStart, CountDownLatch latch) {
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }

}


