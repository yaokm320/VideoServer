package com.example.test;

/**
 * @author yaokm
 * @date 2021/3/7 21:41
 */

public class TestPrintNumber {


    static class MyRunnable implements Runnable{

        private int i = 0;

        @Override
        public void run() {
            while (true){
                synchronized (this) {
                    this.notify();
                    if(i < 100){
                        i++;
                        System.out.println(Thread.currentThread().getName()+"---"+i);
                    }else{
                        break;
                    }
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable,"线程1");
        Thread t2 = new Thread(myRunnable,"线程2");
        t1.start();
        t2.start();
    }
}
