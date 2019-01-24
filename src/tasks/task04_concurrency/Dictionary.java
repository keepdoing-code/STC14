package tasks.task04_concurrency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Dictionary {
    private Set<String> dictionary = new HashSet<>();
    private String[] words;
    private int size = 0;


    public Dictionary() {
    }


    public Dictionary fillFromList(List<String> list) {
        for (String str : list) {
            fill(str);
        }
        return this;
    }


    public Dictionary fill(String sentence) {
        words = sentence.replaceAll("\\W+", " ").split(" ");

        for (String str : words) {
//            Loger.i("dictionary: '" + str + "'");
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
//            Loger.i("finding "+str);
            if (this.dictionary.contains(str.toLowerCase())) {
                Loger.i("found: " + str);
                return true;
            }
        }
        return false;
    }
}
