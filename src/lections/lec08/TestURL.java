package lections.lec08;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class TestURL {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("classpath:./text_files/text_1.txt");


        URL.setURLStreamHandlerFactory(new ClassPathProtocol());

        try (InputStreamReader inStream = new InputStreamReader(url.openStream())) {
            int i;
            while ((i = inStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
