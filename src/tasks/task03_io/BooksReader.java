package tasks.task03_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ONLY FOR TESTING
 * Created on 23.01.19.
 *
 * @author Yuri Lupandin
 * @version 1.0
 */
public class BooksReader {
    private String textUrl = "http://www.gutenberg.org/files/12345/12345.txt";
    private String urlTemplate = "http://www.gutenberg.org/files/";
    private String regexSentense = "[A-Z][\\w\\d\\s-,]+[.!?]";

    public BooksReader(String textUrl) {
        this.textUrl = textUrl;
    }

    public BooksReader() {
    }


    public static void main(String[] args) throws MalformedURLException {
        System.out.println(new BooksReader().getTextV2());
    }


    public String getTextV2() throws MalformedURLException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(textUrl);

        try (Scanner scanner = new Scanner(url.openStream())) {
            Pattern pattern = Pattern.compile(regexSentense);
            while (scanner.hasNext(pattern)) {
                System.out.println(scanner.next(pattern));


            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return stringBuilder.toString();
    }


    public String getTextV1() throws MalformedURLException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(getTextUrl());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            int i;
            while ((i = reader.read()) > 0) {
                stringBuilder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return stringBuilder.toString();
    }


    public String getTextUrl() {
        int random = new Random().nextInt(10000) + 1;
        return urlTemplate + random + "/" + random + ".txt";
    }


    public String getTextUrl(int num) {
        return urlTemplate + num + "/" + num + ".txt";
    }
}
