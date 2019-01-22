package tasks.task03_io;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class TextGenerator implements IWordGenerator {
    private static final char[] ender = new char[]{'!', '?', '.'};
    private StringBuilder text;

    public static String genParagraph(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < genRandom(number); i++) {
            sb.append(genSentence(15));
        }
        return sb.append("\r\n").toString();
    }

    public static String genSentence(int number) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        int rnd = genRandom(number);
        sb.append(genWord(true));
        sb.append(counter == rnd ? genEnder() : genComma());

        while (++counter <= rnd) {
            sb.append(genWord(false));
            sb.append(counter == rnd ? genEnder() : genComma());
        }

        return sb.toString();
    }

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

    public static String genComma() {
        return genRandom(2) == 1 ? ", " : " ";
    }

    public static String genEnder() {
        return ender[genRandom(3) - 1] + " ";
    }

    public static int genRandom(int count) {
        return (int) (Math.random() * count + 1);
    }

    @Override
    public String generateWord() {
        return genWord(false);
    }

    public String getText() {
        return text == null ? generate(20) : text.toString();
    }

    public String generate(int paragraphNumber) {
        text = new StringBuilder();
        for (int i = 0; i < genRandom(paragraphNumber); i++) {
            text.append(genParagraph(20));
        }
        return text.toString();
    }


}
