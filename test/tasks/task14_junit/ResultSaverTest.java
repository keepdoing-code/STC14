package tasks.task14_junit;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created on 12/02/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ResultSaverTest {
    /**
     * Emulate writing data to file
     *
     * @throws Exception
     */
    @Test
    public void testWriteFile() throws Exception {
        String data = "This is test string, hello world!";
        try (StringWriter fileEmulator = new StringWriter()) {
            ResultSaver saver = new ResultSaver(fileEmulator);
            saver.writeFile(data);
            assertEquals(data + "\r\n", fileEmulator.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}