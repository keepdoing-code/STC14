package tasks.task03_io;

import java.util.Random;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class WordGenerator implements IWordGenerator {

    public static char genChar() {
        return (char) (Math.random() * ('z' - 'a') + 'a');
    }

    @Override
    public String generateWord() {
        int size = new Random().nextInt(wordSize) + 1;
        char[] ch = new char[size];

        for (int i = 0; i < size; i++) {
            ch[i] = genChar();
        }
        return new String(ch);
    }
}
