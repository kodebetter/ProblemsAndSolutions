package com.sandeep.thread.waitandnotify;

public class Print121212 {

    public static void main(String[] args) {

        Message message = new Message("", false);
        Print1 print1 = new Print1(message);
        Print2 print2 = new Print2(message);
        Thread t1 = new Thread(print1,"print1");
        Thread t2 = new Thread(print2,"print2");

        t2.start();
        t1.start();




    }
}
