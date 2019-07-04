package com.sandeep.string;

import java.security.NoSuchAlgorithmException;

public class Print11223344withtwothreads implements Runnable {

   int x =0; int y=0;
   public int addX(){
       x++;
       return x;

   }
   public  int addY(){
       y++;
       return y;
   }
   public  void run(){
       for(int i=0 ; i<10; i++)
       System.out.println(addX()+ ""+ addY());
   }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Print11223344withtwothreads ob1 = new Print11223344withtwothreads();
        Print11223344withtwothreads ob2 = new Print11223344withtwothreads();
        Thread t1 = new Thread(ob1);
        Thread t2 = new Thread(ob2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();

        t2.start();
    }
}
