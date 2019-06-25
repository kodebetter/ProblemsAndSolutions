package com.sandeep.thread.waitandnotify;

public class Print2 implements Runnable {

    Message message;

    public Print2(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (message) {
                if (message.isShouldProceed())
                    System.out.println("2");
                message.setShouldProceed(false);
            }
        }
    }

}
