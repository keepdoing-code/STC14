package tasks.task14_junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created on 12/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ResourceLoaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Negative test - if empty source entered
     *
     * @throws Exception
     */
    @Test
    public void testGetData() throws Exception {
        thrown.expect(FileNotFoundException.class);
        ResourceLoader res = new ResourceLoader("");
        res.get();
    }

    /**
     * Check correct text to sentences parsing
     *
     * @throws Exception
     */
    @Test
    public void testGet() throws Exception {
        String str = " First!  Second\r\n string. Third?  ";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        ResourceLoader res = new ResourceLoader("");
        List<String> list = res.getData(inputStream);
        assertEquals("First!", list.get(0));
        assertEquals("Second string.", list.get(1));
        assertEquals("Third?", list.get(2));

    }
}