package tasks.task14_junit;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created on 11/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class WorkerTest {

    @Test
    public void testCall() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("This is first sentence, yes.");
        list.add("This,  is second, sentence!");

        ResourceLoader loader = Mockito.mock(ResourceLoader.class);
        when(loader.get()).thenReturn(list);

        String[] words = {"yes", "hello"};
        Worker worker = new Worker(loader, words);

        assertTrue(list.get(0).equals(loader.get().get(0)));
    }
}