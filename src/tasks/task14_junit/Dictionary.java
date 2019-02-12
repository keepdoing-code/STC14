package tasks.task14_junit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Dictionary {
    private final static Logger log = LoggerFactory.getLogger(Dictionary.class);
    private Set<String> dictionary = new HashSet<>();
    private String[] words;
    private int size = 0;

    public Dictionary fill(String sentence) {
        words = sentence.replaceAll("\\W+", " ").split(" ");

        for (String str : words) {
            str = str.toLowerCase();
            dictionary.add(str);
        }
        size = dictionary.size();
        return this;
    }

    public String[] get() {
        words = dictionary.toArray(new String[size]);
        return words;
    }

    public boolean getOccurrence(String[] another) {
        for (String str : another) {
            if (this.dictionary.contains(str.toLowerCase())) {
                log.info("found: ", str);
                return true;
            }
        }
        return false;
    }
}
