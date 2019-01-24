package tasks.task04_concurrency;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created on 24.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Worker implements Callable<String> {
    public static int count = 0;
    private final String[] words;
    private final ResourceLoader loader;

    public Worker(String source, String[] words) {
        this.words = words;
        loader = new ResourceLoader(source);
    }

    @Override
    public String call() throws Exception {
        Loger.i("process started");

        StringBuilder result = new StringBuilder();
        List<String> text = loader.get();


//        for(String sentence: text){
//            for(String word: words){
//                if(sentence.contains(word)){
//                    Loger.i("found: " + word);
//                    result.append(sentence).append("\r\n");
//                    count++;
//                }
//            }
//        }
//
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
