package tasks.task14_junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
    private final static Logger log = LoggerFactory.getLogger(Dictionary.class);
    private static final List<Future<String>> futures = new ArrayList<>();
    private final ExecutorService executorSrv;

    public Processor(ExecutorService executorService) {
        this.executorSrv = executorService;
    }

    public void getOccurrences(String[] sources, String[] words, String res) {
        log.info("< started >");
        long inTime = System.currentTimeMillis();

        for (String source : sources) {
            final ResourceLoader loader = new ResourceLoader(source);
            final Worker worker = new Worker(loader, words);
            final Future<String> future = executorSrv.submit(worker);
            futures.add(future);
        }


        try (ResultSaver saver = new ResultSaver(new BufferedWriter(new FileWriter(res)))) {
            for (Future<String> future : futures) {
                saver.writeFile(future.get());
            }
            log.info("< end >");
            log.info("< all occurrences: {} >", Worker.count);
            executorSrv.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        double time = (System.currentTimeMillis() - inTime) / 1000.0;
        log.info("time: {}", time > 60 ? (time / 60) + " min" : time + " sec");
    }
}
