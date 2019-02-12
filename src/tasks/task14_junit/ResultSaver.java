package tasks.task14_junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ResultSaver implements AutoCloseable {
    private final static Logger log = LoggerFactory.getLogger(Dictionary.class);
    private Writer writer;

    public ResultSaver(Writer bufferedWriter) throws IOException {
        writer = bufferedWriter;
        writer.write("");
        writer.flush();
        writer.close();
        writer = bufferedWriter;
    }

    public synchronized void writeFile(String data) throws IOException {
        if (data.length() > 0) {
            log.info("write file");
            writer.write(data);
            writer.write("\r\n");
        }
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
