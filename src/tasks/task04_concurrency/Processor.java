package tasks.task04_concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created on 24.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Processor {
    private static final List<Future<String>> futures = new ArrayList<>();
    private final ExecutorService executorSrv;

    public Processor(ExecutorService executorService) {
        this.executorSrv = executorService;
    }

    public void getOccurrences(String[] sources, String[] words, String res) {
        Loger.i("< started >");
        long inTime = System.currentTimeMillis();

        for (String source : sources) {
            final Worker worker = new Worker(source, words);
            final Future<String> future = executorSrv.submit(worker);
            futures.add(future);
        }


        try (ResultSaver saver = new ResultSaver(res)) {
            for (Future<String> future : futures) {
                saver.writeFile(future.get());
            }
            Loger.i("< end >");
            Loger.i("< all occurrences: " + Worker.count + " >");
            executorSrv.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Loger.i("time: " + (System.currentTimeMillis() - inTime) / 1000.0 + " sec");
    }
}
