package lections.lec04;

import java.io.*;

/**
 * Created by yuri on 17.01.19.
 */
public class Main {
    public static void main(String[] args) {

    }

    public static void testFileStreams() throws IOException {
        InputStream inputStream = new FileInputStream(".gitignore");
        System.out.printf("Размер файла: %d", inputStream.available());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(bufferedReader.readLine());
        }
        inputStream.close();
    }
}
