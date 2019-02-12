package tasks.task14_junit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created on 12/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class URLGeneratorTest {
    private static final int NUMBER_OF_URLS = 2;
    private static final String URL_TEMPLATE = "http:\\/\\/www.gutenberg.org\\/files\\/\\d+\\/\\d+.txt";

    /**
     * Test generated url correct and matches URL_TEMPLATE
     *
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        URLGenerator urlGenerator = new URLGenerator();
        String[] urlsArray = urlGenerator.get(NUMBER_OF_URLS);

        for (String urlSrc : urlsArray) {
            assertTrue(urlSrc.matches(URL_TEMPLATE));
        }
    }
}