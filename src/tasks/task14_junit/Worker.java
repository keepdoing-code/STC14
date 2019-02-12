package tasks.task14_junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created on 24.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Worker implements Callable<String> {
    private final static Logger log = LoggerFactory.getLogger(Dictionary.class);
    public static int count = 0;
    private final String[] words;
    private final ResourceLoader loader;

    public Worker(ResourceLoader loader, String[] words) {
        this.words = words;
        this.loader = loader;
    }

    @Override
    public String call() throws Exception {
        log.info("process started");
        StringBuilder result = new StringBuilder();
        List<String> text = loader.get();

        for (String sentence : text) {
            Dictionary sentenceDict = new Dictionary().fill(sentence);

            if (sentenceDict.getOccurrence(words)) {
                result.append(sentence).append("\r\n");
                count++;
            }
        }
        return result.toString();
    }
}
