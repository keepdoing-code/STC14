package tasks.task03_io;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Main {
    private static final String PATH = "./text_files";
    private static final int NUMBER_OF_FILES = 10;
    private static final int SIZE = 40;
    private static final int PROBABILITY = 10;
    private static final int NUMBER_OF_WORDS = 1000;


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(PROBABILITY, NUMBER_OF_WORDS, new WordGenerator());
        TextGenerator text = new TextGenerator(dictionary);
        FileGenerator fileGen = new FileGenerator(text);
        fileGen.getFiles(PATH, NUMBER_OF_FILES, SIZE);
    }
}

