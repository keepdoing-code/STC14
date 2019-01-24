package tasks.task04_concurrency;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class ResultSaver implements AutoCloseable {
    private BufferedWriter writer;

    public ResultSaver(String filename) throws IOException {
        writer = new BufferedWriter(new FileWriter(filename));
        writer.write("");
        writer.flush();
        writer.close();

        writer = new BufferedWriter(new FileWriter(filename));

    }

    public synchronized void writeFile(String data) throws IOException {
        if (data.length() > 0) {
            Loger.i("write file");
            writer.write(data);
            writer.write("\r\n");
        }
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
