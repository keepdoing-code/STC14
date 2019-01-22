package tasks.task03_io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Dictionary {
    private final int size;
    private Set<String> dictionarySet;
    private String[] dictionaryString;
    private IWordGenerator generator;

    public Dictionary(int numberOfWords, IWordGenerator generator) {
        this.size = numberOfWords;
        this.generator = generator;
    }


    public Set<String> generate() {
        dictionarySet = new HashSet<>();
        dictionaryString = new String[size];
        int counter = 0;

        while (counter < size) {
            String word = generator.generateWord();
            if (dictionarySet.add(word)) {
                counter++;
            }
        }

        dictionaryString = dictionarySet.toArray(dictionaryString);
        return dictionarySet;
    }


    public String getRandomWord(int probability) {
        int rnd = (int) (Math.random() * (1.0 / probability) * dictionarySet.size());
        return dictionaryString[rnd];
    }


    public String[] asArray() {
        return dictionaryString;
    }


    public String asString(String separator) {
        StringBuilder sb = new StringBuilder();
        for (String str : dictionarySet) {
            sb.append(str).append(separator);
        }
        return sb.toString();
    }

}
