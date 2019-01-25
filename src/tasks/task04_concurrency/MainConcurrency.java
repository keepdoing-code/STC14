package tasks.task04_concurrency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */

public class MainConcurrency {
    public static void main(String[] args) {
        String[] dict = new String[]{"World", "Hello", "Thread", "Write", "Scanner", "Dog"};
        ExecutorService executor = Executors.newCachedThreadPool();
        new Processor(executor).getOccurrences(new URLGenerator().get(100), dict, "./result.txt");
    }
}
