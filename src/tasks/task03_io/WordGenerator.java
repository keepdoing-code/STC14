package tasks.task03_io;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class WordGenerator implements IWordGenerator {
    public static String genWord(boolean capitalChar) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        int rnd = genRandom(wordSize);
        sb.append(genChar(capitalChar));

        while (counter++ < rnd) {
            sb.append(genChar(false));
        }
        return sb.toString();
    }

    public static char genChar(boolean capital) {
        return capital ?
                (char) (Math.random() * ('Z' - 'A') + 'A') :
                (char) (Math.random() * ('z' - 'a') + 'a');
    }

    public static int genRandom(int count) {
        return (int) (Math.random() * count + 1);
    }

    @Override
    public String generateWord() {
        return genWord(false);
    }
}
