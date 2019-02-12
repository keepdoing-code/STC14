package tasks.task14_junit;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created on 11/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class DictionaryTest {


    @Test
    public void testGet() throws Exception {
        Dictionary dictionary = new Dictionary();
        dictionary.fill("This is!   test, \r\n  sentence.");
        String[] array = dictionary.get();
        assertTrue(Arrays.asList(array).containsAll(Arrays.asList("sentence", "test", "this", "is")));
    }

    @Test
    public void testGetOccurrence() throws Exception {
        Dictionary dictionary = new Dictionary();
        dictionary.fill("This is!   test, \r\n  sentence.");
        assertTrue(dictionary.getOccurrence(new String[]{"is", "test"}));
    }
}