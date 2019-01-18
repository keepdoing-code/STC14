package lections.lec05.Wait;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ChronoThread extends Thread {
    public static final Object MONITOR = new Object();

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println("chrono " + i);
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
