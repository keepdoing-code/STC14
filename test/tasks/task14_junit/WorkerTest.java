package tasks.task14_junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created on 11/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class WorkerTest {
    List<String> list = new ArrayList<>();
    ResourceLoader loader = Mockito.mock(ResourceLoader.class);
    String[] words = {"yes", "hello"};

    /**
     * Prepare input and expected data
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        list.add("This is first sentence, yes.");
        list.add("This,  is second, sentence!");
        when(loader.get()).thenReturn(list);
    }

    /**
     * Test main comparing class, that returns sentence with occurred words
     *
     * @throws Exception
     */
    @Test
    public void testCall() throws Exception {
        Worker worker = new Worker(loader, words);
        assertEquals(list.get(0) + "\r\n", worker.call());
    }
}