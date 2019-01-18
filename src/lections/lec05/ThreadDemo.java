package lections.lec05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        demo2();
    }

    private static void demo2() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            Thread thread = new ResThread(counter);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Local res = " + ResThread.getCount());
    }


    private static void demo1() throws InterruptedException {
        Thread myThread = new MyThread(new MyRunnable());
        myThread.setDaemon(true);
        myThread.start();
        myThread.interrupt();
        Thread.sleep(2000);
        try {
            myThread.join();
        } catch (InterruptedException e) {

        }

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();


        System.out.println("Exec end");


    }
}
