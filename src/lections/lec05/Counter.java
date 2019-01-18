package lections.lec05;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Counter {
    private int count;

    public synchronized int getCount() {
        return count;
    }

    public void inc() throws InterruptedException {
        synchronized (this) {
            this.wait();
            this.notify();
            this.notifyAll();
            this.count = ++count;
        }
    }
}
