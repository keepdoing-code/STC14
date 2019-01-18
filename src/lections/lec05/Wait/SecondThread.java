package lections.lec05.Wait;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class SecondThread extends Thread {
    private final int seconds;

    public SecondThread(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (ChronoThread.MONITOR) {
                try {
                    ChronoThread.MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Seconds " + seconds);
        }
    }
}
