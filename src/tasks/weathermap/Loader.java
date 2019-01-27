package tasks.weathermap;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 26/01/19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class Loader {
    static String urlFormat = "https://maps.darksky.net/@temperature,2019-1-24,0,45.324,109.127,2";
    static URL url;


    public static void main(String[] args) throws MalformedURLException {
        url = new URL(urlFormat);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
             FileOutputStream writer = new FileOutputStream("wether.txt")) {

            int data;
            while ((data = reader.read()) > 0) {
                writer.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
