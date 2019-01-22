package tasks.task03_io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class FileGenerator {
    private static final String FILENAME = "file.txt";

    public static void getFiles(String path, int number, int size, String[] words, int probability) {

    }

    public String readFile(String name) {
        String str = "";
        try (FileInputStream fi = new FileInputStream(name)) {
            BufferedInputStream bufinp = new BufferedInputStream(fi);
            byte[] buffer = new byte[fi.available()];
            bufinp.read(buffer);
            str = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public boolean writeFile(String name, String data) {
        try (FileOutputStream fo = new FileOutputStream(name)) {
            byte[] buffer = data.getBytes();
            fo.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
