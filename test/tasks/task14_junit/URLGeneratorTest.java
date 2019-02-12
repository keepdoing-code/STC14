package tasks.task14_junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Created on 12/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class URLGeneratorTest {
    private static final int NUMBER_OF_URLS = 10;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private String URL_TEMPLATE = "http://www.gutenberg.org/files/%1$s/%1$s.txt";

    @Test
    public void testGet() throws Exception {
        URLGenerator urlGenerator = new URLGenerator();
        String[] urlsArray = urlGenerator.get(NUMBER_OF_URLS);

        for (String urlSrc : urlsArray) {
            assertTrue(urlSrc.matches("http:\\/\\/www.gutenberg.org\\/files\\/\\d+\\/\\d+.txt"));
        }
    }
}