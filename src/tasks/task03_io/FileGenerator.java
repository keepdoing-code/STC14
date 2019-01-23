package tasks.task03_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 22.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class FileGenerator {
    private static final String FILENAME = "file.txt";
    private TextGenerator textGen;
    private File file;

    public FileGenerator(TextGenerator textGen) {
        this.textGen = textGen;
    }

    public void getFiles(String path, int filesNumber, int fileSize) {
        File filePath = new File(path);
        if (!filePath.exists() && !filePath.mkdir()) {
            System.out.println("IO Error occured. No files created.");
            return; // TODO: 23.01.19 throw exception
        }

        for (int i = 1; i <= filesNumber; i++) {
            String data = textGen.generateNew(fileSize);
            file = new File(path, "text_" + i + ".txt");
            writeFile(file, data);
        }
    }


    public boolean writeFile(File name, String data) {
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(name))) {
            bufWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
