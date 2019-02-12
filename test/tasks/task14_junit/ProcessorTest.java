package tasks.task14_junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.Executors;

/**
 * Created on 12/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ProcessorTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Check for RuntimeException with empty sources and words
     *
     * @throws Exception
     */
    @Test
    public void testGetOccurrences() throws Exception {
        thrown.expect(RuntimeException.class);
        Processor processor = new Processor(Executors.newFixedThreadPool(1));
        processor.getOccurrences(new String[]{" "}, new String[]{" "}, "test.txt");
    }
}