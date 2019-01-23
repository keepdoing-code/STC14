package tasks.task03_io;

import java.util.Random;

/**
 * Created on 18.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class TextGenerator {
    private final int RANDOM_SENTENCE_COUNT = 20;
    private final int RANDOM_WORD_COUNT = 15;
    private final String[] LINE_END = {"! ", "? ", ". "};
    private final String[] COMMA = {" ", ", "};
    private StringBuilder text;
    private Random rnd = new Random();
    private Dictionary dictionary;


    public TextGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    public String generateNew(int paragraphCount) {
        text = new StringBuilder();
        for (int i = 0; i < paragraphCount; i++) {
            text.append(genParagraph(RANDOM_SENTENCE_COUNT));
        }
        return text.toString();
    }


    public String genParagraph(int sentenceCount) {
        StringBuilder sb = new StringBuilder();
        int random = rnd.nextInt(sentenceCount) + 1;
        for (int i = 0; i < random; i++) {
            sb.append(genSentence(RANDOM_WORD_COUNT));
        }
        return sb.append("\r\n").toString();
    }


    public String genSentence(int wordCount) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        int random = rnd.nextInt(wordCount);

        do {
            sb.append(counter == 0 ? dictionary.getCapitalWord() : dictionary.getRandomWord());
            sb.append(counter == random ? genPunctuation(LINE_END) : genPunctuation(COMMA));
        } while (counter++ < random);
        return sb.toString();
    }


    public String genPunctuation(String[] chars) {
        return chars[new Random().nextInt(chars.length)];
    }
}
