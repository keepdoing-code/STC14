package lections.lec05.Wait;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ChronoThread();
        thread.start();

        Thread s1 = new SecondThread(3);
        s1.setDaemon(true);
        s1.start();

        Thread s2 = new SecondThread(5);
        s2.setDaemon(true);
        s2.start();

        Thread.sleep(3000);
        thread.interrupt();
        thread.join();
        System.out.println("Done!");
    }
}
