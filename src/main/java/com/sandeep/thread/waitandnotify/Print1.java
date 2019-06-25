package com.sandeep.thread.waitandnotify;

public class Print1 implements Runnable {

    private Message message;

    public Print1(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (message) {
                if (!message.isShouldProceed()) {
                    System.out.println("1");
                    message.setShouldProceed(true);
                }
            }
        }
    }
}
