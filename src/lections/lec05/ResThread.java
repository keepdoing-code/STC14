package lections.lec05;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ResThread extends Thread {
    private static final Object monitor = new Object();
    private static int count;
    private final Counter counter;

    public ResThread(Counter counter) {
        this.counter = counter;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (monitor) {
                count++;
                try {
                    counter.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
