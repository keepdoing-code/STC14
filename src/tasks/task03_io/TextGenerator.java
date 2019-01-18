package tasks.task03_io;

import java.util.Random;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class TextGenerator {
    private StringBuilder text = new StringBuilder();
    private Random rnd = new Random();
    private char[] ender = new char[]{'!', '?', '.'};

    public static void main(String[] args) {
        TextGenerator textGenerator = new TextGenerator();
        System.out.println(textGenerator.genParagraph());
    }

    public String genParagraph() {
        for (int i = 0; i < rnd.nextInt(20); i++) {
            genSentence();
            text.append("\n\r");
        }
        return text.toString();
    }

    public void genSentence() {
        text.append(genWord(true)).append(getComma());
        for (int i = 0; i < rnd.nextInt(14); i++) {
            text.append(genWord(false));
            text.append(getComma());
        }
        text.append(genWord(false));
        text.append(getEnder());
    }

    public String genWord(boolean first) {
        StringBuilder sb = new StringBuilder();
        if (first) {
            sb.append(getChar(true));
        }

        for (int i = 0; i < rnd.nextInt(15); i++) {
            sb.append(getChar(false));
        }
        return sb.toString();
    }

    public char getChar(boolean capital) {
        return capital ?
                (char) (Math.random() * ('Z' - 'A') + 'A') :
                (char) (Math.random() * ('z' - 'a') + 'a');
    }

    public String getComma() {
        return rnd.nextBoolean() ? ", " : " ";
    }

    public String getEnder() {
        return ender[rnd.nextInt(3)] + " ";
    }

    public void write(String str) {
        System.out.printf(str);
    }
}
