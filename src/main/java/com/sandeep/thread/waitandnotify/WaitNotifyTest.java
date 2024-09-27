package com.sandeep.thread.waitandnotify;

public class WaitNotifyTest {

	public static void main(String[] args) {
        Message msg = new Message("process it", true);
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();
            System.out.println("1 started");
         
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();
            System.out.println("2 started");
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }
}
